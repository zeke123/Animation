package com.zhoujian.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.start)
    Button mStart;
    @InjectView(R.id.img)
    ImageView mImg;
    @InjectView(R.id.start_one)
    Button mStartOne;
    @InjectView(R.id.start_two)
    Button mStartTwo;
    private Animation mAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        clickEvent();
    }

    private void clickEvent() {

        //透明度动画
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha_animation);
                //mImg.startAnimation(mAnimation);

                //创建动画
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                //动画持续时间
                alphaAnimation.setDuration(5000);
                //动画停留在结束的位置
                alphaAnimation.setFillAfter(true);
                //开启动画
                mImg.startAnimation(alphaAnimation);
            }
        });


        //旋转动画
        mStartOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //利用资源文件加载动画
                //mAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_animation);
                //mImg.startAnimation(mAnimation);

                //在代码中使用动画
                RotateAnimation animation = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                //不停顿
                animation.setInterpolator(new LinearInterpolator());
                //重复次数
                animation.setRepeatCount(0);
                animation.setFillAfter(true);
                animation.setDuration(2000);
                //开启动画
                mImg.startAnimation(animation);
            }
        });

        //缩放动画
        mStartTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //mAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation);
                //mImg.startAnimation(mAnimation);


                ScaleAnimation animation = new ScaleAnimation(1,2,1,2,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                //不停顿
                animation.setInterpolator(new LinearInterpolator());
                //重复次数
                animation.setRepeatCount(0);
                animation.setFillAfter(true);
                animation.setDuration(2000);
                //开启动画
                mImg.startAnimation(animation);

            }
        });
    }
}
