package com.koltinjo.android162_calculator;

/**
 * Created by colt on 30.11.2016.
 */

public class Presenter implements Contract.ForwardInputInteractionToPresenter,
        Contract.ForwardDisplayInteractionToPresenter,
        Calculation.CalculationResult {

    // An object of FragmentDisplay.
    private Contract.PublishToView publishToView;
    private Calculation calculation;

    // Constructor.
    public Presenter(Contract.PublishToView publishToView) {
        this.publishToView = publishToView;
        calculation = new Calculation();
        calculation.setCalculationResultListener(this);
    }

    // Interfaces methods.
    @Override
    public void onClickNumber(int number) {
        calculation.appendNumber(Integer.toString(number));
    }

    @Override
    public void onClickOperator(String operator) {
        calculation.appendOperator(operator);
    }

    @Override
    public void onClickDecimal() {
        calculation.appendDecimal();
    }

    @Override
    public void onClickEvaluate() {
        calculation.performEvaluate();
    }

    @Override
    public void onClickDeleteShort() {
        calculation.deleteCharacter();
    }

    @Override
    public void onClickDeleteLong() {
        calculation.deleteExpression();
    }

    @Override
    public void onExpressionChange(String result, boolean successful) {
        if (successful) {
            publishToView.showResult(result);
        } else {
            publishToView.showToast(result);
        }
    }

}