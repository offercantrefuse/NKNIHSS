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

public class PopNine extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_nine);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "9.Best Language:\nA great deal of information about comprehension will be obtained during the preceding sections of the examination. \nFor this scale item, the patient is asked to describe what is happening in the attached picture, to name the items on the attached naming sheet, and to read from the attached list of sentences. \nComprehension is judged from responses here, as well as to all of the commands in the preceding general neurological exam. \nIf visual loss interferes with the tests, ask the patient to identify objects placed in the hand, repeat, and produce speech. \nThe intubated patient should be asked to write. \nThe patient in a coma (item 1a=3) will automatically score 3 on this item. \nThe examiner must choose a score for the patient with stupor or limited cooperation, but a score of 3 should be used only if the patient is mute and follows no one-step commands.\n";

        SpannableString ss= new SpannableString(text);

        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.BLUE);
        ForegroundColorSpan fcsblue2 = new ForegroundColorSpan(Color.BLUE);

        ss.setSpan(fcsblue, 628,704, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsblue2, 792,882, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
    }
}
