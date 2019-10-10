package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Intent intent = getIntent();
        int subject = intent.getIntExtra(this.getString(R.string.subject), R.string.error);
        TextView tv = findViewById(R.id.textView);
        tv.setText(String.valueOf(subject));
    }
}
