package whtcc.edu.cn.Models;

public class PaperCode {
    private int PaperCodeId;
    private int SubjectId;
    private String PaperCode;
    private String ChineseName;
    private int PaperCodePassScore;
    private int PaperCodeTotalScore;
    private int TimeRange;
    private String PaperCodeRemark;
    private boolean IsVerified;

    public int getPaperCodeId() {
        return PaperCodeId;
    }

    public void setPaperCodeId(int paperCodeId) {
        PaperCodeId = paperCodeId;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public String getPaperCode() {
        return PaperCode;
    }

    public void setPaperCode(String paperCode) {
        PaperCode = paperCode;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String chineseName) {
        ChineseName = chineseName;
    }

    public int getPaperCodePassScore() {
        return PaperCodePassScore;
    }

    public void setPaperCodePassScore(int paperCodePassScore) {
        PaperCodePassScore = paperCodePassScore;
    }

    public int getPaperCodeTotalScore() {
        return PaperCodeTotalScore;
    }

    public void setPaperCodeTotalScore(int paperCodeTotalScore) {
        PaperCodeTotalScore = paperCodeTotalScore;
    }

    public int getTimeRange() {
        return TimeRange;
    }

    public void setTimeRange(int timeRange) {
        TimeRange = timeRange;
    }

    public String getPaperCodeRemark() {
        return PaperCodeRemark;
    }

    public void setPaperCodeRemark(String paperCodeRemark) {
        PaperCodeRemark = paperCodeRemark;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }
}
