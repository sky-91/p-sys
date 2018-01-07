package cn.qsky.policesys.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("PersonContactInfoVO(重点人员联系信息表)")
public class PersonContactInfoVO {

  @ApiModelProperty(value = "手机号码")
  private String phone;

  @ApiModelProperty(value = "微信绑定名称")
  private String wechatName;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWechatName() {
    return wechatName;
  }

  public void setWechatName(String wechatName) {
    this.wechatName = wechatName;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
