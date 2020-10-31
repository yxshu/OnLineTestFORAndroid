package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.cnblogs.com/changchou/p/6209687.html
 * https://www.cnblogs.com/rwxwsblog/p/4913737.html
 * Android引导页面
 * */

public class Guide extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    // 引导页图片资源
    private static final int[] pics = {R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4};
    private ViewPager viewPager;
    private viewPageAdapter adapter;//适配器
    //记录当前选中位置
    LinearLayout point_group;
    private Button btnStart;//进入主页的按钮*/
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        point_group = (LinearLayout) findViewById(R.id.point_group);
        initViews();//初始化
    }


    private void initViews() {
        List<ImageView> imageViews = new ArrayList<>();
        for (int i : pics) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(i);
            imageViews.add(iv);
            if (i == R.drawable.pic4) {
                iv.setOnClickListener(this::onClick);
            }
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 15);
            params.rightMargin = 20;
            params.bottomMargin = 10;
            point.setLayoutParams(params);
            if (i == R.drawable.pic1) {
                point.setBackgroundResource(R.drawable.point_bg_focus);
                point.setEnabled(true);
            } else {
                point.setBackgroundResource(R.drawable.poing_bg);
                point.setEnabled(false);
            }
            point_group.addView(point);
        }
        adapter = new viewPageAdapter(imageViews, this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    // position :当前页面，及你点击滑动的页面
    // positionOffset:当前页面偏移的百分比
    // positionOffsetPixels:当前页面偏移的像素位置
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //// 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {

    }

    // state==0的时默示什么都没做,state ==1的时默示正在滑动，state==2的时默示滑动完毕了。
    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                currentIndex = viewPager.getCurrentItem();
                for (int i = 0; i < pics.length; i++) {
                    if (i == currentIndex) {
                        point_group.getChildAt(i).setBackgroundResource(R.drawable.point_bg_focus);
                        point_group.getChildAt(i).setEnabled(true);
                    } else {
                        point_group.getChildAt(i).setBackgroundResource(R.drawable.poing_bg);
                        point_group.getChildAt(i).setEnabled(false);
                    }
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Guide.this, MainActivity.class);
        startActivity(intent);
        finish();
        return;
    }
}