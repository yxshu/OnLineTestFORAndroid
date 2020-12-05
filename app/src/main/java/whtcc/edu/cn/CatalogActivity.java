package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import whtcc.edu.cn.Models.Chapter;
import whtcc.edu.cn.Models.Difficulty;
import whtcc.edu.cn.Models.PaperCode;
import whtcc.edu.cn.Models.PastExamPaper;
import whtcc.edu.cn.Models.Question;
import whtcc.edu.cn.Models.Subject;
import whtcc.edu.cn.Models.TextBook;
import whtcc.edu.cn.Models.User;
import whtcc.edu.cn.Models.UserGroup;
import whtcc.edu.cn.Util.PropertiesUtil;

//https://www.cnblogs.com/panhouye/p/6494753.html  Android中Handler使用浅析

/**
 *
 */
public class CatalogActivity extends AppCompatActivity {
    private static final int QuestionFlag = 0x1;
    private static final int SocketTimeOutFlag = 0x2;
    String server;
    LinearLayout linearLayout;
    TextView TXtitle, TXsubject, TXanswer;
    RadioGroup RGchoose;
    RadioButton answerA, answerB, answerC, answerD;
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SocketTimeOutFlag: {
                    Toast.makeText(getApplicationContext(), "Socket Time Out", Toast.LENGTH_SHORT).show();
                    break;
                }
                case QuestionFlag: {
                    List<Object> list = dealMSG(msg);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getClass().equals(Question.class)) {
                            Question question = (Question) list.get(i);
                            TXtitle.setText(question.getQuestionTitle());
                            answerA.setText(question.getAnswerA());
                            answerB.setText(question.getAnswerB());
                            answerC.setText(question.getAnswerC());
                            answerD.setText(question.getAnswerD());
                            TXanswer.setText(String.valueOf(question.getCorrectAnswer()));
                        }
                    }
                    break;
                }
            }
        }
    };
    Button BTNnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");

        TXsubject = findViewById(R.id.subject);
        TXtitle = findViewById(R.id.title);
        TXanswer = findViewById(R.id.answer);
        TXsubject.setText(subject);
        RGchoose = findViewById(R.id.choose);
        BTNnext = findViewById(R.id.next);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        server = new PropertiesUtil("AppConfig", getApplicationContext()).readProperty("serverURL");
        RGchoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(checkedId), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        BTNnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getQuestonThread().start();
            }
        });
        BTNnext.performClick();
    }

    /**
     * 返回一个对象数组6+3，包括：question,difficulty,users,usergroup（根据user.usergroupID获取）,papercodes,subject(根据papercodes.subjectID获取),可能有textbook,chapter,pastexampaper
     *
     * @param message
     * @return
     */


    private List<Object> dealMSG(Message message) {
        List<Object> list = new ArrayList();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(message.obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type[] types = new Type[]{
                Question.class,
                Difficulty.class,
                User.class,
                UserGroup.class,
                PaperCode.class,
                Subject.class,
                TextBook.class,
                Chapter.class,
                PastExamPaper.class
        };
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                Object obj = JSON.parseObject(String.valueOf(jsonArray.get(i)), types[i]);
                list.add(obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //防止Handler引起内存泄漏
    //在关闭activity时停掉对应的后台线程，线程停止就相当于切断了Handler和外部链接的线，Activity自然会在合适的时候被回收；
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        Log.i("tag", "destory");
    }

    //https://www.cnblogs.com/zhuyeshen/p/11429576.html HttpUrlConnection 基础使用
    private class getQuestonThread extends Thread {
        @Override
        public void run() {
            super.run();
            Message message = new Message();
            //message.what = QuestionFlag;
            try {
                URL url = new URL(server + "/ashx/getQuestionbyrand.ashx");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                conn.setReadTimeout(5 * 1000);
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                byte[] data = new byte[1024];
                StringBuilder stringBuffer = new StringBuilder();
                while (inputStream.read(data) != -1) {
                    String s = new String(data, StandardCharsets.UTF_8);
                    stringBuffer.append(s);
                }
                message.what = QuestionFlag;
                message.obj = stringBuffer.toString();
                inputStream.close();
                conn.disconnect();
                handler.sendMessage(message);
            } catch (SocketTimeoutException e) {
                message.what = SocketTimeOutFlag;
                message.obj = null;
                handler.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
