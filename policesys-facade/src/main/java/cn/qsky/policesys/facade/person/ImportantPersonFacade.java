package cn.qsky.policesys.facade.person;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author qsky on 17/12/6
 */
public interface ImportantPersonFacade {

  /**
   * 根据身份证获取重点人员详细信息
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
   * 分页数据查询
   *
   * @param importantPersonPageQueryData data
   * @return Page
   */
  PageData<ImportantPersonInfoData> listImportantPersonForPage(
      final ImportantPersonPageQueryData importantPersonPageQueryData);

  /**
   * 文件导入重点人员底库
   *
   * @param workbook 文件
   * @return boolean
   */
  Boolean uploadPersonInfo(Workbook workbook);

  /**
   * 文件导入人员记录
   *
   * @param workbook 文件
   * @return boolean
   */
  Boolean uploadPersonRecord(Workbook workbook);
}
