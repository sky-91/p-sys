package cn.qsky.policesys.core.dao.model;

import java.util.Date;
import java.util.List;

public class ImportantPersonInfoModel {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.PK
   *
   * @mbg.generated
   */
  private Long pk;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.created_time
   *
   * @mbg.generated
   */
  private Date createdTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.modified_time
   *
   * @mbg.generated
   */
  private Date modifiedTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.name
   *
   * @mbg.generated
   */
  private String name;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.id_card
   *
   * @mbg.generated
   */
  private String idCard;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.sex
   *
   * @mbg.generated
   */
  private Boolean sex;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.nation
   *
   * @mbg.generated
   */
  private String nation;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.age
   *
   * @mbg.generated
   */
  private Byte age;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.group_type
   *
   * @mbg.generated
   */
  private String groupType;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.control_keyword
   *
   * @mbg.generated
   */
  private String controlKeyword;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.marital_status
   *
   * @mbg.generated
   */
  private String maritalStatus;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.domicile
   *
   * @mbg.generated
   */
  private String domicile;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.residence
   *
   * @mbg.generated
   */
  private String residence;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.phone_text
   *
   * @mbg.generated
   */
  private String phoneText;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.wechat_name_text
   *
   * @mbg.generated
   */
  private String wechatNameText;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.jurisdiction
   *
   * @mbg.generated
   */
  private String jurisdiction;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.juri_police
   *
   * @mbg.generated
   */
  private String juriPolice;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.education
   *
   * @mbg.generated
   */
  private String education;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.veteran_status
   *
   * @mbg.generated
   */
  private String veteranStatus;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.job
   *
   * @mbg.generated
   */
  private String job;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.work_place
   *
   * @mbg.generated
   */
  private String workPlace;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.work_status
   *
   * @mbg.generated
   */
  private String workStatus;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.control_reason
   *
   * @mbg.generated
   */
  private String controlReason;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.remark
   *
   * @mbg.generated
   */
  private String remark;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.ext1
   *
   * @mbg.generated
   */
  private String ext1;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.ext2
   *
   * @mbg.generated
   */
  private String ext2;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.ext3
   *
   * @mbg.generated
   */
  private String ext3;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * important_person_info.delete_flag
   *
   * @mbg.generated
   */
  private Boolean deleteFlag;

