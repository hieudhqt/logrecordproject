package com.hieu.prm.logrecordproject.view;

import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.response.LoginResponse;

import java.util.List;

public interface LoginView {

    void onLoginSuccess(LoginResponse loginResponse);

    void onLoginFail(String message);

    void onGetAccountsSuccess(List<AccountResponse> accountResponseList);

    void onGetAccountsFail(String message);

}
