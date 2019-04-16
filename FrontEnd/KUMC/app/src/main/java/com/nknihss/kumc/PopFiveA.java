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

public class PopFiveA extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_five_a);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "5.Motor Arm:\nThe limb is placed in the appropriate position: extend the arms (palms down) 90 degrees (if sitting) or 45 degrees (if supine). \nDrift is scored if the arm falls before 10 seconds. \nThe aphasic patient is encouraged using urgency in the voice and pantomime, but not noxious stimulation. \nEach limb is tested in turn, beginning with the non-paretic arm. \nOnly in the case of amputation or joint fusion at the shoulder, the examiner should record the score as untestable (UN) and clearly write the explanation for this choice.\n";

        SpannableString ss= new SpannableString(text);

        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.BLUE);

        ss.setSpan(fcsblue, 367,487, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
}
