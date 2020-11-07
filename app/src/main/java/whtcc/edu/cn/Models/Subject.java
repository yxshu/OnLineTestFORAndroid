package whtcc.edu.cn.Models;

public class Subject {
    private int SubjectId;
    private String SubjectName;
    private String SubjectRemark;
    private boolean IsVerified;

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getSubjectRemark() {
        return SubjectRemark;
    }

    public void setSubjectRemark(String subjectRemark) {
        SubjectRemark = subjectRemark;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }
}
