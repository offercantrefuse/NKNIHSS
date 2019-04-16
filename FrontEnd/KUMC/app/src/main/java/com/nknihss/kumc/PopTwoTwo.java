package com.nknihss.kumc;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopTwoTwo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_two_two);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "To find nystagmus, the patient should have upright position. If impossible, use any assistance (ex. raising the upper bed) to make the patient’s head upright.";
        textView.setText(text);
    }
}
