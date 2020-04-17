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
import com.hieu.prm.logrecordproject.presenter.ApplicationPresenter;
import com.hieu.prm.logrecordproject.response.ApplicationResponse;
import com.hieu.prm.logrecordproject.view.ApplicationView;

import java.util.List;

public class ApplicationFragment extends Fragment implements ApplicationView {

    TableLayout tableLayout;

    View view;

    DialogFragment dialogFragment;

    public ApplicationFragment() {
    }

    private ApplicationPresenter applicationPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_application, container, false);

        tableLayout = view.findViewById(R.id.table_layout_application);

        applicationPresenter = new ApplicationPresenter(view.getContext(), this);

        applicationPresenter.getApplications();

        return view;
    }

    @Override
    public void onGetApplicationsSuccess(final List<ApplicationResponse> applicationResponseList) {
//        final float scale = getContext().getResources().getDisplayMetrics().density;
//        int pixels = (int) (50 * scale + 0.5f);
        for (int i = 0; i < applicationResponseList.size() && i < 10; i++) {
            final ApplicationResponse applicationResponse = applicationResponseList.get(i);

            TableRow row = new TableRow(view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
            row.setLayoutParams(lp);

            TextView textView1 = new TextView(view.getContext());
            textView1.setText(applicationResponse.getName()+"");
            textView1.setTextSize(20.0f);
            textView1.setGravity(Gravity.CENTER);
            textView1.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView1);

            TextView textView2 = new TextView(view.getContext());
            textView2.setText(applicationResponse.getCreateTime()+"");
            textView2.setTextSize(20.0f);
            textView2.setGravity(Gravity.CENTER);
            textView2.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView2);

            TextView textView3 = new TextView(view.getContext());
            textView3.setText(applicationResponse.getType());
            textView3.setGravity(Gravity.CENTER);
            textView3.setTextSize(20.0f);
            textView3.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView3);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFragment = new InformationDetailFragment(applicationResponse.getApplicationInfo());
                    dialogFragment.show(getActivity().getSupportFragmentManager(), "applicationInfo");
                }
            });

            tableLayout.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void onGetApplicationsFail(String message) {
        Toast.makeText(view.getContext(), "Get Application Fail", Toast.LENGTH_LONG).show();
        Log.d("APPLICATION_ERROR", message);
    }
}
