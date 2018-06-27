package com.reportlibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.common.ui.CommonFragment;

public class ReportMainFragment extends CommonFragment {


    public static ReportMainFragment newInstance() {
        return new ReportMainFragment();
    }

    @Override
    protected void initById() {
    }

    @Override
    protected void initCreate(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.report_fragment_main;
    }
}