package com.hieu.prm.logrecordproject.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_name)
    TextView mTextViewName;
    @BindView(R.id.profile_email)
    TextView mTextViewEmail;
    @BindView(R.id.profile_address)
    TextView mTextViewAddress;
    @BindView(R.id.profile_phone)
    TextView mTextViewPhone;


    View view;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, view);

        String json = SharedPreferencesUtils.getString(view.getContext(), SharedPreferencesUtils.ACCOUNT);
        Gson gson = new Gson();
        AccountResponse accountResponse = gson.fromJson(json, AccountResponse.class);
        mTextViewName.setText(accountResponse.getName());
        mTextViewEmail.setText(accountResponse.getEmail());
        mTextViewAddress.setText(accountResponse.getAddress());
        mTextViewPhone.setText(accountResponse.getPhone());
        return view;
    }
}
