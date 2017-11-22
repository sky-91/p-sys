package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.RoleModel;
import cn.qsky.policesys.core.dao.model.RoleModelExample;

public interface RoleMapper extends MybatisBaseRepository<RoleModel, Long, RoleModelExample> {

  /**
   * 根据角色ID取角色mdoel，包含权限list
   *
   * @param roleId 角色ID
   * @return RoleModel
   */
  RoleModel getRole(final String roleId);
}