package whtcc.edu.cn.define_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import whtcc.edu.cn.R;

public class Btn_qualification extends LinearLayout {

    private ImageView iv_positionicon;
    private TextView tv_position;

    public Btn_qualification(Context context) {
        this(context, null);
    }

    public Btn_qualification(Context context, AttributeSet attrs) {

        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.btn_qualification, this, true);
        iv_positionicon = findViewById(R.id.iv_positionicon);
        tv_position = findViewById(R.id.tv_position);

    }

    public void setImageViewResource(int resid) {
        iv_positionicon.setImageResource(resid);
    }

    public void setTextViewText(int resid) {
        tv_position.setText(resid);
    }
}
