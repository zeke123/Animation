package com.zhoujian.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.zhoujian.animation.R.id.img;

/**
 * Created by zhoujian on 2016/12/13.
 * <p>
 * 属性动画：是API11新加入的特性，可以对任意对象的属性进行动画，动画默认时间间隔为300ms
 * 默认帧率为10ms/帧，API11以后才能使用帧动画，如果要兼容以前的版本可以使用开源动画库
 * nineoldandroids
 * ObjectAnimator
 */

public class FouthActivity extends Activity {


    private static final String TAG ="FouthActivity";

    @InjectView(img)
    ImageView mImg;
    @InjectView(R.id.bt_start)
    Button mBtStart;
    @InjectView(R.id.bt_starto)
    Button mBtStarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        ButterKnife.inject(this);
        clickEvent();
    }

    private void clickEvent() {

        mBtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、透明度：alpha
                //2、旋转度数：rotation、rotationX、rotationY
                //3、平移：translationX、translationY
                //4、缩放：scaleX、scaleY


                //透明度动画
                //把mImg的透明度从完全可见到完全不可见，再从不可见到可见，时间3秒
                //ObjectAnimator.ofFloat(mImg,"alpha",1,0,0,1).setDuration(3000).start();


                //旋转动画，绕z轴旋转
                //把mImg 绕z轴旋转，从0度开始到90度，然后在返回0度，动画用时3秒
                // ObjectAnimator.ofFloat(mImg,"rotation",0,90,0).setDuration(3000).start();

                //旋转动画，绕x轴旋转
                //把mImg 绕x轴旋转，从0度开始到90度，然后在返回0度，动画用时3秒
                //ObjectAnimator.ofFloat(mImg,"rotationX",0,90,0).setDuration(3000).start();


                //旋转动画，绕y轴旋转
                //把mImg 绕y轴旋转，从0度开始到90度，然后在返回0度，动画用时3秒
                //ObjectAnimator.ofFloat(mImg,"rotationY",0,90,0).setDuration(3000).start();


                //平移动画
                //把mImg 沿着x轴方向，从原始位置移动100像素，然后从100像素的位置返回原处，动画用时3秒
                //ObjectAnimator.ofFloat(mImg,"translationX",0,100,100,0).setDuration(3000).start();
                //把mImg 沿着y轴方向，从原始位置移动-100像素，然后从-100像素的位置返回原处，动画用时3秒
                //ObjectAnimator.ofFloat(mImg,"translationY",0,-100,-100,0).setDuration(3000).start();


                //缩放动画
                //把mImg 沿着x轴方向，从原始大小，扩大到原来的一倍，然后再返回原始大小，动画用时3秒
                //ObjectAnimator.ofFloat(mImg, "scaleX", 1, 2,2,1).setDuration(3000).start();
                //把mImg 沿着y轴方向，从原始大小，扩大到原来的一倍，然后再返回原始大小，动画用时3秒
                ObjectAnimator.ofFloat(mImg, "scaleY", 1, 2, 2, 1).setDuration(3000).start();


            }
        });



        mBtStarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValueAnimator mValueAnimator =ValueAnimator.ofInt(1,200);
                mValueAnimator.setDuration(2000);
                mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator)
                    {
                        int value = (int)animator.getAnimatedValue();
                        mImg.layout(value,value,value+mImg.getWidth(),value+mImg.getHeight());
                        Log.e(TAG,"value==="+ value);
                    }
                });

                mValueAnimator.start();
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
