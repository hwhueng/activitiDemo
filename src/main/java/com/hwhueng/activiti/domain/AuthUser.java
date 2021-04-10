package com.hwhueng.activiti.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("sap_emp_sync_info")
public class AuthUser implements Serializable {

  private static final long serialVersionUID = -8823948112828136121L;
  private String pernr;

  private String ename;

  private String empid;

  private String orgeh;

  private String orgtx;

  private String plans;

  private String plstx;

  private String gesch;

  private LocalDateTime gbdat;

  private String natio;

  private String nattx;

  private String race;

  private String ractx;

  private String icnum;

  private String passport;

  private String stat2;

  private String phone;

  private String cell;

  private String mail;

  private LocalDateTime hiredate;

  private String werks;

  private String patxt;

  private String btrtl;

  private String btext;

  private String persg;

  private String pgtxt;

  private String persk;

  private String pktxt;

  private String area;

  private String jiguan;

  private String deptpath;

  private String rsv01;

  private String rsv02;

  private String rsv03;

  private String rsv04;

  private String rsv05;

  private String rsv06;
  // @ApiModelProperty(value = "兼职组织ID及岗位ID")
  private String rsv07;
  // @ApiModelProperty(value = "预留字段08")
  private String rsv08;
  // @ApiModelProperty(value = "预留字段09")
  private String rsv09;
  // @ApiModelProperty(value = "预留字段10")
  private String rsv10;
  // @ApiModelProperty(value = "预留字段11")
  private String rsv11;
  // @ApiModelProperty(value = "预留字段12")
  private String rsv12;
  // @ApiModelProperty(value = "预留字段13")
  private String rsv13;
  // @ApiModelProperty(value = "预留字段14")
  private String rsv14;
  // @ApiModelProperty(value = "预留字段15")
  private String rsv15;
  // @ApiModelProperty(value = "预留字段16")
  private String rsv16;
  // @ApiModelProperty(value = "预留字段17")
  private String rsv17;
  // @ApiModelProperty(value = "预留字段18")
  private String rsv18;
  // @ApiModelProperty(value = "预留字段19")
  private String rsv19;
  // @ApiModelProperty(value = "预留字段20")
  private String rsv20;
  // @ApiModelProperty(value = "预留字段21")
  private String rsv21;
  // @ApiModelProperty(value = "预留字段22")
  private String rsv22;
  // @ApiModelProperty(value = "预留字段23")
  private String rsv23;
  // @ApiModelProperty(value = "预留字段24")
  private String rsv24;
  // @ApiModelProperty(value = "预留字段25")
  private String rsv25;
  // @ApiModelProperty(value = "预留字段26")
  private String rsv26;
  // @ApiModelProperty(value = "预留字段27")
  private String rsv27;
  // @ApiModelProperty(value = "预留字段28")
  private String rsv28;
  // @ApiModelProperty(value = "预留字段29")
  private String rsv29;
  // @ApiModelProperty(value = "预留字段30")
  private String rsv30;
  // @ApiModelProperty(value = "预留字段31")
  private String rsv31;
  // @ApiModelProperty(value = "预留字段32")
  private String rsv32;
  // @ApiModelProperty(value = "预留字段33")
  private String rsv33;
  // @ApiModelProperty(value = "预留字段34")
  private String rsv34;
  // @ApiModelProperty(value = "预留字段")
  private String mail1;

  private String zbuffer1;

  private String zbuffer2;

  private String zbuffer3;

  private String zbuffer4;

  private String zbuffer5;

  private String zbuffer6;

  private String zbuffer7;

  private String zbuffer8;

  private String zbuffer9;

  private String zbuffer10;

  public String getJobLevel() {
    return StringUtils.isNotBlank(this.rsv04) ? this.rsv04.split("\\+")[0] : null;
  }
  public Boolean isManager() {
    return Lists.newArrayList("10","20","30").contains(this.rsv08) || "1".equals(this.rsv08);
  }

  public String getPernr() {
    return pernr;
  }

