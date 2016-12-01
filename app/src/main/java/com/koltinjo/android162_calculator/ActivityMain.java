package com.koltinjo.android162_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// TODO App name.
// TODO Icon.
// TODO Options.
// TODO Options: Commas.
// TODO Options: Vibrations.
// TODO Options: Sounds.
// TODO Options: Decimal size.
// TODO Save currentExpression on config change.
// TODO Multiple "=" presses.
// TODO Sciemtific look? Options?

// https://youtu.be/pjTAF53qRA4?list=PLEVlop6sMHCp3Wp0mqT2-OxHwVdAod1uy
public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentInput fragmentInput = (FragmentInput) getSupportFragmentManager().findFragmentById(R.id.activity_main_fragment_input);
        FragmentDisplay fragmentDisplay = (FragmentDisplay) getSupportFragmentManager().findFragmentById(R.id.activity_main_fragment_display);

        Presenter presenter = new Presenter(fragmentDisplay);

        fragmentDisplay.setPresenter(presenter);
        fragmentInput.setPresenter(presenter);
    }

}