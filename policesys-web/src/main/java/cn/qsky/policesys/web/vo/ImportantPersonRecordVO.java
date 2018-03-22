package cn.qsky.policesys.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("ImportantPersonRecordVO(重点人员轨迹积分表)")
public class ImportantPersonRecordVO {

  @ApiModelProperty(value = "pk")
  private Long pk;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "身份证号")
  private String idCard;

  @ApiModelProperty(value = "分数")
  private Byte score;

  @ApiModelProperty(value = "日期")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date recordDate;

  @ApiModelProperty(value = "星期")
  private String week;

  @ApiModelProperty(value = "群体类别")
  private String groupType;

  @ApiModelProperty(value = "上访地点")
  private String petitionLocation;

  @ApiModelProperty(value = "上访区域")
  private String petitionRegion;

  @ApiModelProperty(value = "上访动态")
  private String petitionDynamic;

  @ApiModelProperty(value = "是否落实")
  private Boolean confirm;

  @ApiModelProperty(value = "轨迹类型")
  private String inciteMethod;

  @ApiModelProperty(value = "信息来源")
  private String infoSources;

  @ApiModelProperty(value = "QQ群")
  private String qqGroup;

  @ApiModelProperty(value = "微信群")
  private String wechatGroup;

  @ApiModelProperty(value = "规模等级")
  private Short groupSize;

  @ApiModelProperty(value = "是否造成后果")
  private Boolean consequence;

  @ApiModelProperty(value = "造成后果分数")
  private Byte conseScore;

  @ApiModelProperty(value = "上访情况简介")
  private String petitionSituation;

  @ApiModelProperty(value = "轨迹类别")
  private String recordType;

  @ApiModelProperty(value = "扩展字段-序号")
  private String ext1;

  @ApiModelProperty(value = "删除标识")
  private Boolean deleteFlag;

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

  public String getExt1() {
    return ext1;
  }

  public void setExt1(String ext1) {
    this.ext1 = ext1;
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
