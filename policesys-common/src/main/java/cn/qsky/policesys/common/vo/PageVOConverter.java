package cn.qsky.policesys.common.vo;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * Mybatis - 分页转换对象
 *
 * @author jiangbin on 2017/6/9.
 */
public class PageVOConverter {

  private PageVOConverter() {
  }

  /**
   * 分页对象转换，由Page《I》转换为PageDTO《O》
   *
   * @param page com.github.pagehelper分页对象
   * @param o 转换对象
   * @return 转换后的分页对象PageData《O》
   */
  public static <O, I> PageVO<O> converter(PageData<I> page, Class<O> o) {
    if (page.getTotal() == 0) {
      return new PageVO<>(page.getPageNum(),
          page.getPageSize(), page.getPages(), page.getTotal(), Collections.emptyList());
    }
    List<O> outList = new ArrayList<>();
    for (I i : page.getContent()) {
      O oo = BeanUtils.instantiate(o);
      CglibBeanUtil.copyProperties(i, oo);
      outList.add(oo);
    }
    return new PageVO<>(page.getPageNum(),
        page.getPageSize(), page.getPages(), page.getTotal(), outList);
  }
}
