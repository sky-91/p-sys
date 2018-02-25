package cn.qsky.policesys.web.vo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 2018/2/23
 */
@ApiModel("ImportantRecordPageQueryVO(人员轨迹积分查询条件)")
public class ImportantRecordPageQueryVO {

  @ApiModelProperty(value = "开始日期")
  private Date startRecordDate;

  @ApiModelProperty(value = "结束日期")
  private Date endRecordDate;

  @ApiModelProperty(value = "身份证号")
  private String idCard;

  @ApiModelProperty(value = "上访区域")
  private String petitionRegion;

  @ApiModelProperty(value = "信息来源")
  private String infoSources;

  @ApiModelProperty(value = "轨迹类型")
  private String inciteMethod;

  @ApiModelProperty(value = "页码")
  private Integer pageNumber;

  @ApiModelProperty(value = "每页条数")
  private Integer pageSize;

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

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getPetitionRegion() {
    return petitionRegion;
  }

  public void setPetitionRegion(String petitionRegion) {
    this.petitionRegion = petitionRegion;
  }

  public String getInfoSources() {
    return infoSources;
  }

  public void setInfoSources(String infoSources) {
    this.infoSources = infoSources;
  }

  public String getInciteMethod() {
    return inciteMethod;
  }

  public void setInciteMethod(String inciteMethod) {
    this.inciteMethod = inciteMethod;
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

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
