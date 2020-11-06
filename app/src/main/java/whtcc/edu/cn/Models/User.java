package whtcc.edu.cn.Models;

import java.util.Date;
import java.util.PrimitiveIterator;

public class User {
    private int UserId;
    private String UserName;
    private String UserPassword;
    private String UserChineseName;
    private String UserImageName;
    private String UserEmail;
    private boolean IsValidate;
    private String Tel;
    private int UserScore;
    private Date UserRegisterDatetime;
    private int UserGroupId;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserChineseName() {
        return UserChineseName;
    }

    public void setUserChineseName(String userChineseName) {
        UserChineseName = userChineseName;
    }

    public String getUserImageName() {
        return UserImageName;
    }

    public void setUserImageName(String userImageName) {
        UserImageName = userImageName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public boolean isValidate() {
        return IsValidate;
    }

    public void setValidate(boolean validate) {
        IsValidate = validate;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public int getUserScore() {
        return UserScore;
    }

    public void setUserScore(int userScore) {
        UserScore = userScore;
    }

    public Date getUserRegisterDatetime() {
        return UserRegisterDatetime;
    }

    public void setUserRegisterDatetime(Date userRegisterDatetime) {
        UserRegisterDatetime = userRegisterDatetime;
    }

    public int getUserGroupId() {
        return UserGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        UserGroupId = userGroupId;
    }
}
