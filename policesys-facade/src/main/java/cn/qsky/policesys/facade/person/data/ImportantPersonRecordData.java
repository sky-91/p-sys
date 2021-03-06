package cn.qsky.policesys.facade.person.data;

import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 17/12/6
 */
public class ImportantPersonRecordData {

  private String ext1;

  private Long pk;

  private String name;

  private String idCard;

  private Byte score;

  private Date recordDate;

  private String week;

  private String groupType;

  private String petitionLocation;

  private String petitionRegion;

  private String petitionDynamic;

  private Boolean confirm;

  private String inciteMethod;

  private String infoSources;

  private String qqGroup;

  private String wechatGroup;

  private Short groupSize;

  private Boolean consequence;

  private Byte conseScore;

  private String petitionSituation;

  private String recordType;

  private Boolean deleteFlag;

  public String getExt1() {
    return ext1;
  }

  public void setExt1(String ext1) {
    this.ext1 = ext1;
  }

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
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

  public Byte getScore() {
    return score;
  }

  public void setScore(Byte score) {
    this.score = score;
  }

  public Date getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(Date recordDate) {
    this.recordDate = recordDate;
  }

  public String getWeek() {
    return week;
  }

  public void setWeek(String week) {
    this.week = week;
  }

  public String getGroupType() {
    return groupType;
  }

  public void setGroupType(String groupType) {
    this.groupType = groupType;
  }

  public String getPetitionLocation() {
    return petitionLocation;
  }

  public void setPetitionLocation(String petitionLocation) {
    this.petitionLocation = petitionLocation;
  }

  public String getPetitionRegion() {
    return petitionRegion;
  }

  public void setPetitionRegion(String petitionRegion) {
    this.petitionRegion = petitionRegion;
  }

  public String getPetitionDynamic() {
    return petitionDynamic;
  }

  public void setPetitionDynamic(String petitionDynamic) {
    this.petitionDynamic = petitionDynamic;
  }

  public Boolean getConfirm() {
    return confirm;
  }

  public void setConfirm(Boolean confirm) {
    this.confirm = confirm;
  }

  public String getInciteMethod() {
    return inciteMethod;
  }

  public void setInciteMethod(String inciteMethod) {
    this.inciteMethod = inciteMethod;
  }

  public String getInfoSources() {
    return infoSources;
  }

  public void setInfoSources(String infoSources) {
    this.infoSources = infoSources;
  }

  public String getQqGroup() {
    return qqGroup;
  }

  public void setQqGroup(String qqGroup) {
    this.qqGroup = qqGroup;
  }

  public String getWechatGroup() {
    return wechatGroup;
  }

  public void setWechatGroup(String wechatGroup) {
    this.wechatGroup = wechatGroup;
  }

  public Short getGroupSize() {
    return groupSize;
  }

  public void setGroupSize(Short groupSize) {
    this.groupSize = groupSize;
  }

  public Boolean getConsequence() {
    return consequence;
  }

  public void setConsequence(Boolean consequence) {
    this.consequence = consequence;
  }

  public Byte getConseScore() {
    return conseScore;
  }

  public void setConseScore(Byte conseScore) {
    this.conseScore = conseScore;
  }

  public String getPetitionSituation() {
    return petitionSituation;
  }

  public void setPetitionSituation(String petitionSituation) {
    this.petitionSituation = petitionSituation;
  }

  public String getRecordType() {
    return recordType;
  }

  public void setRecordType(String recordType) {
    this.recordType = recordType;
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
