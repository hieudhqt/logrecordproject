package com.hieu.prm.logrecordproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hieu.prm.logrecordproject.R;

import butterknife.BindView;

public class ApplicationInstanceFragment extends Fragment {

    @BindView(R.id.tbl_app_instance)
    TableLayout tableAppInstance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_application_instance, container, false);
    }
}
