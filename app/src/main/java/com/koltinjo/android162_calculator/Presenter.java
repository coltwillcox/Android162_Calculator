package com.koltinjo.android162_calculator;

/**
 * Created by colt on 30.11.2016.
 */

public class Presenter implements Contract.ForwardInputInteractionToPresenter, Contract.ForwardDisplayInteractionToPresenter {

    // An object of FragmentDisplay.
    private Contract.PublishToView publishToView;

    // Constructor.
    public Presenter(Contract.PublishToView publishToView) {
        this.publishToView = publishToView;
    }

    // Interfaces methods.
    @Override
    public void onClickNumber(int number) {

    }

    @Override
    public void onClickOperator(String operator) {

    }

    @Override
    public void onClickDecimal() {

    }

    @Override
    public void onClickEvaluate() {

    }

    @Override
    public void onClickDeleteShort() {

    }

    @Override
    public void onClickDeleteLong() {

    }

}