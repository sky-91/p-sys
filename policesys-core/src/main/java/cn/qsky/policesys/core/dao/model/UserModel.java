package cn.qsky.policesys.core.dao.model;

import java.util.Date;

public class UserModel {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.PK
   *
   * @mbg.generated
   */
  private Long pk;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.created_time
   *
   * @mbg.generated
   */
  private Date createdTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.modified_time
   *
   * @mbg.generated
   */
  private Date modifiedTime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.user_id
   *
   * @mbg.generated
   */
  private String userId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.password
   *
   * @mbg.generated
   */
  private String password;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.user_name
   *
   * @mbg.generated
   */
  private String userName;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.id_card
   *
   * @mbg.generated
   */
  private String idCard;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.phone
   *
   * @mbg.generated
   */
  private String phone;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.ext1
   *
   * @mbg.generated
   */
  private String ext1;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.ext2
   *
   * @mbg.generated
   */
  private String ext2;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.ext3
   *
   * @mbg.generated
   */
  private String ext3;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * user.delete_flag
   *
   * @mbg.generated
   */
  private Boolean deleteFlag;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.PK
   *
   * @return the value of user.PK
   * @mbg.generated
   */
  public Long getPk() {
    return pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.PK
   *
   * @param pk the value for user.PK
   * @mbg.generated
   */
  public void setPk(Long pk) {
    this.pk = pk;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.created_time
   *
   * @return the value of user.created_time
   * @mbg.generated
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.created_time
   *
   * @param createdTime the value for user.created_time
   * @mbg.generated
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.modified_time
   *
   * @return the value of user.modified_time
   * @mbg.generated
   */
  public Date getModifiedTime() {
    return modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.modified_time
   *
   * @param modifiedTime the value for user.modified_time
   * @mbg.generated
   */
  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.user_id
   *
   * @return the value of user.user_id
   * @mbg.generated
   */
  public String getUserId() {
    return userId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.user_id
   *
   * @param userId the value for user.user_id
   * @mbg.generated
   */
  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.password
   *
   * @return the value of user.password
   * @mbg.generated
   */
  public String getPassword() {
    return password;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.password
   *
   * @param password the value for user.password
   * @mbg.generated
   */
  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.user_name
   *
   * @return the value of user.user_name
   * @mbg.generated
   */
  public String getUserName() {
    return userName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.user_name
   *
   * @param userName the value for user.user_name
   * @mbg.generated
   */
  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.id_card
   *
   * @return the value of user.id_card
   * @mbg.generated
   */
  public String getIdCard() {
    return idCard;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.id_card
   *
   * @param idCard the value for user.id_card
   * @mbg.generated
   */
  public void setIdCard(String idCard) {
    this.idCard = idCard == null ? null : idCard.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.phone
   *
   * @return the value of user.phone
   * @mbg.generated
   */
  public String getPhone() {
    return phone;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.phone
   *
   * @param phone the value for user.phone
   * @mbg.generated
   */
  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.ext1
   *
   * @return the value of user.ext1
   * @mbg.generated
   */
  public String getExt1() {
    return ext1;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.ext1
   *
   * @param ext1 the value for user.ext1
   * @mbg.generated
   */
  public void setExt1(String ext1) {
    this.ext1 = ext1 == null ? null : ext1.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.ext2
   *
   * @return the value of user.ext2
   * @mbg.generated
   */
  public String getExt2() {
    return ext2;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.ext2
   *
   * @param ext2 the value for user.ext2
   * @mbg.generated
   */
  public void setExt2(String ext2) {
    this.ext2 = ext2 == null ? null : ext2.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.ext3
   *
   * @return the value of user.ext3
   * @mbg.generated
   */
  public String getExt3() {
    return ext3;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.ext3
   *
   * @param ext3 the value for user.ext3
   * @mbg.generated
   */
  public void setExt3(String ext3) {
    this.ext3 = ext3 == null ? null : ext3.trim();
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column user.delete_flag
   *
   * @return the value of user.delete_flag
   * @mbg.generated
   */
  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column user.delete_flag
   *
   * @param deleteFlag the value for user.delete_flag
   * @mbg.generated
   */
  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }
}