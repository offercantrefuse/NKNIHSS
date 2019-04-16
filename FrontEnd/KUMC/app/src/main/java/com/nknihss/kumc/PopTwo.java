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

public class PopTwo extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_two);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "2. Best Gaze:\nOnly horizontal eye movements will be tested. Voluntary or reflexive (oculocephalic) eye movements will be scored, but caloric testing is not done. \nIf the patient has a conjugate deviation of the eyes that can be overcome by voluntary or reflexive activity, the score will be 1. \nIf a patient has an isolated peripheral nerve paresis (CN III, IV, or VI), score a 1. \nGaze is testable in all aphasic patients. Patients with ocular trauma, bandages, pre-existing blindness, or other disorder of visual acuity or fields should be tested with reflexive movements, and a choice made by the investigator. \nEstablishing eye contact and then moving about the patient from side to side will occasionally clarify the presence of a partial gaze palsy.\n";

        SpannableString ss= new SpannableString(text);

        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.BLUE);

        ss.setSpan(fcsblue, 162,382, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
}
