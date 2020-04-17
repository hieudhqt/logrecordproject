package com.hieu.prm.logrecordproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;

public class SplashActivity extends AppCompatActivity {

    Animation rotateAnimation;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgView = findViewById(R.id.loading_icon);
        rotateAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isLogin = SharedPreferencesUtils.getBoolean(SplashActivity.this, SharedPreferencesUtils.IS_LOGIN);
                if (isLogin) {
                    Intent intent = new Intent(SplashActivity.this, MainNavigationActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);

    }

    private void rotateAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imgView.startAnimation(rotateAnimation);
    }


}
