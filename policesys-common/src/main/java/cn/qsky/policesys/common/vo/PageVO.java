package cn.qsky.policesys.common.vo;

import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Mybatis - 分页DTO对象
 *
 * @author qsky on 2017/6/9.
 */
public class PageVO<O> {

  /**
   * 查询内容
   */
  private List<O> content;
  /**
   * 页码，从1开始
   */
  private Integer pageNum;
  /**
   * 页面大小
   */
  private Integer pageSize;
  /**
   * 总页数
   */
  private Integer pages;
  /**
   * 总数
   */
  private Long total;

  public PageVO() {
  }

  public PageVO(Integer pageNum, Integer pageSize, Integer pages, Long total, List<O> content) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.pages = pages;
    this.total = total;
    this.content = content;
  }

  public List<O> getContent() {
    return content;
  }

  public void setContent(final List<O> content) {
    this.content = content;
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(final Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(final Integer pages) {
    this.pages = pages;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(final Long total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
