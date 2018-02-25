package cn.qsky.policesys.facade.group.data;

import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dozer.Mapping;

/**
 * @author qsky on 18/1/7
 */
public class GroupSummaryData {

  @Mapping("ext1")
  private String index;

  private String groupName;

  private String groupType;

  private String groupIntroduce;

  private Boolean deleteFlag;

  private List<GroupRecordData> records;

  public String getIndex() {
    return index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

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

  public List<GroupRecordData> getRecords() {
    return records;
  }

  public void setRecords(List<GroupRecordData> records) {
    this.records = records;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, true, true);
  }
}
