package com.nknihss.kumc;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopOneA extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_one_a);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "1a. Level of Consciousness:\n The investigator must choose a response if a full evaluation is prevented by such obstacles as an endotracheal tube, language barrier, orotracheal trauma/bandages.  A 3 is scored only if the patient makes no movement (other than reflexive posturing) in response to noxious stimulation. ";

        SpannableString ss= new SpannableString(text);

        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.BLUE);

        ss.setSpan(fcsblue, 29,193, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
}
