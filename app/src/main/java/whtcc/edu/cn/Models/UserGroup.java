package whtcc.edu.cn.Models;

public class UserGroup {
    private int UserGroupId;
    private String UserGroupName;
    private String UserGroupRemark;

    public int getUserGroupId() {
        return UserGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        UserGroupId = userGroupId;
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        UserGroupName = userGroupName;
    }

    public String getUserGroupRemark() {
        return UserGroupRemark;
    }

    public void setUserGroupRemark(String userGroupRemark) {
        UserGroupRemark = userGroupRemark;
    }
}
