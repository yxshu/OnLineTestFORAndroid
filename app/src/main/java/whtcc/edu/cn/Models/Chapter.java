package whtcc.edu.cn.Models;

public class Chapter {
    private int ChapterId;
    private int TextBookId;
    private String ChapterName;
    private int ChapterParentNo;
    private int ChapterDeep;
    private String ChapterRemark;
    private boolean IsVerified;

    public int getChapterId() {
        return ChapterId;
    }

    public void setChapterId(int chapterId) {
        ChapterId = chapterId;
    }

    public int getTextBookId() {
        return TextBookId;
    }

    public void setTextBookId(int textBookId) {
        TextBookId = textBookId;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public int getChapterParentNo() {
        return ChapterParentNo;
    }

    public void setChapterParentNo(int chapterParentNo) {
        ChapterParentNo = chapterParentNo;
    }

    public int getChapterDeep() {
        return ChapterDeep;
    }

    public void setChapterDeep(int chapterDeep) {
        ChapterDeep = chapterDeep;
    }

    public String getChapterRemark() {
        return ChapterRemark;
    }

    public void setChapterRemark(String chapterRemark) {
        ChapterRemark = chapterRemark;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }

}
