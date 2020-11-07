package whtcc.edu.cn.Models;

public class Difficulty {
    private int DifficultyId;
    private int DifficultyRatio;
    private String DifficultyDescrip;
    private String DifficultyRemark;

    public int getDifficultyId() {
        return DifficultyId;
    }

    public void setDifficultyId(int difficultyId) {
        DifficultyId = difficultyId;
    }

    public int getDifficultyRatio() {
        return DifficultyRatio;
    }

    public void setDifficultyRatio(int difficultyRatio) {
        DifficultyRatio = difficultyRatio;
    }

    public String getDifficultyDescrip() {
        return DifficultyDescrip;
    }

    public void setDifficultyDescrip(String difficultyDescrip) {
        DifficultyDescrip = difficultyDescrip;
    }

    public String getDifficultyRemark() {
        return DifficultyRemark;
    }

    public void setDifficultyRemark(String difficultyRemark) {
        DifficultyRemark = difficultyRemark;
    }
}
