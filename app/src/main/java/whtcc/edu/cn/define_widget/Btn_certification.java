package whtcc.edu.cn.define_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;



import whtcc.edu.cn.R;

//https://www.cnblogs.com/freeliver54/archive/2012/08/10/2631217.html
public class Btn_certification extends LinearLayout {
    private ImageView iv_icon;
    private TextView tv_code;
    private TextView tv_descrip;

    public Btn_certification(Context context) {
        this(context, null);
    }

    public Btn_certification(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        导入布局
        LayoutInflater.from(context).inflate(R.layout.btn_certification, this, true);
        iv_icon = findViewById(R.id.iv_icon);
        tv_code = findViewById(R.id.tv_code);
        tv_descrip = findViewById(R.id.tv_descrip);
    }

    //        设置图片资源
    public void setImageViewResource(int iconId) {
        iv_icon.setImageResource(iconId);
    }

    //设置代码 第一行灰色字体
    public void setTextViewCode(String code) {
        tv_code.setText(code);
    }

    //设置说明 第二行黑色字体
    public void setTextViewDescrip(String descrip) {
        tv_descrip.setText(descrip);
    }
}
