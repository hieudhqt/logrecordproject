package com.hieu.prm.logrecordproject.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.presenter.LoginPresenter;
import com.hieu.prm.logrecordproject.repository.AccountRepository;
import com.hieu.prm.logrecordproject.repository.AccountRepositoryImpl;
import com.hieu.prm.logrecordproject.request.LoginRequest;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.RetrofitClient;
import com.hieu.prm.logrecordproject.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginView {

    @BindView(R.id.button_next)
    MaterialButton btnLogin;
    @BindView(R.id.edittext_username)
    TextInputEditText edtUsername;
    @BindView(R.id.edittext_password)
    TextInputEditText edtPassword;

    private LoginPresenter loginPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(view.getContext(), this);

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

                loginPresenter.login(email, password);

            }
        });
        return view;
    }

    @Override
    public void onLoginSuccess() {
        SharedPreferences sharedPreferences = getActivity().getApplicationContext().getSharedPreferences(getActivity().getApplicationContext().getPackageName(), Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("TOKEN", "");
    }

    @Override
    public void onLoginFail(String message) {

    }
}
