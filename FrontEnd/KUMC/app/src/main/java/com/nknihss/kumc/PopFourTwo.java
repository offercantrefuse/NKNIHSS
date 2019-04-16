package com.nknihss.kumc;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopFourTwo extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_four_two);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView textView = findViewById(R.id.textView10);
        String text = "Newly detected hoarseness, an abnormal change in voice, was scored when other conditions (such as  viral infection in the upper respiratory infection, smoking, polyps on the vocal cord, vocal cord damage from the insertion of a tube, etc) preventing smooth vocal sounds were excluded. If the patient has severe aphasia, the clarity of voice can be related.";
        textView.setText(text);
    }
}
