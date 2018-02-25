package cn.qsky.policesys.facade.person.data;

import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 2018/2/23
 */
public class ImportantRecordPageQueryData {

  private Date startRecordDate;

  private Date endRecordDate;

  private String idCard;

  private String petitionRegion;

  private String infoSources;

  private String inciteMethod;

  private Integer pageNumber;

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