  private List<ImportantPersonRecordModel> records;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.PK
   *
   * @return the value of important_person_info.PK
   * @mbg.generated
   */
  public Long getPk() {
    return pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.PK
   *
   * @param pk the value for important_person_info.PK
   * @mbg.generated
   */
  public void setPk(Long pk) {
    this.pk = pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.created_time
   *
   * @return the value of important_person_info.created_time
   * @mbg.generated
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.created_time
   *
   * @param createdTime the value for important_person_info.created_time
   * @mbg.generated
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.modified_time
   *
   * @return the value of important_person_info.modified_time
   * @mbg.generated
   */
  public Date getModifiedTime() {
    return modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.modified_time
   *
   * @param modifiedTime the value for important_person_info.modified_time
   * @mbg.generated
   */
  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.name
   *
   * @return the value of important_person_info.name
   * @mbg.generated
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.name
   *
   * @param name the value for important_person_info.name
   * @mbg.generated
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.id_card
   *
   * @return the value of important_person_info.id_card
   * @mbg.generated
   */
  public String getIdCard() {
    return idCard;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.id_card
   *
   * @param idCard the value for important_person_info.id_card
   * @mbg.generated
   */
  public void setIdCard(String idCard) {
    this.idCard = idCard == null ? null : idCard.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.sex
   *
   * @return the value of important_person_info.sex
   * @mbg.generated
   */
  public Boolean getSex() {
    return sex;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.sex
   *
   * @param sex the value for important_person_info.sex
   * @mbg.generated
   */
  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.nation
   *
   * @return the value of important_person_info.nation
   * @mbg.generated
   */
  public String getNation() {
    return nation;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.nation
   *
   * @param nation the value for important_person_info.nation
   * @mbg.generated
   */
  public void setNation(String nation) {
    this.nation = nation == null ? null : nation.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.age
   *
   * @return the value of important_person_info.age
   * @mbg.generated
   */
  public Byte getAge() {
    return age;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.age
   *
   * @param age the value for important_person_info.age
   * @mbg.generated
   */
  public void setAge(Byte age) {
    this.age = age;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.group_type
   *
   * @return the value of important_person_info.group_type
   * @mbg.generated
   */
  public String getGroupType() {
    return groupType;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.group_type
   *
   * @param groupType the value for important_person_info.group_type
   * @mbg.generated
   */
  public void setGroupType(String groupType) {
    this.groupType = groupType == null ? null : groupType.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.control_keyword
   *
   * @return the value of important_person_info.control_keyword
   * @mbg.generated
   */
  public String getControlKeyword() {
    return controlKeyword;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.control_keyword
   *
   * @param controlKeyword the value for important_person_info.control_keyword
   * @mbg.generated
   */
  public void setControlKeyword(String controlKeyword) {
    this.controlKeyword = controlKeyword == null ? null : controlKeyword.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.marital_status
   *
   * @return the value of important_person_info.marital_status
   * @mbg.generated
   */
  public String getMaritalStatus() {
    return maritalStatus;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.marital_status
   *
   * @param maritalStatus the value for important_person_info.marital_status
   * @mbg.generated
   */
  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.domicile
   *
   * @return the value of important_person_info.domicile
   * @mbg.generated
   */
  public String getDomicile() {
    return domicile;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.domicile
   *
   * @param domicile the value for important_person_info.domicile
   * @mbg.generated
   */
  public void setDomicile(String domicile) {
    this.domicile = domicile == null ? null : domicile.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.residence
   *
   * @return the value of important_person_info.residence
   * @mbg.generated
   */
  public String getResidence() {
    return residence;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.residence
   *
   * @param residence the value for important_person_info.residence
   * @mbg.generated
   */
  public void setResidence(String residence) {
    this.residence = residence == null ? null : residence.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.phone_text
   *
   * @return the value of important_person_info.phone_text
   * @mbg.generated
   */
  public String getPhoneText() {
    return phoneText;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.phone_text
   *
   * @param phoneText the value for important_person_info.phone_text
   * @mbg.generated
   */
  public void setPhoneText(String phoneText) {
    this.phoneText = phoneText == null ? null : phoneText.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.wechat_name_text
   *
   * @return the value of important_person_info.wechat_name_text
   * @mbg.generated
   */
  public String getWechatNameText() {
    return wechatNameText;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.wechat_name_text
   *
   * @param wechatNameText the value for important_person_info.wechat_name_text
   * @mbg.generated
   */
  public void setWechatNameText(String wechatNameText) {
    this.wechatNameText = wechatNameText == null ? null : wechatNameText.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.jurisdiction
   *
   * @return the value of important_person_info.jurisdiction
   * @mbg.generated
   */
  public String getJurisdiction() {
    return jurisdiction;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.jurisdiction
   *
   * @param jurisdiction the value for important_person_info.jurisdiction
   * @mbg.generated
   */
  public void setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.juri_police
   *
   * @return the value of important_person_info.juri_police
   * @mbg.generated
   */
  public String getJuriPolice() {
    return juriPolice;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.juri_police
   *
   * @param juriPolice the value for important_person_info.juri_police
   * @mbg.generated
   */
  public void setJuriPolice(String juriPolice) {
    this.juriPolice = juriPolice == null ? null : juriPolice.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.education
   *
   * @return the value of important_person_info.education
   * @mbg.generated
   */
  public String getEducation() {
    return education;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.education
   *
   * @param education the value for important_person_info.education
   * @mbg.generated
   */
  public void setEducation(String education) {
    this.education = education == null ? null : education.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.veteran_status
   *
   * @return the value of important_person_info.veteran_status
   * @mbg.generated
   */
  public String getVeteranStatus() {
    return veteranStatus;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.veteran_status
   *
   * @param veteranStatus the value for important_person_info.veteran_status
   * @mbg.generated
   */
  public void setVeteranStatus(String veteranStatus) {
    this.veteranStatus = veteranStatus == null ? null : veteranStatus.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.job
   *
   * @return the value of important_person_info.job
   * @mbg.generated
   */
  public String getJob() {
    return job;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.job
   *
   * @param job the value for important_person_info.job
   * @mbg.generated
   */
  public void setJob(String job) {
    this.job = job == null ? null : job.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.work_place
   *
   * @return the value of important_person_info.work_place
   * @mbg.generated
   */
  public String getWorkPlace() {
    return workPlace;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.work_place
   *
   * @param workPlace the value for important_person_info.work_place
   * @mbg.generated
   */
  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace == null ? null : workPlace.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.work_status
   *
   * @return the value of important_person_info.work_status
   * @mbg.generated
   */
  public String getWorkStatus() {
    return workStatus;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.work_status
   *
   * @param workStatus the value for important_person_info.work_status
   * @mbg.generated
   */
  public void setWorkStatus(String workStatus) {
    this.workStatus = workStatus == null ? null : workStatus.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.control_reason
   *
   * @return the value of important_person_info.control_reason
   * @mbg.generated
   */
  public String getControlReason() {
    return controlReason;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.control_reason
   *
   * @param controlReason the value for important_person_info.control_reason
   * @mbg.generated
   */
  public void setControlReason(String controlReason) {
    this.controlReason = controlReason == null ? null : controlReason.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.remark
   *
   * @return the value of important_person_info.remark
   * @mbg.generated
   */
  public String getRemark() {
    return remark;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.remark
   *
   * @param remark the value for important_person_info.remark
   * @mbg.generated
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.ext1
   *
   * @return the value of important_person_info.ext1
   * @mbg.generated
   */
  public String getExt1() {
    return ext1;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.ext1
   *
   * @param ext1 the value for important_person_info.ext1
   * @mbg.generated
   */
  public void setExt1(String ext1) {
    this.ext1 = ext1 == null ? null : ext1.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.ext2
   *
   * @return the value of important_person_info.ext2
   * @mbg.generated
   */
  public String getExt2() {
    return ext2;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.ext2
   *
   * @param ext2 the value for important_person_info.ext2
   * @mbg.generated
   */
  public void setExt2(String ext2) {
    this.ext2 = ext2 == null ? null : ext2.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.ext3
   *
   * @return the value of important_person_info.ext3
   * @mbg.generated
   */
  public String getExt3() {
    return ext3;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.ext3
   *
   * @param ext3 the value for important_person_info.ext3
   * @mbg.generated
   */
  public void setExt3(String ext3) {
    this.ext3 = ext3 == null ? null : ext3.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column important_person_info.delete_flag
   *
   * @return the value of important_person_info.delete_flag
   * @mbg.generated
   */
  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column important_person_info.delete_flag
   *
   * @param deleteFlag the value for important_person_info.delete_flag
   * @mbg.generated
   */
  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public List<ImportantPersonRecordModel> getRecords() {
    return records;
  }

  public void setRecords(
      List<ImportantPersonRecordModel> records) {
    this.records = records;
  }
}