  public void setPernr(String pernr) {
    this.pernr = pernr;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getEmpid() {
    return empid;
  }

  public void setEmpid(String empid) {
    this.empid = empid;
  }

  public String getOrgeh() {
    return orgeh;
  }

  public void setOrgeh(String orgeh) {
    this.orgeh = orgeh;
  }

  public String getOrgtx() {
    return orgtx;
  }

  public void setOrgtx(String orgtx) {
    this.orgtx = orgtx;
  }

  public String getPlans() {
    return plans;
  }

  public void setPlans(String plans) {
    this.plans = plans;
  }

  public String getPlstx() {
    return plstx;
  }

  public void setPlstx(String plstx) {
    this.plstx = plstx;
  }

  public String getGesch() {
    return gesch;
  }

  public void setGesch(String gesch) {
    this.gesch = gesch;
  }

  public LocalDateTime getGbdat() {
    return gbdat;
  }

  public void setGbdat(LocalDateTime gbdat) {
    this.gbdat = gbdat;
  }

  public String getNatio() {
    return natio;
  }

  public void setNatio(String natio) {
    this.natio = natio;
  }

  public String getNattx() {
    return nattx;
  }

  public void setNattx(String nattx) {
    this.nattx = nattx;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getRactx() {
    return ractx;
  }

  public void setRactx(String ractx) {
    this.ractx = ractx;
  }

  public String getIcnum() {
    return icnum;
  }

  public void setIcnum(String icnum) {
    this.icnum = icnum;
  }

  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public String getStat2() {
    return stat2;
  }

  public void setStat2(String stat2) {
    this.stat2 = stat2;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCell() {
    return cell;
  }

  public void setCell(String cell) {
    this.cell = cell;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public LocalDateTime getHiredate() {
    return hiredate;
  }

  public void setHiredate(LocalDateTime hiredate) {
    this.hiredate = hiredate;
  }

  public String getWerks() {
    return werks;
  }

  public void setWerks(String werks) {
    this.werks = werks;
  }

  public String getPatxt() {
    return patxt;
  }

  public void setPatxt(String patxt) {
    this.patxt = patxt;
  }

  public String getBtrtl() {
    return btrtl;
  }

  public void setBtrtl(String btrtl) {
    this.btrtl = btrtl;
  }

  public String getBtext() {
    return btext;
  }

  public void setBtext(String btext) {
    this.btext = btext;
  }

  public String getPersg() {
    return persg;
  }

  public void setPersg(String persg) {
    this.persg = persg;
  }

  public String getPgtxt() {
    return pgtxt;
  }

  public void setPgtxt(String pgtxt) {
    this.pgtxt = pgtxt;
  }

  public String getPersk() {
    return persk;
  }

  public void setPersk(String persk) {
    this.persk = persk;
  }

  public String getPktxt() {
    return pktxt;
  }

  public void setPktxt(String pktxt) {
    this.pktxt = pktxt;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getJiguan() {
    return jiguan;
  }

  public void setJiguan(String jiguan) {
    this.jiguan = jiguan;
  }

  public String getDeptpath() {
    return deptpath;
  }

  public void setDeptpath(String deptpath) {
    this.deptpath = deptpath;
  }

  public String getRsv01() {
    return rsv01;
  }

  public void setRsv01(String rsv01) {
    this.rsv01 = rsv01;
  }

  public String getRsv02() {
    return rsv02;
  }

  public void setRsv02(String rsv02) {
    this.rsv02 = rsv02;
  }

  public String getRsv03() {
    return rsv03;
  }

  public void setRsv03(String rsv03) {
    this.rsv03 = rsv03;
  }

  public String getRsv04() {
    return rsv04;
  }

  public void setRsv04(String rsv04) {
    this.rsv04 = rsv04;
  }

  public String getRsv05() {
    return rsv05;
  }

  public void setRsv05(String rsv05) {
    this.rsv05 = rsv05;
  }

  public String getRsv06() {
    return rsv06;
  }

  public void setRsv06(String rsv06) {
    this.rsv06 = rsv06;
  }

  public String getRsv07() {
    return rsv07;
  }

  public void setRsv07(String rsv07) {
    this.rsv07 = rsv07;
  }

  public String getRsv08() {
    return rsv08;
  }

  public void setRsv08(String rsv08) {
    this.rsv08 = rsv08;
  }

  public String getRsv09() {
    return rsv09;
  }

  public void setRsv09(String rsv09) {
    this.rsv09 = rsv09;
  }

  public String getRsv10() {
    return rsv10;
  }

  public void setRsv10(String rsv10) {
    this.rsv10 = rsv10;
  }

  public String getRsv11() {
    return rsv11;
  }

  public void setRsv11(String rsv11) {
    this.rsv11 = rsv11;
  }

  public String getRsv12() {
    return rsv12;
  }

  public void setRsv12(String rsv12) {
    this.rsv12 = rsv12;
  }

  public String getRsv13() {
    return rsv13;
  }

  public void setRsv13(String rsv13) {
    this.rsv13 = rsv13;
  }

  public String getRsv14() {
    return rsv14;
  }

  public void setRsv14(String rsv14) {
    this.rsv14 = rsv14;
  }

  public String getRsv15() {
    return rsv15;
  }

  public void setRsv15(String rsv15) {
    this.rsv15 = rsv15;
  }

  public String getRsv16() {
    return rsv16;
  }

  public void setRsv16(String rsv16) {
    this.rsv16 = rsv16;
  }

  public String getRsv17() {
    return rsv17;
  }

  public void setRsv17(String rsv17) {
    this.rsv17 = rsv17;
  }

  public String getRsv18() {
    return rsv18;
  }

  public void setRsv18(String rsv18) {
    this.rsv18 = rsv18;
  }

  public String getRsv19() {
    return rsv19;
  }

  public void setRsv19(String rsv19) {
    this.rsv19 = rsv19;
  }

  public String getRsv20() {
    return rsv20;
  }

  public void setRsv20(String rsv20) {
    this.rsv20 = rsv20;
  }

  public String getRsv21() {
    return rsv21;
  }

  public void setRsv21(String rsv21) {
    this.rsv21 = rsv21;
  }

  public String getRsv22() {
    return rsv22;
  }

  public void setRsv22(String rsv22) {
    this.rsv22 = rsv22;
  }

  public String getRsv23() {
    return rsv23;
  }

  public void setRsv23(String rsv23) {
    this.rsv23 = rsv23;
  }

  public String getRsv24() {
    return rsv24;
  }

  public void setRsv24(String rsv24) {
    this.rsv24 = rsv24;
  }

  public String getRsv25() {
    return rsv25;
  }

  public void setRsv25(String rsv25) {
    this.rsv25 = rsv25;
  }

  public String getRsv26() {
    return rsv26;
  }

  public void setRsv26(String rsv26) {
    this.rsv26 = rsv26;
  }

  public String getRsv27() {
    return rsv27;
  }

  public void setRsv27(String rsv27) {
    this.rsv27 = rsv27;
  }

  public String getRsv28() {
    return rsv28;
  }

  public void setRsv28(String rsv28) {
    this.rsv28 = rsv28;
  }

  public String getRsv29() {
    return rsv29;
  }

  public void setRsv29(String rsv29) {
    this.rsv29 = rsv29;
  }

  public String getRsv30() {
    return rsv30;
  }

  public void setRsv30(String rsv30) {
    this.rsv30 = rsv30;
  }

  public String getRsv31() {
    return rsv31;
  }

  public void setRsv31(String rsv31) {
    this.rsv31 = rsv31;
  }

  public String getRsv32() {
    return rsv32;
  }

  public void setRsv32(String rsv32) {
    this.rsv32 = rsv32;
  }

  public String getRsv33() {
    return rsv33;
  }

  public void setRsv33(String rsv33) {
    this.rsv33 = rsv33;
  }

  public String getRsv34() {
    return rsv34;
  }

  public void setRsv34(String rsv34) {
    this.rsv34 = rsv34;
  }

  public String getMail1() {
    return mail1;
  }

  public void setMail1(String mail1) {
    this.mail1 = mail1;
  }

  public String getZbuffer1() {
    return zbuffer1;
  }

  public void setZbuffer1(String zbuffer1) {
    this.zbuffer1 = zbuffer1;
  }

  public String getZbuffer2() {
    return zbuffer2;
  }

  public void setZbuffer2(String zbuffer2) {
    this.zbuffer2 = zbuffer2;
  }

  public String getZbuffer3() {
    return zbuffer3;
  }

  public void setZbuffer3(String zbuffer3) {
    this.zbuffer3 = zbuffer3;
  }

  public String getZbuffer4() {
    return zbuffer4;
  }

  public void setZbuffer4(String zbuffer4) {
    this.zbuffer4 = zbuffer4;
  }

  public String getZbuffer5() {
    return zbuffer5;
  }

  public void setZbuffer5(String zbuffer5) {
    this.zbuffer5 = zbuffer5;
  }

  public String getZbuffer6() {
    return zbuffer6;
  }

  public void setZbuffer6(String zbuffer6) {
    this.zbuffer6 = zbuffer6;
  }

  public String getZbuffer7() {
    return zbuffer7;
  }

  public void setZbuffer7(String zbuffer7) {
    this.zbuffer7 = zbuffer7;
  }

  public String getZbuffer8() {
    return zbuffer8;
  }

  public void setZbuffer8(String zbuffer8) {
    this.zbuffer8 = zbuffer8;
  }

  public String getZbuffer9() {
    return zbuffer9;
  }

  public void setZbuffer9(String zbuffer9) {
    this.zbuffer9 = zbuffer9;
  }

  public String getZbuffer10() {
    return zbuffer10;
  }

  public void setZbuffer10(String zbuffer10) {
    this.zbuffer10 = zbuffer10;
  }
}