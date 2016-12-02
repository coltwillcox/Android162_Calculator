package com.koltinjo.cincilator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentInputSci extends Fragment {

    // Instance of Presenter.
    private Contract.ForwardInputInteractionToPresenter forwardInput;

    // Required empty public constructor.
    public FragmentInputSci() {

    }

    // Return new instance of this fragment.
    public static FragmentInputSci newInstance() {
        return new FragmentInputSci();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_sci, container, false);

        // ButterKnife is so fuckin' cool! :D
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.fragment_input_sci_button_sin, R.id.fragment_input_sci_button_cos, R.id.fragment_input_sci_button_tan,
            R.id.fragment_input_sci_button_ln, R.id.fragment_input_sci_button_log, R.id.fragment_input_sci_button_factorial,
            R.id.fragment_input_sci_button_pi, R.id.fragment_input_sci_button_e, R.id.fragment_input_sci_button_power,
            R.id.fragment_input_sci_button_bracket_open, R.id.fragment_input_sci_button_bracker_close, R.id.fragment_input_sci_button_root})
    public void onClickSciOperator(Button button) {
        forwardInput.onClickOperator(button.getText().toString());
    }

    // Setter.
    public void setPresenter(Contract.ForwardInputInteractionToPresenter forwardInput) {
        this.forwardInput = forwardInput;
    }

}