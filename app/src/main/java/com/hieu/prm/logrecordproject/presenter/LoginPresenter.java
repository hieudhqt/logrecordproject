package com.hieu.prm.logrecordproject.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.hieu.prm.logrecordproject.repository.AccountRepository;
import com.hieu.prm.logrecordproject.repository.AccountRepositoryImpl;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.view.LoginView;

public class LoginPresenter {

    private Context mContext;

    private LoginView loginView;

    private AccountRepository accountRepository;

    public LoginPresenter(Context mContext, LoginView loginView) {
        this.mContext = mContext;
        this.loginView = loginView;
        accountRepository = new AccountRepositoryImpl();
    }

    public void login(String email, String password) {
        accountRepository.getLoginResponse(email, password, new CallBackData<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse type) {
                SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getPackageName(), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("TOKEN", type.getToken());
                editor.commit();

                loginView.onLoginSuccess();
            }

            @Override
            public void onFailed(String message) {
                loginView.onLoginFail(message);
            }
        });
    }
}
