package cn.qsky.policesys.core.person;

import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import com.github.pagehelper.Page;

/**
 * @author qsky on 17/12/6
 */
public interface ImportantPersonService {

  /**
   * 只获取重点人员自身信息
   *
   * @param idCard 身份证
   * @return ImportantPersonInfoModel
   */
  ImportantPersonInfoModel getSimplePersonInfo(final String idCard);

  /**
   * 根据身份证获取重点人员详细信息
   *
   * @param idCard 身份证
   * @return ImportantPersonInfoModel
   */
  ImportantPersonInfoModel getImportantPersonInfo(final String idCard);

  /**
   * 根据身份证校验重点人员
   *
   * @param idCard 身份证
   * @return int
   */
  int countImportantPerson(final String idCard);

  /**
   * 保存重点人员底库
   *
   * @param importantPersonInfoModel model
   * @return int
   */
  int saveImportantPersonInfo(final ImportantPersonInfoModel importantPersonInfoModel);

  /**
   * 更新重点人员底库
   *
   * @param importantPersonInfoModel model
   * @return int
   */
  int updateImportantPersonInfo(final ImportantPersonInfoModel importantPersonInfoModel);

  /**
   * 保存重点人员记录
   *
   * @param importantPersonRecordModel model
   * @return int
   */
  int saveImportantPersonRecord(final ImportantPersonRecordModel importantPersonRecordModel);

  /**
   * 更新重点人员记录
   *
   * @param importantPersonRecordModel model
   * @return int
   */
  int updateImportantPersonRecord(final ImportantPersonRecordModel importantPersonRecordModel);

  /**
   * 分页数据查询
   *
   * @param importantPersonPageQueryDTO dto
   * @return Page
   */
  Page<ImportantPersonInfoModel> listImportantPersonForPage(
      final ImportantPersonPageQueryDTO importantPersonPageQueryDTO);
}
