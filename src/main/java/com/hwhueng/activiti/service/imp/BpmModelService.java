package com.hwhueng.activiti.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.exception.BusinessException;
import com.hwhueng.activiti.service.IBpmModelService;
import com.hwhueng.activiti.vo.DeployModelVo;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class BpmModelService implements IBpmModelService {
    private final static Logger log = LoggerFactory.getLogger(BpmModelService.class);

    @Autowired
    RepositoryService repositoryService;

    public Model createModel(){
        String name = "name";
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        Model modelData = repositoryService.newModel();

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, "description");
        modelData.setMetaInfo(modelObjectNode.toString());
        modelData.setName(name);
        modelData.setKey(StringUtils.defaultString("key"));

        repositoryService.saveModel(modelData);
        byte [] bytes = new byte[0];
        try{
            bytes = editorNode.toString().getBytes("utf-8");
        }catch (UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
        repositoryService.addModelEditorSource(modelData.getId(), bytes);
        return modelData;
    }

    @Transactional
    public String deleteModel(String modelId){
        if(StringUtils.isEmpty(modelId)){
            throw new BusinessException("模型Id为空");
        }
        repositoryService.deleteModel(modelId);
        return "删除模型成功";
    }

    @Transactional(rollbackFor = Exception.class)
    public Resp<String> deployModel(DeployModelVo vo){
        if(StringUtils.isEmpty(vo.getModelId())){
            throw new BusinessException("模型Id不能为空");
        }

        Model modelData = repositoryService.getModel(vo.getModelId());
        try{
            byte [] editData = repositoryService.getModelEditorSource(modelData.getId());
            if(editData == null){
                throw new BusinessException("模型数据为空, 请先设计并保存流程");
            }
            ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(editData);
            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
                    .addString(processName, new String(bpmnBytes, StandardCharsets.UTF_8)).deploy();
            modelData.setDeploymentId(deployment.getId());
            repositoryService.saveModel(modelData);
        } catch (IOException e) {
            log.error("部署失败: id {} msg: {}", vo.getModelId(), e.getMessage());
            throw new BusinessException("部署失败");
        }

        return new Resp<>("部署成功");
    }
}
