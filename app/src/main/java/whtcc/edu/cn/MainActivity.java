package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import whtcc.edu.cn.define_widget.Btn_certification;
import whtcc.edu.cn.define_widget.Btn_qualification;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_certification btnCertificationZ01 = findViewById(R.id.Z01);
        btnCertificationZ01.setImageViewResource(R.drawable.icon_z01);
        btnCertificationZ01.setTextViewCode(R.string.Z01);
        btnCertificationZ01.setTextViewDescrip(R.string.z01);
        btnCertificationZ01.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z01)));

        Btn_certification btnCertificationZ02 = findViewById(R.id.Z02);
        btnCertificationZ02.setImageViewResource(R.drawable.icon_z02);
        btnCertificationZ02.setTextViewCode(R.string.Z02);
        btnCertificationZ02.setTextViewDescrip(R.string.z02);
        btnCertificationZ02.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z02)));

        Btn_certification btnCertificationZ04 = findViewById(R.id.Z04);
        btnCertificationZ04.setImageViewResource(R.drawable.icon_z04);
        btnCertificationZ04.setTextViewCode(R.string.Z04);
        btnCertificationZ04.setTextViewDescrip(R.string.z04);
        btnCertificationZ04.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z04)));

        Btn_certification btnCertificationZ05 = findViewById(R.id.Z05);
        btnCertificationZ05.setImageViewResource(R.drawable.icon_z05);
        btnCertificationZ05.setTextViewCode(R.string.Z05);
        btnCertificationZ05.setTextViewDescrip(R.string.z05);
        btnCertificationZ05.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z05)));

        Btn_certification btnCertificationZ06 = findViewById(R.id.Z06);
        btnCertificationZ06.setImageViewResource(R.drawable.icon_z06);
        btnCertificationZ06.setTextViewCode(R.string.Z06);
        btnCertificationZ06.setTextViewDescrip(R.string.z06);
        btnCertificationZ06.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z06)));

        Btn_certification btnCertificationZ078 = findViewById(R.id.Z078);
        btnCertificationZ078.setImageViewResource(R.drawable.icon_z078);
        btnCertificationZ078.setTextViewCode(R.string.Z078);
        btnCertificationZ078.setTextViewDescrip(R.string.z078);
        btnCertificationZ078.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z078)));

        Btn_certification btnCertificationZ09 = findViewById(R.id.Z09);
        btnCertificationZ09.setImageViewResource(R.drawable.icon_z09);
        btnCertificationZ09.setTextViewCode(R.string.Z09);
        btnCertificationZ09.setTextViewDescrip(R.string.z09);
        btnCertificationZ09.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Z09)));

        Btn_certification btnCertificationT01 = findViewById(R.id.T01);
        btnCertificationT01.setImageViewResource(R.drawable.icon_t01);
        btnCertificationT01.setTextViewCode(R.string.T01);
        btnCertificationT01.setTextViewDescrip(R.string.t01);
        btnCertificationT01.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.T01)));

        Btn_certification btnCertificationT02 = findViewById(R.id.T02);
        btnCertificationT02.setImageViewResource(R.drawable.icon_t02);
        btnCertificationT02.setTextViewCode(R.string.T02);
        btnCertificationT02.setTextViewDescrip(R.string.t02);
        btnCertificationT02.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.T02)));

        Btn_certification btnCertificationT03 = findViewById(R.id.T03);
        btnCertificationT03.setImageViewResource(R.drawable.icon_t03);
        btnCertificationT03.setTextViewCode(R.string.T03);
        btnCertificationT03.setTextViewDescrip(R.string.t03);
        btnCertificationT03.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.T03)));

        Btn_certification btnCertificationT06 = findViewById(R.id.T06);
        btnCertificationT06.setImageViewResource(R.drawable.icon_t06);
        btnCertificationT06.setTextViewCode(R.string.T06);
        btnCertificationT06.setTextViewDescrip(R.string.t06);
        btnCertificationT06.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.T06)));

        Btn_certification btnCertificationT07 = findViewById(R.id.T07);
        btnCertificationT07.setImageViewResource(R.drawable.icon_t07);
        btnCertificationT07.setTextViewCode(R.string.T07);
        btnCertificationT07.setTextViewDescrip(R.string.t07);
        btnCertificationT07.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.T07)));

        Btn_qualification btnQualificationCaption = findViewById(R.id.btn_captain);
        btnQualificationCaption.setImageViewResource(R.drawable.icon_title);
        btnQualificationCaption.setTextViewText(R.string.captain);
        btnQualificationCaption.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.captain)));

        Btn_qualification btnQualificationCheif_officer = findViewById(R.id.btn_chief);
        btnQualificationCheif_officer.setImageViewResource(R.drawable.icon_title);
        btnQualificationCheif_officer.setTextViewText(R.string.cheif_officer);
        btnQualificationCheif_officer.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.cheif_officer)));

        Btn_qualification btnQualificationThird_officer = findViewById(R.id.btn_third);
        btnQualificationThird_officer.setImageViewResource(R.drawable.icon_title);
        btnQualificationThird_officer.setTextViewText(R.string.third_officer);
        btnQualificationThird_officer.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.third_officer)));

        Btn_qualification btnQualificationChief_engineer = findViewById(R.id.btn_eng_chief);
        btnQualificationChief_engineer.setImageViewResource(R.drawable.icon_title);
        btnQualificationChief_engineer.setTextViewText(R.string.Chief_engineer);
        btnQualificationChief_engineer.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.Chief_engineer)));

        Btn_qualification btnQualificationSecond_engineer = findViewById(R.id.btn_eng_second);
        btnQualificationSecond_engineer.setImageViewResource(R.drawable.icon_title);
        btnQualificationSecond_engineer.setTextViewText(R.string.second_engineer);
        btnQualificationSecond_engineer.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.second_engineer)));

        Btn_qualification btnQualificationForth_engineer = findViewById(R.id.btn_eng_forth);
        btnQualificationForth_engineer.setImageViewResource(R.drawable.icon_title);
        btnQualificationForth_engineer.setTextViewText(R.string.forth_engineer);
        btnQualificationForth_engineer.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.forth_engineer)));

        Btn_qualification btnQualificationSailor = findViewById(R.id.btn_sailer);
        btnQualificationSailor.setImageViewResource(R.drawable.icon_title);
        btnQualificationSailor.setTextViewText(R.string.sailor);
        btnQualificationSailor.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.sailor)));

        Btn_qualification btnQualificationMotorman = findViewById(R.id.btn_motor);
        btnQualificationMotorman.setImageViewResource(R.drawable.icon_title);
        btnQualificationMotorman.setTextViewText(R.string.motorman);
        btnQualificationMotorman.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.motorman)));

        Btn_qualification btnQualificationGMDSS = findViewById(R.id.btn_GMDSS);
        btnQualificationGMDSS.setImageViewResource(R.drawable.icon_title);
        btnQualificationGMDSS.setTextViewText(R.string.gmdss);
        btnQualificationGMDSS.setOnClickListener(new onMyClickListener(getApplicationContext().getResources().getString(R.string.gmdss)));
    }

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

