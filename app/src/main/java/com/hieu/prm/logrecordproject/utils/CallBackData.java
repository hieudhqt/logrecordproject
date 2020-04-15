package com.hieu.prm.logrecordproject.utils;

public interface CallBackData<T> {

    void onSuccess(T type);

    void onFailed(String message);

}
