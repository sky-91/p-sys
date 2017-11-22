package cn.qsky.policesys.core.dao.model;

import java.util.Date;
import java.util.List;

public class RoleModel {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.PK
   *
   * @mbg.generated
   */
  private Long pk;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.created_time
   *
   * @mbg.generated
   */
  private Date createdTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.modified_time
   *
   * @mbg.generated
   */
  private Date modifiedTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.role_id
   *
   * @mbg.generated
   */
  private String roleId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.role_name
   *
   * @mbg.generated
   */
  private String roleName;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.ext1
   *
   * @mbg.generated
   */
  private String ext1;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.ext2
   *
   * @mbg.generated
   */
  private String ext2;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.ext3
   *
   * @mbg.generated
   */
  private String ext3;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * role.delete_flag
   *
   * @mbg.generated
   */
  private Boolean deleteFlag;

  private List<PermissionModel> permissionList;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.PK
   *
   * @return the value of role.PK
   * @mbg.generated
   */
  public Long getPk() {
    return pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.PK
   *
   * @param pk the value for role.PK
   * @mbg.generated
   */
  public void setPk(Long pk) {
    this.pk = pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.created_time
   *
   * @return the value of role.created_time
   * @mbg.generated
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.created_time
   *
   * @param createdTime the value for role.created_time
   * @mbg.generated
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.modified_time
   *
   * @return the value of role.modified_time
   * @mbg.generated
   */
  public Date getModifiedTime() {
    return modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.modified_time
   *
   * @param modifiedTime the value for role.modified_time
   * @mbg.generated
   */
  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.role_id
   *
   * @return the value of role.role_id
   * @mbg.generated
   */
  public String getRoleId() {
    return roleId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.role_id
   *
   * @param roleId the value for role.role_id
   * @mbg.generated
   */
  public void setRoleId(String roleId) {
    this.roleId = roleId == null ? null : roleId.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.role_name
   *
   * @return the value of role.role_name
   * @mbg.generated
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.role_name
   *
   * @param roleName the value for role.role_name
   * @mbg.generated
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName == null ? null : roleName.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.ext1
   *
   * @return the value of role.ext1
   * @mbg.generated
   */
  public String getExt1() {
    return ext1;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.ext1
   *
   * @param ext1 the value for role.ext1
   * @mbg.generated
   */
  public void setExt1(String ext1) {
    this.ext1 = ext1 == null ? null : ext1.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.ext2
   *
   * @return the value of role.ext2
   * @mbg.generated
   */
  public String getExt2() {
    return ext2;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.ext2
   *
   * @param ext2 the value for role.ext2
   * @mbg.generated
   */
  public void setExt2(String ext2) {
    this.ext2 = ext2 == null ? null : ext2.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.ext3
   *
   * @return the value of role.ext3
   * @mbg.generated
   */
  public String getExt3() {
    return ext3;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.ext3
   *
   * @param ext3 the value for role.ext3
   * @mbg.generated
   */
  public void setExt3(String ext3) {
    this.ext3 = ext3 == null ? null : ext3.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column role.delete_flag
   *
   * @return the value of role.delete_flag
   * @mbg.generated
   */
  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column role.delete_flag
   *
   * @param deleteFlag the value for role.delete_flag
   * @mbg.generated
   */
  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public List<PermissionModel> getPermissionList() {
    return permissionList;
  }

  public void setPermissionList(
      List<PermissionModel> permissionList) {
    this.permissionList = permissionList;
  }
}