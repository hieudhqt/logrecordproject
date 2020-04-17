package com.hieu.prm.logrecordproject.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hieu.prm.logrecordproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationDetailFragment extends DialogFragment {

    private String infoDetail;

    public InformationDetailFragment() {
        // Required empty public constructor
    }

    public InformationDetailFragment(String infoDetail) {
        this.infoDetail = infoDetail;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setMessage(infoDetail);
        alertDialog.setIcon(R.drawable.react_logo);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("OK", null);
        return alertDialog.create();
    }
}
