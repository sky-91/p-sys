package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupRecordModelExample;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupRecordMapper extends
    MybatisBaseRepository<GroupRecordModel, Long, GroupRecordModelExample> {

  /**
   * 分页查询信息
   *
   * @param groupRecordPageQueryDTO dto
   * @return list
   */
  List<GroupRecordModel> listGroupRecordForPage(
          @Param(value = "queryDTO") final GroupRecordPageQueryDTO groupRecordPageQueryDTO);
}