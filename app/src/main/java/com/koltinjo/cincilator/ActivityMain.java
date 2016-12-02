package com.koltinjo.cincilator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

// TODOK App name.
// TODOK Icon.
// TODOK Save currentExpression on config change. http://stackoverflow.com/questions/3915952/how-to-save-state-during-orientation-change-in-android-if-the-state-is-made-of-m
// TODO Options.
// TODO Options: Commas.
// TODO Options: Vibrations.
// TODO Options: Sounds.
// TODO Options: Decimal size.
// TODO TextView autosize.
// TODO Multiple "=" presses.
// TODO Scientific look? Options?
// TODO Move fragments from Main. Set presenter inside fragments.

// https://youtu.be/pjTAF53qRA4?list=PLEVlop6sMHCp3Wp0mqT2-OxHwVdAod1uy
public class ActivityMain extends AppCompatActivity {

    private ViewPager activityMainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentDisplay fragmentDisplay = (FragmentDisplay) getSupportFragmentManager().findFragmentById(R.id.activity_main_fragment_display);
        Presenter presenter = new Presenter(fragmentDisplay);
        fragmentDisplay.setPresenter(presenter);

        activityMainViewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        activityMainViewPager.setAdapter(new AdapterPager(getSupportFragmentManager(), presenter));
    }

}