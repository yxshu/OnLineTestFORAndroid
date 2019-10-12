package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CatalogActivity extends AppCompatActivity {

    private static final String TAG = CatalogActivity.class.getSimpleName();
    private static final String JsonQuestion = "{\"QuestionId\":2816,\"QuestionTitle\":\"你船在分道通航制区域的通航分道内遇到另一机动船，且只能见到他船的尾灯并赶上他船，此时从安全角度考虑你船应_______。\",\"AnswerA\":\"从他船的右舷追越，并让清他船\",\"AnswerB\":\"保速保向\",\"AnswerC\":\"从他船的左舷追越，并让清他船\",\"AnswerD\":\"根据需要,尽量减小转向的角度，以避免航程的损失\",\"CorrectAnswer\":3,\"Explain\":\"从他船左舷追越是良好船艺（不会造成被误认为交叉相遇局面的可能）。\",\"ImageAddress\":\"\",\"DifficultyId\":1,\"UserId\":1,\"UpLoadTime\":\"\\/Date(1508478079000)\\/\",\"VerifyTimes\":0,\"IsVerified\":false,\"IsDelte\":false,\"IsSupported\":0,\"IsDeSupported\":0,\"PaperCodeId\":5,\"TextBookId\":10,\"ChapterId\":58,\"PastExamPaperId\":null,\"PastExamQuestionId\":null,\"Remark\":\"\"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Intent intent = getIntent();
        String subject=intent.getStringExtra("subject");
        //int subject = intent.getIntExtra(this.getString(R.string.subject), R.string.error);
        TextView tv = findViewById(R.id.textView);
        final TextView tv2 = findViewById(R.id.textView2);
        tv.setText(subject);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getApplicationContext().getResources().getString(R.string.url))
                .get()  //默认为GET请求，可以不写
                .build();
        final Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.d(TAG, "OnResponse: " + response.body().toString());
                String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv2.setText("success" + result.substring(0, 10));
                        try {
                            JSONObject jsonobject = new JSONObject(JsonQuestion);
//                            Log.d(TAG, "jsonobject:" + jsonobject.toString());
                            tv2.setText(jsonobject.getString("QuestionTitle"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
