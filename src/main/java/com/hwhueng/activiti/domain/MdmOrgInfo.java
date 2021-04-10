package com.hwhueng.activiti.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("mdm_org_info")
public class MdmOrgInfo implements Serializable {
    private static final long serialVersionUID = -591986162053231523L;
    // @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // @ApiModelProperty(value = "组织单位ID")
    private String OBJID;

    // @ApiModelProperty(value = "组织单位名称")
    private String STEXT;

    // @ApiModelProperty(value = "组织单位简称")
    private String SHORT;

    // @ApiModelProperty(value = "上级组织单位")
    private String PARENT;

    // @ApiModelProperty(value = "组织单位状态:Y/N 是否启用")
    private String STATUS;

    // @ApiModelProperty(value = "组织单位层级")
    private String ORGLV;

    // @ApiModelProperty(value = "组织单元层级路径:由部门编号组成的层级路径,自左向右,左高右低,以逗号分隔")
    private String DEPTPATH;

    // @ApiModelProperty(value = "门店编号")
    private String RSV01;

    // @ApiModelProperty(value = "大店长员工编号")
    private String RSV02;

    // @ApiModelProperty(value = "店铺类型代码:10-大货正价店;20-儿童正价店;30-大货奥莱店;40-儿童奥莱店;50-潮牌正价店;60-潮牌奥莱店;70-专业运动店;80-kingkow正价店;90-kingkow奥莱店;95-特卖店;71-可隆正价店;72-可隆奥莱店;73-迪桑特正价店;74-迪桑特奥莱店")
    private String RSV03;

    // @ApiModelProperty(value = "应出勤天数")
    private String RSV04;

    // @ApiModelProperty(value = "实际天数")
    private String RSV05;

    // @ApiModelProperty(value = "店铺类型文本:10-大货正价店;20-儿童正价店;30-大货奥莱店;40-儿童奥莱店;50-潮牌正价店;60-潮牌奥莱店;70-专业运动店;80-kingkow正价店;90-kingkow奥莱店;95-特卖店;71-可隆正价店;72-可隆奥莱店;73-迪桑特正价店;74-迪桑特奥莱店")
    private String RSV06;

    // @ApiModelProperty(value = "预留字段07")
    private String RSV07;

    // @ApiModelProperty(value = "预留字段08")
    private String RSV08;

    // @ApiModelProperty(value = "预留字段09")
    private String RSV09;

    // @ApiModelProperty(value = "预留字段10")
    private String RSV010;

    // @ApiModelProperty(value = "开始日期")
    private LocalDateTime BEGDA;

    // @ApiModelProperty(value = "结束日期")
    private LocalDateTime ENDDA;

    // @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    // @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOBJID() {
        return OBJID;
    }

    public void setOBJID(String OBJID) {
        this.OBJID = OBJID;
    }

    public String getSTEXT() {
        return STEXT;
    }

    public void setSTEXT(String STEXT) {
        this.STEXT = STEXT;
    }

    public String getSHORT() {
        return SHORT;
    }

    public void setSHORT(String SHORT) {
        this.SHORT = SHORT;
    }

    public String getPARENT() {
        return PARENT;
    }

    public void setPARENT(String PARENT) {
        this.PARENT = PARENT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getORGLV() {
        return ORGLV;
    }

    public void setORGLV(String ORGLV) {
        this.ORGLV = ORGLV;
    }

    public String getDEPTPATH() {
        return DEPTPATH;
    }

    public void setDEPTPATH(String DEPTPATH) {
        this.DEPTPATH = DEPTPATH;
    }

    public String getRSV01() {
        return RSV01;
    }

    public void setRSV01(String RSV01) {
        this.RSV01 = RSV01;
    }

    public String getRSV02() {
        return RSV02;
    }

    public void setRSV02(String RSV02) {
        this.RSV02 = RSV02;
    }

    public String getRSV03() {
        return RSV03;
    }

    public void setRSV03(String RSV03) {
        this.RSV03 = RSV03;
    }

    public String getRSV04() {
        return RSV04;
    }

    public void setRSV04(String RSV04) {
        this.RSV04 = RSV04;
    }

    public String getRSV05() {
        return RSV05;
    }

    public void setRSV05(String RSV05) {
        this.RSV05 = RSV05;
    }

    public String getRSV06() {
        return RSV06;
    }

    public void setRSV06(String RSV06) {
        this.RSV06 = RSV06;
    }

    public String getRSV07() {
        return RSV07;
    }

    public void setRSV07(String RSV07) {
        this.RSV07 = RSV07;
    }

    public String getRSV08() {
        return RSV08;
    }

    public void setRSV08(String RSV08) {
        this.RSV08 = RSV08;
    }

    public String getRSV09() {
        return RSV09;
    }

    public void setRSV09(String RSV09) {
        this.RSV09 = RSV09;
    }

    public String getRSV010() {
        return RSV010;
    }

    public void setRSV010(String RSV010) {
        this.RSV010 = RSV010;
    }

    public LocalDateTime getBEGDA() {
        return BEGDA;
    }

    public void setBEGDA(LocalDateTime BEGDA) {
        this.BEGDA = BEGDA;
    }

    public LocalDateTime getENDDA() {
        return ENDDA;
    }

    public void setENDDA(LocalDateTime ENDDA) {
        this.ENDDA = ENDDA;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}