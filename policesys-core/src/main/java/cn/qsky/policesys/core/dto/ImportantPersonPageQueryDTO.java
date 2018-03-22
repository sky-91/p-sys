package cn.qsky.policesys.core.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 17/12/6
 */
public class ImportantPersonPageQueryDTO {

  private String controlKeyword;

  private String groupType;

  private String idCard;

  private String name;

  private String phoneText;

  private String wechatNameText;

  private String jurisdiction;

  private String juriPolice;

  private Boolean sex;

  private Byte startAge;

  private Byte endAge;

  private Integer pageNumber;

  private Integer pageSize;

  private Integer startRow;

  public String getControlKeyword() {
    return controlKeyword;
  }

  public void setControlKeyword(String controlKeyword) {
    this.controlKeyword = controlKeyword;
  }

  public String getGroupType() {
    return groupType;
  }

  public void setGroupType(String groupType) {
    this.groupType = groupType;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public Byte getStartAge() {
    return startAge;
  }

  public void setStartAge(Byte startAge) {
    this.startAge = startAge;
  }

  public Byte getEndAge() {
    return endAge;
  }

  public void setEndAge(Byte endAge) {
    this.endAge = endAge;
  }

  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getStartRow() {
    return startRow;
  }

  public void setStartRow(Integer startRow) {
    this.startRow = startRow;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
