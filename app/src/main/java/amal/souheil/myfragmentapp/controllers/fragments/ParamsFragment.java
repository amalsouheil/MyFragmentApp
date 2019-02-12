package amal.souheil.myfragmentapp.controllers.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import amal.souheil.myfragmentapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParamsFragment extends BaseFragment {

    @BindView(R.id.fragment_params_text_view) TextView paramTextView;


    public ParamsFragment() {
        // Required empty public constructor
    }

    @Override
    protected BaseFragment newInstance() {
        return null;
    }

    @Override
    protected int getFragmentLayout() {
        return 0;
    }

    @Override
    protected void configureDesign() {

    }

    @Override
    protected void updateDesign() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result=inflater.inflate(R.layout.fragment_params, container, false);
        ButterKnife.bind(this, result);

        return result;


    }





}
