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
import com.hieu.prm.logrecordproject.presenter.ApplicationInstancePresenter;
import com.hieu.prm.logrecordproject.response.ApplicationInstanceResponse;
import com.hieu.prm.logrecordproject.view.ApplicationInstanceView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApplicationInstanceFragment extends Fragment implements ApplicationInstanceView {

    @BindView(R.id.tbl_app_instance)
    TableLayout tableAppInstance;

    View view;

    DialogFragment dialogFragment;

    private ApplicationInstancePresenter applicationInstancePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_application_instance, container, false);

        ButterKnife.bind(this, view);

        applicationInstancePresenter = new ApplicationInstancePresenter(view.getContext(), this);

        applicationInstancePresenter.getApplicationInstances();

        return view;
    }

    @Override
    public void onGetApplicationInstancesSuccess(final List<ApplicationInstanceResponse> applicationInstanceResponseList) {
        for (int i = 0; i < applicationInstanceResponseList.size() && i < 10; i++) {
            final ApplicationInstanceResponse applicationInstanceResponse = applicationInstanceResponseList.get(i);

            TableRow row = new TableRow(view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
            row.setLayoutParams(lp);

            TextView textView1 = new TextView(view.getContext());
            textView1.setText(applicationInstanceResponse.getAppCode()+"");
            textView1.setTextSize(20.0f);
            textView1.setGravity(Gravity.CENTER);
            textView1.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView1);

            TextView textView2 = new TextView(view.getContext());
            textView2.setText(applicationInstanceResponse.getName()+"");
            textView2.setTextSize(20.0f);
            textView2.setGravity(Gravity.CENTER);
            textView2.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView2);

            TextView textView3 = new TextView(view.getContext());
            textView3.setText(applicationInstanceResponse.getActive()+"");
            textView3.setGravity(Gravity.CENTER);
            textView3.setTextSize(20.0f);
            textView3.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100, 1.0f));
            row.addView(textView3);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFragment = new InformationDetailFragment(applicationInstanceResponse.getInstanceInfo());
                    dialogFragment.show(getActivity().getSupportFragmentManager(), "applicationInstanceInfo");
                }
            });

            tableAppInstance.addView(row, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void onGetApplicationInstancesFail(String message) {
        Toast.makeText(view.getContext(), "Get Application Fail", Toast.LENGTH_LONG).show();
        Log.d("APPLICATION_ERROR", message);
    }
}
