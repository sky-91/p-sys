package cn.qsky.policesys.facade.person;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import cn.qsky.policesys.facade.person.data.ImportantRecordPageQueryData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author qsky on 17/12/6
 */
public interface ImportantPersonFacade {

  /**
   * 根据身份证获取重点人员详细信息 获取所有的轨迹积分按时间倒序排列
   *
   * @param idCard 身份证
   * @return ImportantPersonInfoData
   */
  ImportantPersonInfoData getImportantPersonInfo(final String idCard);

  /**
   * 保存重点人员底库
   *
   * @param importantPersonInfoData data
   * @return boolean
   */
  Boolean saveImportantPersonInfo(final ImportantPersonInfoData importantPersonInfoData);

  /**
   * 更新重点人员底库
   *
   * @param importantPersonInfoData data
   * @return boolean
   */
  Boolean updateImportantPersonInfo(final ImportantPersonInfoData importantPersonInfoData);

  /**
   * 删除重点人员底库
   *
   * @param idCard idCard
   * @return boolean
   */
  Boolean deleteImportantPersonInfo(final String idCard);

  /**
   * 分页数据查询
   *
   * @param importantPersonPageQueryData data
   * @return Page
   */
  PageData<ImportantPersonInfoData> listImportantPersonForPage(
      final ImportantPersonPageQueryData importantPersonPageQueryData);

  /**
   * 根据pk查询人员积分轨迹信息
   *
   * @param pk pk
   * @return ImportantPersonRecordData
   */
  ImportantPersonRecordData getImportantPersonRecord(final String pk);

  /**
   * 保存重点人员轨迹
   *
   * @param importantPersonRecordData data
   * @return boolean
   */
  Boolean saveImportantPersonRecord(final ImportantPersonRecordData importantPersonRecordData);

  /**
   * 更新重点人员轨迹
   *
   * @param importantPersonRecordData data
   * @return boolean
   */
  Boolean updateImportantPersonRecord(final ImportantPersonRecordData importantPersonRecordData);

  /**
   * 删除重点人员轨迹
   *
   * @param pk pk
   * @return boolean
   */
  Boolean deleteImportantPersonRecord(final String pk);

  /**
   * 分页数据查询
   *
   * @param importantRecordPageQueryData data
   * @return Page
   */
  PageData<ImportantPersonRecordData> listImportantRecordForPage(
      final ImportantRecordPageQueryData importantRecordPageQueryData);

  /**
   * 文件导入重点人员底库
   *
   * @param workbook 文件
   * @return boolean
   */
  Boolean uploadPersonInfo(Workbook workbook);

  /**
   * 文件导入人员轨迹
   *
   * @param workbook 文件
   * @return boolean
   */
  Boolean uploadPersonRecord(Workbook workbook);

  /**
   * 导出重点人员EXCEL
   *
   * @param importantPersonPageQueryData data
   * @return workbook
   */
  HSSFWorkbook exportImportantPerson(
      final ImportantPersonPageQueryData importantPersonPageQueryData);

  /**
   * 导出重点人员积分轨迹EXCEL
   *
   * @param importantRecordPageQueryData data
   * @return workbook
   */
  HSSFWorkbook exportImportantRecord(
      final ImportantRecordPageQueryData importantRecordPageQueryData);
}
