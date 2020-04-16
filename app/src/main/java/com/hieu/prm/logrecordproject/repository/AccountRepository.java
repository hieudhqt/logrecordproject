package com.hieu.prm.logrecordproject.repository;

import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;

import java.util.List;

public interface AccountRepository {

    void getLoginResponse(String email, String password, CallBackData<LoginResponse> callBackData);

    void getAccountResponse(CallBackData<List<AccountResponse>> callBackData);

}
