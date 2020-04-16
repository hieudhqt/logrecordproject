package com.hieu.prm.logrecordproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hieu.prm.logrecordproject.R;

public class SplashActivity extends AppCompatActivity {

    Animation rotateAnimation;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgView = findViewById(R.id.loading_icon);
        rotateAnimation();

        //Get is login shared prefs
    }

    private void rotateAnimation() {

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imgView.startAnimation(rotateAnimation);
    }


}
