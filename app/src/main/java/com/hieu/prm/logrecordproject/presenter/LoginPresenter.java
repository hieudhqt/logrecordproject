package com.hieu.prm.logrecordproject.presenter;

import android.content.Context;

import com.hieu.prm.logrecordproject.repository.AccountRepository;
import com.hieu.prm.logrecordproject.repository.AccountRepositoryImpl;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;
import com.hieu.prm.logrecordproject.view.LoginView;

import java.util.List;

public class LoginPresenter {

    private Context mContext;

    private LoginView loginView;

    private AccountRepository accountRepository;

    public LoginPresenter(Context mContext, LoginView loginView) {
        this.mContext = mContext;
        this.loginView = loginView;
        accountRepository = new AccountRepositoryImpl(mContext);
    }

    public void login(String email, String password) {
        accountRepository.getLoginResponse(email, password, new CallBackData<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse type) {
                SharedPreferencesUtils.saveString(mContext, SharedPreferencesUtils.ACCESS_TOKEN, type.getToken());
                SharedPreferencesUtils.saveBoolean(mContext, SharedPreferencesUtils.IS_LOGIN, true);

                loginView.onLoginSuccess(type);
            }

            @Override
            public void onFailed(String message) {
                loginView.onLoginFail(message);
            }
        });
    }

    public void getAllAccounts() {
        accountRepository.getAccountResponse(new CallBackData<List<AccountResponse>>() {
            @Override
            public void onSuccess(List<AccountResponse> type) {
                loginView.onGetAccountsSuccess(type);
            }

            @Override
            public void onFailed(String message) {
                loginView.onGetAccountsFail(message);
            }
        });
    }
}
