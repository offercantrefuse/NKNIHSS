package com.nknihss.kumc;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopSevenTwo extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_seven_two);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "Imbalance is scored only if present out of proportion to weakness, that is similar concept to ataxia (item 7). Imbalance is untestable in the patient who is paralyzed or has amputated leg, scored as X.";
        textView.setText(text);
    }
}
