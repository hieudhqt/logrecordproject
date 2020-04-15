package com.hieu.prm.logrecordproject.repository;

import com.hieu.prm.logrecordproject.response.LoginResponse;
import com.hieu.prm.logrecordproject.utils.CallBackData;

public interface AccountRepository {

    void getLoginResponse(String email, String password, CallBackData<LoginResponse> callBackData);

}
