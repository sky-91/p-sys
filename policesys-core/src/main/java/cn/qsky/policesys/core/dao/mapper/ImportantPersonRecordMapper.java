package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModelExample;
import cn.qsky.policesys.core.dto.ImportantRecordPageQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportantPersonRecordMapper extends
    MybatisBaseRepository<ImportantPersonRecordModel, Long, ImportantPersonRecordModelExample> {

  /**
   * 查询信息
   *
   * @param importantRecordPageQueryDTO dto
   * @return List
   */
  List<ImportantPersonRecordModel> listImportantPersonRecordForPage(
      @Param(value = "queryDTO") final ImportantRecordPageQueryDTO importantRecordPageQueryDTO);
}