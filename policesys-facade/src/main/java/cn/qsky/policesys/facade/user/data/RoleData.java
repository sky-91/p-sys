package cn.qsky.policesys.facade.user.data;

import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 17/11/22
 */
public class RoleData {

  /**
   * 角色id
   */
  private String roleId;

  /**
   * 角色名称
   */
  private String roleName;

  private List<PermissionData> permissionList;

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public List<PermissionData> getPermissionList() {
    return permissionList;
  }

  public void setPermissionList(
      List<PermissionData> permissionList) {
    this.permissionList = permissionList;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
