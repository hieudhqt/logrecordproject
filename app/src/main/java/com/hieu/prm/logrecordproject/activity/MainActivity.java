package com.hieu.prm.logrecordproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.fragment.LoginFragment;

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
