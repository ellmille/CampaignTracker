package com.elle.campaigntracker.view;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Binding and inverse binding adapters
 */

public class BindingAdapters {

    @BindingAdapter("intToText")
    public static void setIntToText(EditText view, int number){
        view.setText(String.valueOf(number));
    }

    @InverseBindingAdapter(attribute = "intToText", event = "intToTextAttrChanged")
    public static int getNumber(EditText view){
        return Integer.parseInt(view.getText().toString());
    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
