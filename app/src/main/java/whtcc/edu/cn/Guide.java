package whtcc.edu.cn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.cnblogs.com/changchou/p/6209687.html
 * https://www.cnblogs.com/rwxwsblog/p/4913737.html
 * Android引导页面
 * */

public class Guide extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    // 引导页图片资源
    private static final int[] pics = {R.layout.guid_view1,
            R.layout.guid_view2, R.layout.guid_view3, R.layout.guid_view4};
    private ViewPager viewPager;
    private viewPageAdapter adapter;//适配器
    //private List<View> views;//viewpager里面的视图
    private ImageView[] dots;//底部的小点图片
    private int[] ids = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4};//viewpager里面视图的ID
    private Button btnStart;//进入主页的按钮
    //记录当前选中位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initViews();//初始化
        initDots();
    }


    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);//取得当前布局
        List<View> views = new ArrayList<>();
        // 初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            if (i == pics.length - 1) {
                btnStart = (Button) view.findViewById(R.id.enter);//获取到最后一页的进入按钮
                btnStart.setTag("enter");
                btnStart.setOnClickListener(this);
            }
            views.add(view);
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new viewPageAdapter(views, this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    /*
     * 设置点
     * */
    private void initDots() {
        dots = new ImageView[pics.length];
        for (int i = 0; i < pics.length; i++) {
            dots[i] = (ImageView) findViewById(ids[i]);
            dots[i].setEnabled(false);//设置成灰色
            dots[i].setTag(i);/// 设置位置tag，方便取出与当前位置对应
            dots[i].setOnClickListener(this);
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(true);//设置为白色，即选中状态
    }

    //设置当前view
    private void setCurrentView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        viewPager.setCurrentItem(position);
    }

    //设置当前指示点
    private void setCurrentDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
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

    // position==0的时辰默示什么都没做,position ==1的时辰默示正在滑动，position==2的时辰默示滑动完毕了。
    @Override
    public void onPageScrollStateChanged(int position) {
        for (int i = 0; i < ids.length; i++) {
            if (position == i) {
                dots[i].setImageResource(R.drawable.dotable);
            } else {
                dots[i].setImageResource(R.drawable.dot);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {//进入的按钮点击事件
            Intent intent = new Intent(Guide.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        int position = (Integer) v.getTag();
        setCurrentView(position);
        setCurrentDot(position);
    }
}