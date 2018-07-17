package com.elle.campaigntracker.util;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Holds binding adapters for view
 */
public class BindingAdapters {

    //region int to text
    /**
     * Watches for text entry
     */
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

    /**
     * Converts an int or float to String for TextView
     */
    @BindingAdapter("intToText")
    public static void setIntToText(TextView textView, int number){
        textView.setText(String.valueOf(number));
    }
    @BindingAdapter("intToText")
    public static void setIntToText(TextView textView, float number){
        textView.setText(String.valueOf(number));
    }

    /**
     * Converts EditText into an int
     */
    @InverseBindingAdapter(attribute = "intToText")
    public static int getNumber(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }
    //endregion

    //region float to text
    @BindingAdapter("floatToText")
    public static void setFloatToText(TextView textView, float number){
        textView.setText(String.valueOf(number));
    }

    @InverseBindingAdapter(attribute = "floatToText")
    public static float getFloat(EditText editText){
        return Float.parseFloat(editText.getText().toString());
    }
    /**
     * Watches for text entry
     */
    @BindingAdapter(value = "floatToTextAttrChanged")
    public static void setFloatListener(EditText editText, final InverseBindingListener listener){
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
    //endregion

    /**
     * Enables or Disables Image
     */
    @BindingAdapter("enableDisable")
    public static void enableDisable(ImageView view, boolean enabled){
        view.setEnabled(enabled);
    }
}
