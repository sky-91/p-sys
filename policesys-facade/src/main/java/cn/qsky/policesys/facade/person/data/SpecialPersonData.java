package cn.qsky.policesys.facade.person.data;

import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 17/12/3
 */
public class SpecialPersonData {

  private String name;

  private String idCard;

  private String phone;

  private String jurisdiction;

  private String resourceName;

  private String activityPlace;

  private String activityPlaceDetail;

  private Date activityTime;

  private Date pushTime;

  private String domicile;

  private Boolean personType;

  private String nation;

  private String stayInternetSite;

  private String tjTimeReason;

  private String vehicle;

  private String tjStaySite;

  private String tjContact;

  private String belongings;

  private String virtualIdentity;

  private String peerStaff;

  private String stayStaff;

  private String carNum;

  private String terroristChar;

  private String controlType;

  private String checkSite;

  private String checkPolice;

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
