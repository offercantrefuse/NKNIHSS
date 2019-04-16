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

public class PopThree extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_three);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "3. Visual:\nVisual fields (upper and lower quadrants) are tested by confrontation, using finger counting or visual threat, as appropriate. \nPatients may be encouraged, but if they look at the side of the moving fingers appropriately, this can be scored as normal. If there is unilateral blindness or enucleation, visual fields in the remaining eye are scored. \nScore 1 only if a clear-cut asymmetry, including quadrantanopia, is found. \nIf patient is blind from any cause, score 3. \nDouble simultaneous stimulation is performed at this point. \nIf there is extinction, patient receives a 1, and the results are used to respond to item 11.\n";

        SpannableString ss= new SpannableString(text);

        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.BLUE);
        ForegroundColorSpan fcsblue2 = new ForegroundColorSpan(Color.BLUE);
        ss.setSpan(fcsblue, 360,482, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsblue2, 543,636, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
}
