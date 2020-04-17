package com.hieu.prm.logrecordproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.activity.MainNavigationActivity;
import com.hieu.prm.logrecordproject.presenter.LoginPresenter;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;
import com.hieu.prm.logrecordproject.view.LoginView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

    private Unbinder unbinder;

    View view;

    LoginResponse loginResponse;

    private LoginPresenter loginPresenter;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(view.getContext(), this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), MainNavigationActivity.class);
                startActivity(intent);
            }
        });

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
    public void onLoginSuccess(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
        loginPresenter.getAllAccounts();
    }

    @Override
    public void onLoginFail(String message) {
        Toast.makeText(view.getContext(), "Incorrect username/password", Toast.LENGTH_LONG).show();
        Log.d("LOGIN_FAIL", message);
    }

    @Override
    public void onGetAccountsSuccess(List<AccountResponse> accountResponseList) {
        int id = this.loginResponse.getId();
        AccountResponse foundAccount = null;
        for (AccountResponse accountResponse : accountResponseList) {
            if (accountResponse.getId() == id) {
                foundAccount = accountResponse;
            }
        }

        if (foundAccount != null) {
            if (foundAccount.getRole() != 3 && foundAccount.getRole() != 4) {
                Gson gson = new Gson();
                String jsonAccount = gson.toJson(foundAccount);
                String jsonAccountList = gson.toJson(accountResponseList);
                SharedPreferencesUtils.saveString(view.getContext(), SharedPreferencesUtils.ACCOUNT, jsonAccount);
                SharedPreferencesUtils.saveString(view.getContext(), SharedPreferencesUtils.ACCOUNT_LIST, jsonAccountList);
                Intent intent = new Intent(view.getContext(), MainNavigationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(view.getContext(), "Your account is not authorized", Toast.LENGTH_LONG).show();
                Log.d("UNAUTHORIZED_ERROR", foundAccount.getEmail() + " forbidden");
            }
        }
    }

    @Override
    public void onGetAccountsFail(String message) {
        Toast.makeText(view.getContext(), "Get User Information Fail", Toast.LENGTH_LONG).show();
        Log.d("GET_ACCOUNT_ERROR", message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
