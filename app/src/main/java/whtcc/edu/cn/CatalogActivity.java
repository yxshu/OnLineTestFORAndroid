package whtcc.edu.cn;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import whtcc.edu.cn.Models.PaperCode;
import whtcc.edu.cn.Models.Question;
import whtcc.edu.cn.Models.User;
import whtcc.edu.cn.Util.PropertiesUtil;

//https://www.cnblogs.com/panhouye/p/6494753.html  Android中Handler使用浅析

public class CatalogActivity extends AppCompatActivity {
    private static final int QuestionFlag = 0x1;
    String server;
    LinearLayout linearLayout;
    TextView tv2;
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case QuestionFlag:
                    dealMSG(msg);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");
        ((TextView) findViewById(R.id.textView)).setText(subject);
        server = new PropertiesUtil("AppConfig", getApplicationContext()).readProperty("serverURL");
        Button btnGetQuestion = findViewById(R.id.getQuestoin);
        tv2 = findViewById(R.id.textView2);
        btnGetQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getQuestonThread().start();
            }
        });
    }

    private void dealMSG(Message message) {
        try {
            JSONArray jsonArray = new JSONArray(message.obj.toString());
            Question question = new Question();
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            question.setQuestionId(jsonObject.getInt("QuestionId"));
            question.setQuestionTitle(jsonObject.getString("QuestionTitle"));
            question.setAnswerA(jsonObject.getString("AnswerA"));
            question.setAnswerB(jsonObject.getString("AnswerB"));
            question.setAnswerC(jsonObject.getString("AnswerC"));
            question.setAnswerD(jsonObject.getString("AnswerD"));
            question.setCorrectAnswer(jsonObject.getInt("CorrectAnswer"));
            question.setExplain(jsonObject.getString("Explain"));
//           question.setImageAddress(jsonObject.getString(""));
//            question.setDifficultyId(jsonObject.getInt(""));
//            question.setUserId(jsonObject.getInt(""));
//            //question.setUpLoadTime(Date.jsonObject.getString("")));
//            question.setVerifyTimes(jsonObject.getInt(""));
//            //question.isVerified(jsonObject.getInt(""));
////            question.isDelte(jsonObject.getString(""));
//            question.getIsSupported(jsonObject.getInt(""));
//            question.setIsDeSupported(jsonObject.getInt(""));
//            question.setPaperCodeId(jsonObject.getInt(""));
//            question.setTextBookId(jsonObject.getInt(""));
//            question.setChapterId(jsonObject.getInt(""));
            tv2.setText(question.getQuestionTitle());
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
            message.what = QuestionFlag;
            try {
                URL url = new URL(server + "/ashx/getQuestionbyrand.ashx");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                byte[] data = new byte[1024];
                StringBuilder stringBuffer = new StringBuilder();
                while (inputStream.read(data) != -1) {
                    String s = new String(data, StandardCharsets.UTF_8);
                    stringBuffer.append(s);
                }
                message.obj = stringBuffer.toString();
                inputStream.close();
                conn.disconnect();
                handler.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
