package com.hieu.prm.logrecordproject.features.user.login.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.model.UserCache;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.button_next)
    Button btnLogin;
    @BindView(R.id.edittext_username)
    TextInputEditText edtUsername;
    @BindView(R.id.edittext_password)
    TextInputEditText edtPassword;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtUsername.getText().toString();
                String password = edtPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    edtUsername.setError("Email is required");
                    edtUsername.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtUsername.setError("Enter a value email");
                    edtUsername.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    edtPassword.setError("Password required");
                    edtPassword.requestFocus();
                    return;
                }

                if (password.length() < 4) {
                    edtPassword.setError("Password should be at least 4 characters long");
                    edtPassword.requestFocus();
                    return;
                }

                Call<UserCache> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .userLogin(email, password);

                call.enqueue(new Callback<UserCache>() {
                    @Override
                    public void onResponse(Call<UserCache> call, Response<UserCache> response) {
                        Toast.makeText(getContext(), "alo" + response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserCache> call, Throwable t) {
                        Toast.makeText(getContext(), "nope" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }
}
