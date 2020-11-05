package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import whtcc.edu.cn.Util.PropertiesUtil;

//https://www.cnblogs.com/panhouye/p/6494753.html  Android中Handler使用浅析

public class CatalogActivity extends AppCompatActivity {
    private static final int Question = 0x1;
    String server;
    myHandler myhandler = new myHandler(this);
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");
        TextView tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv.setText(subject);
        tv2.setText(R.string.loading);
        server = new PropertiesUtil("AppConfig", getApplicationContext()).readProperty("serverURL");
        getQuestionByRand();
    }

    //https://www.cnblogs.com/zhuyeshen/p/11429576.html HttpUrlConnection 基础使用
    public void getQuestionByRand() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = Question;
                try {
                    URL url = new URL(server + "/ashx/getQuestionbyrand.ashx");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5 * 1000);
                    conn.connect();
                    InputStream inputStream = conn.getInputStream();
                    byte[] data = new byte[1024];
                    int length = 0;
                    StringBuilder stringBuffer = new StringBuilder();
                    while ((length = inputStream.read(data)) != -1) {
                        String s = new String(data, Charset.forName("UTF-8"));
                        stringBuffer.append(s);
                    }
                    message.obj = stringBuffer.toString();
                    myhandler.handleMessage(message);
                    inputStream.close();
                    conn.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //防止Handler引起内存泄漏
    //在关闭activity时停掉对应的后台线程，线程停止就相当于切断了Handler和外部链接的线，Activity自然会在合适的时候被回收；
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myhandler.removeCallbacksAndMessages(null);
        Log.i("tag", "destory");
    }

    //Handler静态内部类，静态类不持有外部类的对象，所以Activi可以被随意回收
    //此处使用了弱引用WeakReference，也就是说当在内存不足时，系统会销毁弱/回收引用引用的对象，从而达到优化内存的目的
    private static class myHandler extends Handler {
        //弱引用
        WeakReference<CatalogActivity> weakReference;

        public myHandler(CatalogActivity activity) {
            weakReference = new WeakReference<CatalogActivity>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            CatalogActivity activity = weakReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case Question:
                        activity.tv2.setText(msg.obj.toString());
                }
            }
        }
    }
}
