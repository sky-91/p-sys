package cn.qsky.policesys.common.data;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import com.github.pagehelper.Page;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * Mybatis - 分页转换对象
 *
 * @author jiangbin on 2017/6/9.
 */
public class PageDataConverter {

  private PageDataConverter() {
  }

  /**
   * @param page
   * @param o
   * @param <O>
   * @param <I>
   * @return
   */
  public static <O, I> PageData<O> converter(Page<I> page, Class<O> o) {
    if (page.getTotal() == 0) {
      return new PageData<>(page.getPageNum(),
          page.getPageSize(), page.getPages(), page.getTotal(), Collections.emptyList());
    }
    List<O> outList = new ArrayList<>();
    for (I i : page.getResult()) {
      O oo = BeanUtils.instantiate(o);
      CglibBeanUtil.copyProperties(i, oo);
      outList.add(oo);
    }
    return new PageData<>(page.getPageNum(),
        page.getPageSize(), page.getPages(), page.getTotal(), outList);
  }
}
