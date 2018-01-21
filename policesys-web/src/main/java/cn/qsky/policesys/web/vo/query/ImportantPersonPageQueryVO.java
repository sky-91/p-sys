package cn.qsky.policesys.web.vo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("ImportantPersonPageQueryVO(重点人员清单列表查询条件)")
public class ImportantPersonPageQueryVO {

  @ApiModelProperty(value = "列控关键字")
  private String controllKeyword;

  @ApiModelProperty(value = "群体类别")
  private String groupType;

  @ApiModelProperty(value = "身份证号")
  private String idCard;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "联系方式")
  private String phone;

  @ApiModelProperty(value = "微信绑定名称")
  private String wechatName;

  @ApiModelProperty(value = "管辖单位")
  private String jurisdiction;

  @ApiModelProperty(value = "管辖派出所")
  private String juriPolice;

  @ApiModelProperty(value = "性别")
  private Boolean sex;

  @ApiModelProperty(value = "起始年龄")
  private Byte startAge;

  @ApiModelProperty(value = "终止年龄")
  private Byte endAge;

  @ApiModelProperty(value = "页码")
  private Integer pageNumber;

  @ApiModelProperty(value = "每页条数")
  private Integer pageSize;

  public String getControllKeyword() {
    return controllKeyword;
  }

  public void setControllKeyword(String controllKeyword) {
    this.controllKeyword = controllKeyword;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWechatName() {
    return wechatName;
  }

  public void setWechatName(String wechatName) {
    this.wechatName = wechatName;
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

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
