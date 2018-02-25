package cn.qsky.policesys.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("GroupRecordVO(群体活动记录)")
public class GroupRecordVO {

  @ApiModelProperty(value = "群体名称")
  private String groupName;

  @ApiModelProperty(value = "日期")
  private Date recordDate;

  @ApiModelProperty(value = "分数")
  private Byte score;

  @ApiModelProperty(value = "上访地点")
  private String petitionLocation;

  @ApiModelProperty(value = "所属区域")
  private String petitionRegion;

  @ApiModelProperty(value = "上访动态")
  private String petitionDynamic;

  @ApiModelProperty(value = "是否落实")
  private Boolean confirm;

  @ApiModelProperty(value = "轨迹类型")
  private String inciteMethod;

  @ApiModelProperty(value = "信息来源")
  private String infoSources;

  @ApiModelProperty(value = "维权方式")
  private String actionGroup;

  @ApiModelProperty(value = "规模等级")
  private Short groupSize;

  @ApiModelProperty(value = "是否造成后果")
  private Boolean consequence;

  @ApiModelProperty(value = "造成后果分数")
  private Byte conseScore;

  @ApiModelProperty(value = "上访情况概述")
  private String petitionSituation;

  @ApiModelProperty(value = "删除标记")
  private Boolean deleteFlag;

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
