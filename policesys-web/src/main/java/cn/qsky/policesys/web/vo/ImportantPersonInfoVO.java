package cn.qsky.policesys.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("ImportantPersonInfoVO(重点人员底库表)")
public class ImportantPersonInfoVO {

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "身份证号")
  private String idCard;

  @ApiModelProperty(value = "性别")
  private Boolean sex;

  @ApiModelProperty(value = "民族")
  private String nation;

  @ApiModelProperty(value = "年龄")
  private Byte age;

  @ApiModelProperty(value = "群体类别")
  private String groupType;

  @ApiModelProperty(value = "列控关键字")
  private String controlKeyword;

  @ApiModelProperty(value = "婚姻状况")
  private String maritalStatus;

  @ApiModelProperty(value = "户籍地")
  private String domicile;

  @ApiModelProperty(value = "现住地")
  private String residence;

  @ApiModelProperty(value = "管辖单位")
  private String jurisdiction;

  @ApiModelProperty(value = "管辖派出所")
  private String juriPolice;

  @ApiModelProperty(value = "学历")
  private String education;

  @ApiModelProperty(value = "兵役状况")
  private String veteranStatus;

  @ApiModelProperty(value = "职业")
  private String job;

  @ApiModelProperty(value = "服务处所")
  private String workPlace;

  @ApiModelProperty(value = "工作状态")
  private String workStatus;

  @ApiModelProperty(value = "列控事由")
  private String controlReason;

  @ApiModelProperty(value = "备注")
  private String remark;

  @ApiModelProperty(value = "删除标记")
  private Boolean deleteFlag;

  @ApiModelProperty(value = "电话文本")
  private String phoneText;

  @ApiModelProperty(value = "微信文本")
  private String wechatNameText;

  @ApiModelProperty(value = "扩展字段-序号")
  private String ext1;

  @ApiModelProperty(value = "轨迹积分")
  private List<ImportantPersonRecordVO> records;

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

  public String getExt1() {
    return ext1;
  }

  public void setExt1(String ext1) {
    this.ext1 = ext1;
  }

  public List<ImportantPersonRecordVO> getRecords() {
    return records;
  }

  public void setRecords(List<ImportantPersonRecordVO> records) {
    this.records = records;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
