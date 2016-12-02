package com.koltinjo.cincilator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.koltinjo.cincilator.views.AutoResizeTextView;

public class FragmentDisplay extends Fragment implements Contract.PublishToView {

    private Contract.ForwardDisplayInteractionToPresenter forwardDisplay;

    @BindView(R.id.fragment_display_textview)
    AutoResizeTextView fragmentDisplayTextView;

    // Required empty public constructor.
    public FragmentDisplay() {

    }

    // Return new instance of this fragment.
    public static FragmentDisplay newInstance() {
        return new FragmentDisplay();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fragment_display_imagebutton_delete)
    public void onClickDeleteShort(View view) {
        forwardDisplay.onClickDeleteShort();
    }

    @OnLongClick(R.id.fragment_display_imagebutton_delete)
    public boolean onClickDeleteLong(View view) {
        forwardDisplay.onClickDeleteLong();
        return true;
    }

    // Interface methods.
    @Override
    public void showResult(String result) {
        fragmentDisplayTextView.setText(result);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    // Setter.
    public void setPresenter(Contract.ForwardDisplayInteractionToPresenter forwardDisplay) {
        this.forwardDisplay = forwardDisplay;
    }

}