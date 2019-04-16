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

public class PopEight extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_eight);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "8.Sensory:\nSensation or grimace to pinprick when tested, or withdrawal from noxious stimulus in the obtunded or aphasic patient. \nOnly sensory loss attributed to stroke is scored as abnormal and the examiner should test as many body areas [arms (not hands), legs, trunk, face] as needed to accurately check for hemisensory loss. \nA score of 2, “severe or total sensory loss,” should only be given when a severe or total loss of sensation can be clearly demonstrated. \nStuporous and aphasic patients will, therefore, probably score 1 or 0. \nThe patient with brainstem stroke who has bilateral loss of sensation is scored 2. \nIf the patient does not respond and is quadriplegic, score 2. Patients in a coma (item 1a=3) are automatically given a 2 on this item.\n";

        SpannableString ss= new SpannableString(text);

        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.BLUE);

        ss.setSpan(fcsblue, 540,686, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
}
