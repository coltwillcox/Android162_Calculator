package com.koltinjo.android162_calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentInput extends Fragment {

    // Required empty public constructor.
    public FragmentInput() {

    }

    // Return new instance of this fragment.
    public static FragmentInput newInstance() {
        return new FragmentInput();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        // ButterKnife is so fuckin' cool! :D
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.fragment_input_button_0, R.id.fragment_input_button_1, R.id.fragment_input_button_2,
            R.id.fragment_input_button_3, R.id.fragment_input_button_4, R.id.fragment_input_button_5,
            R.id.fragment_input_button_6, R.id.fragment_input_button_7, R.id.fragment_input_button_8,
            R.id.fragment_input_button_9})
    public void onNumberClick(Button button) {

    }

    @OnClick({R.id.fragment_input_button_add, R.id.fragment_input_button_subtract, R.id.fragment_input_button_multiply,
            R.id.fragment_input_button_divide})
    public void onOperatorClick(Button button) {

    }

    @OnClick(R.id.fragment_input_button_decimal)
    public void onDecimalClick(Button button) {

    }

    @OnClick(R.id.fragment_input_button_evaluate)
    public void onEvaluateClick(Button button) {

    }

}