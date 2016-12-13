package com.zhoujian.animation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhoujian on 2016/12/12.
 */

public class SecondActivity extends Activity {

    @InjectView(R.id.bt_start)
    Button mBtStart;
    @InjectView(R.id.bt_starto)
    Button mBtStarto;
    private AnimationDrawable mAnimationDrawable;
    @InjectView(R.id.loading)
    ImageView mLodding;
    @InjectView(R.id.start)
    Button mStart;
    @InjectView(R.id.stop)
    Button mStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.inject(this);
        mAnimationDrawable = (AnimationDrawable) mLodding.getDrawable();
        clickEvent();

    }

    private void clickEvent() {
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnimationDrawable.start();
            }
        });
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnimationDrawable.stop();
            }
        });
        mBtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, ThiredActivity.class));
                overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
            }
        });



        mBtStarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, FouthActivity.class));
                overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
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
