package cn.qsky.policesys.core.dao.model;

import java.util.Date;

public class PermissionModel {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.PK
   *
   * @mbg.generated
   */
  private Long pk;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.created_time
   *
   * @mbg.generated
   */
  private Date createdTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.modified_time
   *
   * @mbg.generated
   */
  private Date modifiedTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.code
   *
   * @mbg.generated
   */
  private String code;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.name
   *
   * @mbg.generated
   */
  private String name;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.resourceType
   *
   * @mbg.generated
   */
  private String resourcetype;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.url
   *
   * @mbg.generated
   */
  private String url;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.permission
   *
   * @mbg.generated
   */
  private String permission;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.parent
   *
   * @mbg.generated
   */
  private Long parent;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.ext1
   *
   * @mbg.generated
   */
  private String ext1;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.ext2
   *
   * @mbg.generated
   */
  private String ext2;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.ext3
   *
   * @mbg.generated
   */
  private String ext3;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * permission.delete_flag
   *
   * @mbg.generated
   */
  private Boolean deleteFlag;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.PK
   *
   * @return the value of permission.PK
   * @mbg.generated
   */
  public Long getPk() {
    return pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.PK
   *
   * @param pk the value for permission.PK
   * @mbg.generated
   */
  public void setPk(Long pk) {
    this.pk = pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.created_time
   *
   * @return the value of permission.created_time
   * @mbg.generated
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.created_time
   *
   * @param createdTime the value for permission.created_time
   * @mbg.generated
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.modified_time
   *
   * @return the value of permission.modified_time
   * @mbg.generated
   */
  public Date getModifiedTime() {
    return modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.modified_time
   *
   * @param modifiedTime the value for permission.modified_time
   * @mbg.generated
   */
  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.code
   *
   * @return the value of permission.code
   * @mbg.generated
   */
  public String getCode() {
    return code;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.code
   *
   * @param code the value for permission.code
   * @mbg.generated
   */
  public void setCode(String code) {
    this.code = code == null ? null : code.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.name
   *
   * @return the value of permission.name
   * @mbg.generated
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.name
   *
   * @param name the value for permission.name
   * @mbg.generated
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.resourceType
   *
   * @return the value of permission.resourceType
   * @mbg.generated
   */
  public String getResourcetype() {
    return resourcetype;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.resourceType
   *
   * @param resourcetype the value for permission.resourceType
   * @mbg.generated
   */
  public void setResourcetype(String resourcetype) {
    this.resourcetype = resourcetype == null ? null : resourcetype.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.url
   *
   * @return the value of permission.url
   * @mbg.generated
   */
  public String getUrl() {
    return url;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.url
   *
   * @param url the value for permission.url
   * @mbg.generated
   */
  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.permission
   *
   * @return the value of permission.permission
   * @mbg.generated
   */
  public String getPermission() {
    return permission;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.permission
   *
   * @param permission the value for permission.permission
   * @mbg.generated
   */
  public void setPermission(String permission) {
    this.permission = permission == null ? null : permission.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.parent
   *
   * @return the value of permission.parent
   * @mbg.generated
   */
  public Long getParent() {
    return parent;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.parent
   *
   * @param parent the value for permission.parent
   * @mbg.generated
   */
  public void setParent(Long parent) {
    this.parent = parent;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.ext1
   *
   * @return the value of permission.ext1
   * @mbg.generated
   */
  public String getExt1() {
    return ext1;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.ext1
   *
   * @param ext1 the value for permission.ext1
   * @mbg.generated
   */
  public void setExt1(String ext1) {
    this.ext1 = ext1 == null ? null : ext1.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.ext2
   *
   * @return the value of permission.ext2
   * @mbg.generated
   */
  public String getExt2() {
    return ext2;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.ext2
   *
   * @param ext2 the value for permission.ext2
   * @mbg.generated
   */
  public void setExt2(String ext2) {
    this.ext2 = ext2 == null ? null : ext2.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.ext3
   *
   * @return the value of permission.ext3
   * @mbg.generated
   */
  public String getExt3() {
    return ext3;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.ext3
   *
   * @param ext3 the value for permission.ext3
   * @mbg.generated
   */
  public void setExt3(String ext3) {
    this.ext3 = ext3 == null ? null : ext3.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column permission.delete_flag
   *
   * @return the value of permission.delete_flag
   * @mbg.generated
   */
  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column permission.delete_flag
   *
   * @param deleteFlag the value for permission.delete_flag
   * @mbg.generated
   */
  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }
}