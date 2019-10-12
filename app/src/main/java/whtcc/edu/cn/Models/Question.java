package whtcc.edu.cn.Models;

import java.sql.Timestamp;
import java.util.Date;

public class Question {

    public int get_questionid() {
        return _questionid;
    }

    public void set_questionid(int _questionid) {
        this._questionid = _questionid;
    }

    public String get_questiontitle() {
        return _questiontitle;
    }

    public void set_questiontitle(String _questiontitle) {
        this._questiontitle = _questiontitle;
    }

    public String get_answera() {
        return _answera;
    }

    public void set_answera(String _answera) {
        this._answera = _answera;
    }

    public String get_answerb() {
        return _answerb;
    }

    public void set_answerb(String _answerb) {
        this._answerb = _answerb;
    }

    public String get_answerc() {
        return _answerc;
    }

    public void set_answerc(String _answerc) {
        this._answerc = _answerc;
    }

    public String get_answerd() {
        return _answerd;
    }

    public void set_answerd(String _answerd) {
        this._answerd = _answerd;
    }

    public int get_correctanswer() {
        return _correctanswer;
    }

    public void set_correctanswer(int _correctanswer) {
        this._correctanswer = _correctanswer;
    }

    public String get_explain() {
        return _explain;
    }

    public void set_explain(String _explain) {
        this._explain = _explain;
    }

    public String get_imageaddress() {
        return _imageaddress;
    }

    public void set_imageaddress(String _imageaddress) {
        this._imageaddress = _imageaddress;
    }

    public int get_difficultyid() {
        return _difficultyid;
    }

    public void set_difficultyid(int _difficultyid) {
        this._difficultyid = _difficultyid;
    }

    public int get_userid() {
        return _userid;
    }

    public void set_userid(int _userid) {
        this._userid = _userid;
    }

    public Timestamp get_uploadtime() {
        return _uploadtime;
    }

    public void set_uploadtime(Timestamp _uploadtime) {
        this._uploadtime = _uploadtime;
    }

    public int get_verifytimes() {
        return _verifytimes;
    }

    public void set_verifytimes(int _verifytimes) {
        this._verifytimes = _verifytimes;
    }

    public Boolean get_isverified() {
        return _isverified;
    }

    public void set_isverified(Boolean _isverified) {
        this._isverified = _isverified;
    }

    public Boolean get_isdelte() {
        return _isdelte;
    }

    public void set_isdelte(Boolean _isdelte) {
        this._isdelte = _isdelte;
    }

    public int get_issupported() {
        return _issupported;
    }

    public void set_issupported(int _issupported) {
        this._issupported = _issupported;
    }

    public int get_isdesupported() {
        return _isdesupported;
    }

    public void set_isdesupported(int _isdesupported) {
        this._isdesupported = _isdesupported;
    }

    public int get_papercodeid() {
        return _papercodeid;
    }

    public void set_papercodeid(int _papercodeid) {
        this._papercodeid = _papercodeid;
    }

    public int get_textbookid() {
        return _textbookid;
    }

    public void set_textbookid(int _textbookid) {
        this._textbookid = _textbookid;
    }

    public int get_chapterid() {
        return _chapterid;
    }

    public void set_chapterid(int _chapterid) {
        this._chapterid = _chapterid;
    }

    public int get_pastexampaperid() {
        return _pastexampaperid;
    }

    public void set_pastexampaperid(int _pastexampaperid) {
        this._pastexampaperid = _pastexampaperid;
    }

    public int get_pastexamquestionid() {
        return _pastexamquestionid;
    }

    public void set_pastexamquestionid(int _pastexamquestionid) {
        this._pastexamquestionid = _pastexamquestionid;
    }

    public String get_remark() {
        return _remark;
    }

    public void set_remark(String _remark) {
        this._remark = _remark;
    }

    private int _questionid;
    private String _questiontitle;
    private String _answera;
    private String _answerb;
    private String _answerc;
    private String _answerd;
    private int _correctanswer;
    private String _explain;
    private String _imageaddress = "Default.jpg";
    private int _difficultyid;
    private int _userid;
    private Timestamp _uploadtime = new Timestamp(new Date().getTime());
    private int _verifytimes = 0;
    private Boolean _isverified = false;
    private Boolean _isdelte = false;
    private int _issupported = 0;
    private int _isdesupported = 0;
    private int _papercodeid;
    private int _textbookid;
    private int _chapterid;
    private int _pastexampaperid;
    private int _pastexamquestionid;
    private String _remark;
}
