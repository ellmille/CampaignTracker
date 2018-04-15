package com.elle.campaigntracker.view;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Binding and inverse binding adapters
 */

public class BindingAdapters {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM.dd - yyyy", Locale.getDefault());

    @BindingAdapter(value = "intToTextAttrChanged")
    public static void setListener(EditText editText, final InverseBindingListener listener){
        if(listener != null){
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(s.length() > 0){
                        listener.onChange();
                    }
                }
            });
        }
    }

    @BindingAdapter("intString")
    public static void setIntToText(TextView textView, int number){
        textView.setText(String.valueOf(number));
    }

    @BindingAdapter("intToText")
    public static void setIntToText(EditText view, int number){
        if(!String.valueOf(number).equals(view.getText().toString())){
            view.setText(String.valueOf(number));
        }
    }

    @BindingAdapter("longToDate")
    public static void setLongToDate(TextView view, long time){
        Date date = new Date(time);
        view.setText(simpleDateFormat.format(date));
    }

    @InverseBindingAdapter(attribute = "intToText")
    public static int getNumber(EditText view){
        return Integer.parseInt(view.getText().toString());
    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
