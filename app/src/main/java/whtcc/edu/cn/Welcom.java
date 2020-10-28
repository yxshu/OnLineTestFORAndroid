package whtcc.edu.cn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 *
 */
public class Welcom extends AppCompatActivity {
    private boolean isFirstIn = false;
    private static final int TIME = 2000;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        init();
    }

    private void init() {
        SharedPreferences sharedPreferences = getSharedPreferences("welCome", MODE_PRIVATE);//得到参数：是否第一次进入
        boolean isFirstIn = sharedPreferences.getBoolean("isFirstIn", true);
        if (!isFirstIn) {
            handler.sendEmptyMessageDelayed(GO_HOME, TIME);
        } else {
            handler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirstIn", false);
            editor.apply();
        }
    }

    /*
    * Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                //do something
                return true;
            }
        });
    * */
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            return true;
        }
    });

    private void goGuide() {
        Intent i = new Intent(Welcom.this, Guide.class);
        startActivity(i);
        finish();
    }

    private void goHome() {
        Intent i = new Intent(Welcom.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}