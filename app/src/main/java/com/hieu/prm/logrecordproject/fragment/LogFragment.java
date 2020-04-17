package com.hieu.prm.logrecordproject.fragment;

import android.os.Bundle;
import android.util.Log;
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

import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.presenter.LogPresenter;
import com.hieu.prm.logrecordproject.response.LogResponse;
import com.hieu.prm.logrecordproject.view.LogView;

import java.util.List;

public class LogFragment extends Fragment implements LogView {

    TableLayout tableLayout;

    View view;

    DialogFragment dialogFragment;

    private LogPresenter logPresenter;

    public LogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_log, container, false);

        tableLayout = view.findViewById(R.id.table_layout_log);

        logPresenter = new LogPresenter(view.getContext(), this);

        logPresenter.getLogs();

        return view;
    }

    @Override
    public void onGetLogsSuccess(final List<LogResponse> logResponseList) {
        for (int i = 0; i < logResponseList.size() && i < 10; i++) {
            final LogResponse logResponse = logResponseList.get(i);

            TableRow row = new TableRow(view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
            row.setLayoutParams(lp);

            TextView textView1 = new TextView(view.getContext());
            textView1.setText(logResponse.getAppCode()+"");
            textView1.setTextSize(20.0f);
            textView1.setGravity(Gravity.CENTER);
            textView1.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView1);

            TextView textView2 = new TextView(view.getContext());
            textView2.setText(logResponse.getLineCode()+"");
            textView2.setTextSize(20.0f);
            textView2.setGravity(Gravity.CENTER);
            textView2.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView2);

            TextView textView3 = new TextView(view.getContext());
            textView3.setText(logResponse.getProjectName());
            textView3.setGravity(Gravity.CENTER);
            textView3.setTextSize(20.0f);
            textView3.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView3);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFragment = new InformationDetailFragment(logResponse.getLogInfo());
                    dialogFragment.show(getActivity().getSupportFragmentManager(), "logInfo");
                }
            });

            tableLayout.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void onGetLogsFail(String message) {
        Toast.makeText(view.getContext(), "Get All Logs Fail", Toast.LENGTH_LONG).show();
        Log.d("APP_LOG_ERROR", message);
    }
}
