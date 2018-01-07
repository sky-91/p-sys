package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModelExample;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImportantPersonInfoMapper extends
    MybatisBaseRepository<ImportantPersonInfoModel, Long, ImportantPersonInfoModelExample> {

  /**
   * 根据身份证获取重点人员详细信息
   *
   * @param IdCard IdCard
   * @return ImportantPersonInfoModel
   */
  ImportantPersonInfoModel getImportantPersonInfo(final String IdCard);

  /**
   * 查询信息
   *
   * @param importantPersonPageQueryDTO dto
   * @return List
   */
  List<ImportantPersonInfoModel> listImportantPersonInfoForPage(
      @Param(value = "queryDTO") final ImportantPersonPageQueryDTO importantPersonPageQueryDTO);
}