/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hwhueng.activiti.controller.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.exception.BusinessException;
import com.hwhueng.activiti.request.ModelRequest;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Tijs Rademakers
 */
@RestController
public class ModelSaveRestResource implements ModelDataJsonConstants {
  
  protected static final Logger LOGGER = LoggerFactory.getLogger(ModelSaveRestResource.class);

  @Resource
  private RepositoryService repositoryService;
  
  @Resource
  private ObjectMapper objectMapper;

  @RequestMapping(value="/model/test")
  @ResponseBody
  public Resp<String> test(){
    return new Resp<>("Hello");
  }

  @RequestMapping(value="/model/save", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.OK)
  @Transactional(rollbackFor = Exception.class)
  public Resp<String> saveModel(@RequestBody ModelRequest request) {
    try {
      Model model = repositoryService.getModel(request.getModelId());
      
      ObjectNode modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
      
      modelJson.put(MODEL_NAME, request.getName());
      modelJson.put(MODEL_DESCRIPTION, request.getDescription());
      model.setMetaInfo(modelJson.toString());
      model.setName(request.getName());
      
      repositoryService.saveModel(model);
      
      repositoryService.addModelEditorSource(model.getId(), request.getJsonXml().getBytes(StandardCharsets.UTF_8));
      
      InputStream svgStream = new ByteArrayInputStream(request.getSvgXml().getBytes(StandardCharsets.UTF_8));
      TranscoderInput input = new TranscoderInput(svgStream);
      
      PNGTranscoder transcoder = new PNGTranscoder();
      // Setup output
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      TranscoderOutput output = new TranscoderOutput(outStream);
      
      // Do the transformation
      transcoder.transcode(input, output);
      final byte[] result = outStream.toByteArray();
      repositoryService.addModelEditorSourceExtra(model.getId(), result);
      outStream.close();
      
    } catch (Exception e) {
      LOGGER.error("Error saving model", e);
      throw new BusinessException("Error saving model", e);
    }
    return new Resp<>();
  }
}
