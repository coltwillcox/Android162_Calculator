package com.koltinjo.android162_calculator;

/**
 * Created by colt on 30.11.2016.
 */

// Can also be class, makes no difference.
public interface Contract {

    // View handles these methods.
    interface PublishToView {
        void showResult(String result);
        void showToast(String message);
    }

    // Passes click events from View (FragmentInput) to the Presenter.
    interface ForwardInputInteractionToPresenter {
        void onClickNumber(int number);
        void onClickOperator(String operator);
        void onClickDecimal();
        void onClickEvaluate();
    }

    // Passes click events from View (FragmentDisplay) to the Presenter.
    interface ForwardDisplayInteractionToPresenter {
        void onClickDeleteShort();
        void onClickDeleteLong();
    }

}