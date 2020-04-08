package com.hieu.prm.logrecordproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hieu.prm.logrecordproject.features.user.login.view.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }
    }
}
