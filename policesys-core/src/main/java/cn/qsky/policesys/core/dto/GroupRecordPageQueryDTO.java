package cn.qsky.policesys.core.dto;

import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
public class GroupRecordPageQueryDTO {

  private String groupName;

  private Date startRecordDate;

  private Date endRecordDate;

  private String petitionLocation;

  private String petitionRegion;

  private String inciteMethod;

  private String infoSources;

  private Integer pageNumber;

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
