package com.hieu.prm.logrecordproject.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFragment extends Fragment {

    TableLayout tableLayout;

    View view;

    DialogFragment dialogFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_employee, container, false);

        tableLayout = view.findViewById(R.id.table_layout_employee);

        String json = SharedPreferencesUtils.getString(view.getContext(), SharedPreferencesUtils.ACCOUNT_LIST);
        Gson gson = new Gson();
        Type accountResponseType = new TypeToken<ArrayList<AccountResponse>>(){}.getType();
        final List<AccountResponse> accountResponseList = gson.fromJson(json, accountResponseType);

        for (int i = 0; i < accountResponseList.size(); i++) {
            final AccountResponse accountResponse = accountResponseList.get(i);

            if (accountResponse.getRole() == 3 || accountResponse.getRole() == 4) {

                TableRow row = new TableRow(view.getContext());
                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
                row.setLayoutParams(lp);

                TextView textView1 = new TextView(view.getContext());
                textView1.setText(accountResponse.getId() + "");
                textView1.setTextSize(20.0f);
                textView1.setGravity(Gravity.CENTER);
                textView1.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
                row.addView(textView1);

                TextView textView2 = new TextView(view.getContext());
                textView2.setText(accountResponse.getEmail() + "");
                textView2.setTextSize(20.0f);
                textView2.setGravity(Gravity.CENTER);
                textView2.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
                row.addView(textView2);

                TextView textView3 = new TextView(view.getContext());
                textView3.setText(accountResponse.getPhone());
                textView3.setGravity(Gravity.CENTER);
                textView3.setTextSize(20.0f);
                textView3.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
                row.addView(textView3);

                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogFragment = new InformationDetailFragment(accountResponse.getAccountInfo());
                        dialogFragment.show(getActivity().getSupportFragmentManager(), "employeeInfo");
                    }
                });

                tableLayout.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        }

        return view;
    }
}
