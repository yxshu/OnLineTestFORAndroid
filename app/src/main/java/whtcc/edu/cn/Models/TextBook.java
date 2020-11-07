package whtcc.edu.cn.Models;

public class TextBook {
    private int TextBookId;
    private int PaperCodeId;
    private String TextBookName;
    private String ISBN;
    private boolean IsVerified;

    public int getTextBookId() {
        return TextBookId;
    }

    public void setTextBookId(int textBookId) {
        TextBookId = textBookId;
    }

    public int getPaperCodeId() {
        return PaperCodeId;
    }

    public void setPaperCodeId(int paperCodeId) {
        PaperCodeId = paperCodeId;
    }

    public String getTextBookName() {
        return TextBookName;
    }

    public void setTextBookName(String textBookName) {
        TextBookName = textBookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }

}
