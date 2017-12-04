package cn.qsky.policesys.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 17/12/3
 */
@ApiModel("SpecialPersonVO(疆藏人员模型)")
public class SpecialPersonVO {

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "身份证号")
  private String idCard;

  @ApiModelProperty(value = "手机号码")
  private String phone;

  @ApiModelProperty(value = "管辖单位")
  private String jurisdiction;

  @ApiModelProperty(value = "资源名称")
  private String resourceName;

  @ApiModelProperty(value = "活动场所")
  private String activityPlace;

  @ApiModelProperty(value = "活动场所详址")
  private String activityPlaceDetail;

  @ApiModelProperty(value = "活动时间")
  private Date activityTime;

  @ApiModelProperty(value = "推送时间")
  private Date pushTime;

  @ApiModelProperty(value = "户籍地")
  private String domicile;

  @ApiModelProperty(value = "人员类型")
  private Boolean personType;

  @ApiModelProperty(value = "民族")
  private String nation;

  @ApiModelProperty(value = "住宿上网地点")
  private String stayInternetSite;

  @ApiModelProperty(value = "来津时间及事由")
  private String tjTimeReason;

  @ApiModelProperty(value = "来津方式")
  private String vehicle;

  @ApiModelProperty(value = "在津住地")
  private String tjStaySite;

  @ApiModelProperty(value = "来津联系人")
  private String tjContact;

  @ApiModelProperty(value = "随身物品")
  private String belongings;

  @ApiModelProperty(value = "虚拟身份")
  private String virtualIdentity;

  @ApiModelProperty(value = "同行人员")
  private String peerStaff;

  @ApiModelProperty(value = "同住人员")
  private String stayStaff;

  @ApiModelProperty(value = "驾乘车辆号牌")
  private String carNum;

  @ApiModelProperty(value = "有无涉恐表象特征")
  private String terroristChar;

  @ApiModelProperty(value = "重点人列控类型")
  private String controlType;

  @ApiModelProperty(value = "核查地点")
  private String checkSite;

  @ApiModelProperty(value = "核查民警")
  private String checkPolice;

  @ApiModelProperty(value = "删除标记")
  private Boolean deleteFlag;

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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getJurisdiction() {
    return jurisdiction;
  }

  public void setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getActivityPlace() {
    return activityPlace;
  }

  public void setActivityPlace(String activityPlace) {
    this.activityPlace = activityPlace;
  }

  public String getActivityPlaceDetail() {
    return activityPlaceDetail;
  }

  public void setActivityPlaceDetail(String activityPlaceDetail) {
    this.activityPlaceDetail = activityPlaceDetail;
  }

  public Date getActivityTime() {
    return activityTime;
  }

  public void setActivityTime(Date activityTime) {
    this.activityTime = activityTime;
  }

  public Date getPushTime() {
    return pushTime;
  }

  public void setPushTime(Date pushTime) {
    this.pushTime = pushTime;
  }

  public String getDomicile() {
    return domicile;
  }

  public void setDomicile(String domicile) {
    this.domicile = domicile;
  }

  public Boolean getPersonType() {
    return personType;
  }

  public void setPersonType(Boolean personType) {
    this.personType = personType;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getStayInternetSite() {
    return stayInternetSite;
  }

  public void setStayInternetSite(String stayInternetSite) {
    this.stayInternetSite = stayInternetSite;
  }

  public String getTjTimeReason() {
    return tjTimeReason;
  }

  public void setTjTimeReason(String tjTimeReason) {
    this.tjTimeReason = tjTimeReason;
  }

  public String getVehicle() {
    return vehicle;
  }

  public void setVehicle(String vehicle) {
    this.vehicle = vehicle;
  }

  public String getTjStaySite() {
    return tjStaySite;
  }

  public void setTjStaySite(String tjStaySite) {
    this.tjStaySite = tjStaySite;
  }

  public String getTjContact() {
    return tjContact;
  }

  public void setTjContact(String tjContact) {
    this.tjContact = tjContact;
  }

  public String getBelongings() {
    return belongings;
  }

  public void setBelongings(String belongings) {
    this.belongings = belongings;
  }

  public String getVirtualIdentity() {
    return virtualIdentity;
  }

  public void setVirtualIdentity(String virtualIdentity) {
    this.virtualIdentity = virtualIdentity;
  }

  public String getPeerStaff() {
    return peerStaff;
  }

  public void setPeerStaff(String peerStaff) {
    this.peerStaff = peerStaff;
  }

  public String getStayStaff() {
    return stayStaff;
  }

  public void setStayStaff(String stayStaff) {
    this.stayStaff = stayStaff;
  }

  public String getCarNum() {
    return carNum;
  }

  public void setCarNum(String carNum) {
    this.carNum = carNum;
  }

  public String getTerroristChar() {
    return terroristChar;
  }

  public void setTerroristChar(String terroristChar) {
    this.terroristChar = terroristChar;
  }

  public String getControlType() {
    return controlType;
  }

  public void setControlType(String controlType) {
    this.controlType = controlType;
  }

  public String getCheckSite() {
    return checkSite;
  }

  public void setCheckSite(String checkSite) {
    this.checkSite = checkSite;
  }

  public String getCheckPolice() {
    return checkPolice;
  }

  public void setCheckPolice(String checkPolice) {
    this.checkPolice = checkPolice;
  }

  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
