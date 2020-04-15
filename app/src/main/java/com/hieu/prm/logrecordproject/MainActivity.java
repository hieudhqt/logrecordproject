package com.hieu.prm.logrecordproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.hieu.prm.logrecordproject.features.user.login.view.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }

        edtUsername = findViewById(R.id.edittext_username);
        edtPassword = findViewById(R.id.edittext_password);

    }
}
