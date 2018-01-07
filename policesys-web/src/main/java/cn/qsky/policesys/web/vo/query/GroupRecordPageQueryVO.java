package cn.qsky.policesys.web.vo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("GroupRecordPageQueryVO(群体活动记录查询条件)")
public class GroupRecordPageQueryVO {

  @ApiModelProperty(value = "群体名称")
  private String groupName;

  @ApiModelProperty(value = "开始日期")
  private Date startRecordDate;

  @ApiModelProperty(value = "结束日期")
  private Date endRecordDate;

  @ApiModelProperty(value = "上访地点")
  private String petitionLocation;

  @ApiModelProperty(value = "所属区域")
  private String petitionRegion;

  @ApiModelProperty(value = "煽动方式")
  private String inciteMethod;

  @ApiModelProperty(value = "信息来源")
  private String infoSources;

  @ApiModelProperty(value = "页码")
  private Integer pageNum;

  @ApiModelProperty(value = "每页大小")
  private Integer pageSize;

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public Date getStartRecordDate() {
    return startRecordDate;
  }

  public void setStartRecordDate(Date startRecordDate) {
    this.startRecordDate = startRecordDate;
  }

  public Date getEndRecordDate() {
    return endRecordDate;
  }

  public void setEndRecordDate(Date endRecordDate) {
    this.endRecordDate = endRecordDate;
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

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
