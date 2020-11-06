package whtcc.edu.cn.Models;

import android.hardware.camera2.params.BlackLevelPattern;

import java.sql.Timestamp;
import java.util.Date;

public class Question {


    private int QuestionId;
    private String QuestionTitle;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private String AnswerD;
    private int CorrectAnswer;
    private String Explain;
    private String ImageAddress;
    private int DifficultyId;
    private int UserId;
    private Date UpLoadTime;
    private int VerifyTimes;
    private boolean IsVerified;
    private boolean IsDelte;
    private int IsSupported;
    private int IsDeSupported;
    private int PaperCodeId;
    private int TextBookId;
    private int ChapterId;
    private int PastExamPaperId;
    private int PastExamQuestionId;
    private String Remark;

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    public String getQuestionTitle() {
        return QuestionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        QuestionTitle = questionTitle;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public int getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getExplain() {
        return Explain;
    }

    public void setExplain(String explain) {
        Explain = explain;
    }

    public String getImageAddress() {
        return ImageAddress;
    }

    public void setImageAddress(String imageAddress) {
        ImageAddress = imageAddress;
    }

    public int getDifficultyId() {
        return DifficultyId;
    }

    public void setDifficultyId(int difficultyId) {
        DifficultyId = difficultyId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Date getUpLoadTime() {
        return UpLoadTime;
    }

    public void setUpLoadTime(Date upLoadTime) {
        UpLoadTime = upLoadTime;
    }

    public int getVerifyTimes() {
        return VerifyTimes;
    }

    public void setVerifyTimes(int verifyTimes) {
        VerifyTimes = verifyTimes;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }

    public boolean isDelte() {
        return IsDelte;
    }

    public void setDelte(boolean delte) {
        IsDelte = delte;
    }

    public int getIsSupported(int anInt) {
        return IsSupported;
    }

    public void setIsSupported(int isSupported) {
        IsSupported = isSupported;
    }

    public int getIsDeSupported() {
        return IsDeSupported;
    }

    public void setIsDeSupported(int isDeSupported) {
        IsDeSupported = isDeSupported;
    }

    public int getPaperCodeId() {
        return PaperCodeId;
    }

    public void setPaperCodeId(int paperCodeId) {
        PaperCodeId = paperCodeId;
    }

    public int getTextBookId() {
        return TextBookId;
    }

    public void setTextBookId(int textBookId) {
        TextBookId = textBookId;
    }

    public int getChapterId() {
        return ChapterId;
    }

    public void setChapterId(int chapterId) {
        ChapterId = chapterId;
    }

    public int getPastExamPaperId() {
        return PastExamPaperId;
    }

    public void setPastExamPaperId(int pastExamPaperId) {
        PastExamPaperId = pastExamPaperId;
    }

    public int getPastExamQuestionId() {
        return PastExamQuestionId;
    }

    public void setPastExamQuestionId(int pastExamQuestionId) {
        PastExamQuestionId = pastExamQuestionId;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
