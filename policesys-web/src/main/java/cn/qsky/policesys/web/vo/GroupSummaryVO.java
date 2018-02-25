package cn.qsky.policesys.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author qsky on 18/1/7
 */
@ApiModel("GroupSummaryVO(群体汇总信息)")
public class GroupSummaryVO {

  @ApiModelProperty(value = "群体名称")
  private String groupName;

  @ApiModelProperty(value = "群体类别")
  private String groupType;

  @ApiModelProperty(value = "群体简介")
  private String groupIntroduce;

  @ApiModelProperty(value = "删除标记")
  private Boolean deleteFlag;

  @ApiModelProperty(value = "群体轨迹")
  private List<GroupRecordVO> records;

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupType() {
    return groupType;
  }

  public void setGroupType(String groupType) {
    this.groupType = groupType;
  }

  public String getGroupIntroduce() {
    return groupIntroduce;
  }

  public void setGroupIntroduce(String groupIntroduce) {
    this.groupIntroduce = groupIntroduce;
  }

  public Boolean getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public List<GroupRecordVO> getRecords() {
    return records;
  }

  public void setRecords(List<GroupRecordVO> records) {
    this.records = records;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
