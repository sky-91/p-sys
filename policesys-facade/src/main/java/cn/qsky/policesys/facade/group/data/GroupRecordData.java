package cn.qsky.policesys.facade.group.data;

import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dozer.Mapping;

/**
 * @author qsky on 18/1/7
 */
public class GroupRecordData {

  @Mapping("ext1")
  private String index;

  private Long pk;

  private String groupName;

  private Date recordDate;

  private Byte score;

  private String petitionLocation;

  private String petitionRegion;

  private String petitionDynamic;

  private Boolean confirm;

  private String inciteMethod;

  private String infoSources;

  private String actionGroup;

  private Short groupSize;

  private Boolean consequence;

  private Byte conseScore;

  private String petitionSituation;

  private Boolean deleteFlag;

  public String getIndex() {
    return index;
  }

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public Date getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(Date recordDate) {
    this.recordDate = recordDate;
  }

  public Byte getScore() {
    return score;
  }

  public void setScore(Byte score) {
    this.score = score;
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

  public String getActionGroup() {
    return actionGroup;
  }

  public void setActionGroup(String actionGroup) {
    this.actionGroup = actionGroup;
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
