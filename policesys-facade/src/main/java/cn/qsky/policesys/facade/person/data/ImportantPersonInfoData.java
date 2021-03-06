package cn.qsky.policesys.facade.person.data;

import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 17/12/6
 */
public class ImportantPersonInfoData {

  private String ext1;

  private String name;

  private String idCard;

  private Boolean sex;

  private String nation;

  private Byte age;

  private String groupType;

  private String controlKeyword;

  private String maritalStatus;

  private String domicile;

  private String residence;

  private String jurisdiction;

  private String juriPolice;

  private String education;

  private String veteranStatus;

  private String job;

  private String workPlace;

  private String workStatus;

  private String controlReason;

  private String remark;

  private Boolean deleteFlag;

  private String phoneText;

  private String wechatNameText;

  private List<ImportantPersonRecordData> records;

  public String getExt1() {
    return ext1;
  }

  public void setExt1(String ext1) {
    this.ext1 = ext1;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public Byte getAge() {
    return age;
  }

  public void setAge(Byte age) {
    this.age = age;
  }

  public String getGroupType() {
    return groupType;
  }

  public void setGroupType(String groupType) {
    this.groupType = groupType;
  }

  public String getControlKeyword() {
    return controlKeyword;
  }

  public void setControlKeyword(String controlKeyword) {
    this.controlKeyword = controlKeyword;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getDomicile() {
    return domicile;
  }

  public void setDomicile(String domicile) {
    this.domicile = domicile;
  }

  public String getResidence() {
    return residence;
  }

  public void setResidence(String residence) {
    this.residence = residence;
  }

  public String getJurisdiction() {
    return jurisdiction;
  }

  public void setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction;
  }

  public String getJuriPolice() {
    return juriPolice;
  }

  public void setJuriPolice(String juriPolice) {
    this.juriPolice = juriPolice;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getVeteranStatus() {
    return veteranStatus;
  }

  public void setVeteranStatus(String veteranStatus) {
    this.veteranStatus = veteranStatus;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getWorkPlace() {
    return workPlace;
  }

  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace;
  }

  public String getWorkStatus() {
    return workStatus;
  }

  public void setWorkStatus(String workStatus) {
    this.workStatus = workStatus;
  }

  public String getControlReason() {
    return controlReason;
  }

  public void setControlReason(String controlReason) {
    this.controlReason = controlReason;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public String getPhoneText() {
    return phoneText;
  }

  public void setPhoneText(String phoneText) {
    this.phoneText = phoneText;
  }

  public String getWechatNameText() {
    return wechatNameText;
  }

  public void setWechatNameText(String wechatNameText) {
    this.wechatNameText = wechatNameText;
  }

  public List<ImportantPersonRecordData> getRecords() {
    return records;
  }

  public void setRecords(
      List<ImportantPersonRecordData> records) {
    this.records = records;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
