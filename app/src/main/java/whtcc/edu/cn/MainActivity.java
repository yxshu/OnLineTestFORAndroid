package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import whtcc.edu.cn.Util.PropertiesUtil;
import whtcc.edu.cn.define_widget.Btn_certification;
import whtcc.edu.cn.define_widget.Btn_qualification;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout_qualification, constraintLayout_certification;


    /**
     * 设置布局参数
     *
     * @param margin 各控件之间的间隔
     * @param column 总的列数
     * @param parent 父控件
     * @param views  总的控件
     * @param i      当前设置的控件序号
     * @return 设置的参数
     */
    private ConstraintLayout.LayoutParams setLayoutParams(int margin, int column, ConstraintLayout parent, View[] views, int i) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                0,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.horizontalWeight = 1;
        layoutParams.setMargins(margin, margin, margin, margin);
        if (i % column == 0) {//第一列
            layoutParams.startToStart = parent.getId();
            if (i < views.length - 1) {
                layoutParams.endToStart = views[i + 1].getId();
            } else {//最后一列没有填满，填充整个行
                layoutParams.endToEnd = parent.getId();
            }
        } else if (i % column == column - 1) {//最后一列
            layoutParams.endToEnd = parent.getId();
            layoutParams.startToEnd = views[i - 1].getId();
        } else {//其他列
            layoutParams.startToEnd = views[i - 1].getId();
            if (i < views.length - 1) {
                layoutParams.endToStart = views[i + 1].getId();
            } else {//最后一列没有填满，填充整个行
                layoutParams.endToEnd = parent.getId();
            }
        }
        if (i / column == 0) {//第一行
            layoutParams.topToTop = parent.getId();
        } else {//其他行
            layoutParams.topToBottom = views[i - column].getId();
        }
        return layoutParams;
    }


    private void initView() {
        PropertiesUtil propertiesUtil = new PropertiesUtil("AppConfig", getApplicationContext());
        String str_Qualification = propertiesUtil.readProperty("Qualification");
        String str_Certification = propertiesUtil.readProperty("Certificate");
        String column = propertiesUtil.readProperty("Column");
        String margin = propertiesUtil.readProperty("margin");
        Btn_qualification[] btn_qualifications;//用于生成按钮的数组
        Btn_certification[] btn_certifications;
        int Column_Qualification, Column_Certification, Margin_Qualification, Margin_Certification;
        try {
            JSONArray jsonArrayQualification = new JSONArray(str_Qualification);
            JSONArray jsonArrayCertification = new JSONArray(str_Certification);
            JSONObject jsonObjectColumn = new JSONObject(column);
            JSONObject jsonObjectmargin = new JSONObject(margin);
            Column_Qualification = jsonObjectColumn.getInt("Qualification");
            Column_Certification = jsonObjectColumn.getInt("Certificate");
            Margin_Qualification = jsonObjectmargin.getInt("Qualification");
            Margin_Certification = jsonObjectmargin.getInt("Certificate");
            btn_qualifications = new Btn_qualification[jsonArrayQualification.length()];
            for (int i = 0; i < jsonArrayQualification.length(); i++) {
                JSONObject qualification = jsonArrayQualification.getJSONObject(i);
                //结构如是：{"value_id":"captain","draw_imgview":"icon_title","tv_text":"船长","click_value":"船长"},\
                Btn_qualification btn_qualification = new Btn_qualification(getApplicationContext());
                int id = getResources().getIdentifier(qualification.getString("value_id"), "id", getPackageName());
                int imageID = getResources().getIdentifier(qualification.getString("draw_imgview"), "drawable", getPackageName());
                btn_qualification.setId(id);
                btn_qualification.setImageViewResource(imageID);
                btn_qualification.setTextViewText(qualification.getString("tv_text"));
                btn_qualification.setOnClickListener(new onMyClickListener(qualification.getString("value_id")));
                btn_qualifications[i] = btn_qualification;
                //btn_qualification.setLayoutParams(setLayoutParams(10, Column_Qualification, constraintLayout_qualification, btn_qualifications, i));
            }
            for (int m = 0; m < btn_qualifications.length; m++) {
                btn_qualifications[m].setLayoutParams(setLayoutParams(Margin_Qualification, Column_Qualification, constraintLayout_qualification, btn_qualifications, m));
                constraintLayout_qualification.addView(btn_qualifications[m]);
            }

            btn_certifications = new Btn_certification[jsonArrayCertification.length()];
            for (int j = 0; j < jsonArrayCertification.length(); j++) {
                JSONObject certification = jsonArrayCertification.getJSONObject(j);
                //结构如是：{"value_id":"Z01","draw_imgview":"icon_z01","tv_text":"Z01","tv_descrip":"基本安全","click_value":"Z01"},
                Btn_certification btn_certification = new Btn_certification(getApplicationContext());
                int id = getResources().getIdentifier(certification.getString("value_id"), "id", getPackageName());
                int imageID = getResources().getIdentifier(certification.getString("draw_imgview"), "drawable", getPackageName());
                btn_certification.setId(id);
                btn_certification.setImageViewResource(imageID);
                btn_certification.setTextViewCode(certification.getString("tv_text"));
                btn_certification.setTextViewDescrip(certification.getString("tv_descrip"));
                btn_certification.setOnClickListener(new onMyClickListener(certification.getString("value_id")));
                btn_certifications[j] = btn_certification;
                //btn_certification.setLayoutParams(setLayoutParams(0, Column_Certification, constraintLayout_certification, btn_certifications, j));
            }
            for (int n = 0; n < btn_certifications.length; n++) {
                btn_certifications[n].setLayoutParams(setLayoutParams(Margin_Certification, Column_Certification, constraintLayout_certification, btn_certifications, n));
                constraintLayout_certification.addView(btn_certifications[n]);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tx_qualification = findViewById(R.id.qualification);
        TextView tx_certification = findViewById(R.id.certification);
        tx_qualification.setText(R.string.qualification);//标题-大证
        tx_certification.setText(R.string.certificate);//标题-小证
        constraintLayout_qualification = findViewById(R.id.constraintLayout_qualification);//相对布局-大证
        constraintLayout_certification = findViewById(R.id.constraintLayout_certification);//相对布局-小证
        initView();
    }

    /**/
    class onMyClickListener implements View.OnClickListener {
        final String subject;

        onMyClickListener(String subject) {
            this.subject = subject;
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            Intent intent = new Intent(MainActivity.this, CatalogActivity.class);
            intent.putExtra("subject", subject);
            intent.putExtra("id", id);
            startActivity(intent);
        }
    }
}

