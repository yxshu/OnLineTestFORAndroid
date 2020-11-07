package whtcc.edu.cn.Models;

import java.util.Date;

public class PastExamPaper {
    private int PastexampaperId;
    private int PapercodeId;
    private int ExamzoneId;
    private int Pastexampaperperiodno;
    private Date Pastexampaperdatetime;
    private boolean Isverified;

    public int getPastexampaperId() {
        return PastexampaperId;
    }

    public void setPastexampaperId(int pastexampaperId) {
        PastexampaperId = pastexampaperId;
    }

    public int getPapercodeId() {
        return PapercodeId;
    }

    public void setPapercodeId(int papercodeId) {
        PapercodeId = papercodeId;
    }

    public int getExamzoneId() {
        return ExamzoneId;
    }

    public void setExamzoneId(int examzoneId) {
        ExamzoneId = examzoneId;
    }

    public int getPastexampaperperiodno() {
        return Pastexampaperperiodno;
    }

    public void setPastexampaperperiodno(int pastexampaperperiodno) {
        Pastexampaperperiodno = pastexampaperperiodno;
    }

    public Date getPastexampaperdatetime() {
        return Pastexampaperdatetime;
    }

    public void setPastexampaperdatetime(Date pastexampaperdatetime) {
        Pastexampaperdatetime = pastexampaperdatetime;
    }

    public boolean isIsverified() {
        return Isverified;
    }

    public void setIsverified(boolean isverified) {
        Isverified = isverified;
    }
}
