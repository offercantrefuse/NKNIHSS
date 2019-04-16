package com.nknihss.kumc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Intent intent = getIntent();
        final String school = intent.getStringExtra("school");
        final String examiner = intent.getStringExtra("examiner");
        final String caseNumber = intent.getStringExtra("caseNumber");
        final String typeChoose = intent.getStringExtra("typeChoose");
        final String sex = intent.getStringExtra("sex");
        final String timeStamp = intent.getStringExtra("timeStamp");
        final int oneA = intent.getIntExtra("oneA", 0);
        final int oneB = intent.getIntExtra("oneB", 0);
        final int oneC = intent.getIntExtra("oneC", 0);
        final int two = intent.getIntExtra("two", 0);
        final int twoOne = intent.getIntExtra("twoOne", 0);
        final int twoTwo = intent.getIntExtra("twoTwo", 0);
        final int twoThree = intent.getIntExtra("twoThree", 0);
        final int three = intent.getIntExtra("three", 0);
        final int four = intent.getIntExtra("four", 0);
        final int fourOne = intent.getIntExtra("fourOne", 0);
        final int fourTwo = intent.getIntExtra("fourTwo", 0);
        final int fiveA = intent.getIntExtra("fiveA", 0);
        final int fiveB = intent.getIntExtra("fiveB", 0);
        final int sixA = intent.getIntExtra("sixA", 0);
        final int sixB = intent.getIntExtra("sixB", 0);
        final int seven = intent.getIntExtra("seven", 0);
        final int sevenTwo = intent.getIntExtra("sevenTwo", 0);
        final int eight = intent.getIntExtra("eight", 0);
        final int nine = intent.getIntExtra("nine", 0);
        final int ten = intent.getIntExtra("ten", 0);
        final int eleven = intent.getIntExtra("eleven", 0);

        final int nihss = oneA + oneB + oneC + two + three + four + fiveA + fiveB + sixA + sixB + seven + eight + nine + ten + eleven;
        final int nknihss = twoOne + twoTwo + twoThree + fourOne + fourTwo + sevenTwo;
        final int total = nihss + nknihss;

        TextView OneA = (TextView)findViewById(R.id.textView4);
        TextView OneB = (TextView)findViewById(R.id.textView6);
        TextView OneC = (TextView)findViewById(R.id.textView8);
        TextView Two = (TextView)findViewById(R.id.textView10);
        TextView TwoOne= (TextView)findViewById(R.id.textView101);
        TextView TwoTwo= (TextView)findViewById(R.id.textView36);
        TextView TwoThree= (TextView)findViewById(R.id.textView103);
        TextView Three= (TextView)findViewById(R.id.textView12);
        TextView Four = (TextView)findViewById(R.id.textView14);
        TextView FourOne= (TextView)findViewById(R.id.textView105);
        TextView FourTwo= (TextView)findViewById(R.id.textView38);
        TextView FiveA = (TextView)findViewById(R.id.textView16);
        TextView FiveB = (TextView)findViewById(R.id.textView18);
        TextView SixA = (TextView)findViewById(R.id.textView20);
        TextView SixB = (TextView)findViewById(R.id.textView22);
        TextView Seven = (TextView)findViewById(R.id.textView24);
        TextView SevenTwo = (TextView)findViewById(R.id.textView40);
        TextView Eight = (TextView)findViewById(R.id.textView26);
        TextView Nine = (TextView)findViewById(R.id.textView28);
        TextView Ten= (TextView)findViewById(R.id.textView30);
        TextView Eleven = (TextView)findViewById(R.id.textView32);
        TextView Nihss = (TextView)findViewById(R.id.textView2);
        TextView Nknihss= (TextView)findViewById(R.id.textView34);
        TextView Total= (TextView)findViewById(R.id.textView42);

        OneA.setText(String.valueOf(oneA));
        OneB.setText(String.valueOf(oneB));
        OneC.setText(String.valueOf(oneC));
        Two.setText(String.valueOf(two));
        TwoOne.setText(String.valueOf(twoOne));
        TwoTwo.setText(String.valueOf(twoTwo));
        TwoThree.setText(String.valueOf(twoThree));
        Three.setText(String.valueOf(three));
        Four.setText(String.valueOf(four));
        FourOne.setText(String.valueOf(fourOne));
        FourTwo.setText(String.valueOf(fourTwo));
        FiveA.setText(String.valueOf(fiveA));
        FiveB.setText(String.valueOf(fiveB));
        SixA.setText(String.valueOf(sixA));
        SixB.setText(String.valueOf(sixB));
        Seven.setText(String.valueOf(seven));
        SevenTwo.setText(String.valueOf(sevenTwo));
        Eight.setText(String.valueOf(eight));
        Nine.setText(String.valueOf(nine));
        Ten.setText(String.valueOf(ten));
        Eleven.setText(String.valueOf(eleven));
        Nihss.setText(String.valueOf(nihss));
        Nknihss.setText(String.valueOf(nknihss));
        Total.setText(String.valueOf(total));

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ResultActivity.class);
                        intent.putExtra("school", school);
                        intent.putExtra("examiner", examiner);
                        intent.putExtra("caseNumber", caseNumber);
                        intent.putExtra("typeChoose", typeChoose);
                        intent.putExtra("sex", sex);
                        intent.putExtra("timeStamp", timeStamp);
                        intent.putExtra("oneA", oneA);
                        intent.putExtra("oneB", oneB);
                        intent.putExtra("oneC", oneC);
                        intent.putExtra("two", two);
                        intent.putExtra("twoOne", twoOne);
                        intent.putExtra("twoTwo", twoTwo);
                        intent.putExtra("twoThree", twoThree);
                        intent.putExtra("three", three);
                        intent.putExtra("four", four);
                        intent.putExtra("fourOne", fourOne);
                        intent.putExtra("fourTwo", fourTwo);
                        intent.putExtra("fiveA", fiveA);
                        intent.putExtra("fiveB", fiveB);
                        intent.putExtra("sixA", sixA);
                        intent.putExtra("sixB", sixB);
                        intent.putExtra("seven", seven);
                        intent.putExtra("sevenTwo", sevenTwo);
                        intent.putExtra("eight", eight);
                        intent.putExtra("nine", nine);
                        intent.putExtra("ten", ten);
                        intent.putExtra("eleven", eleven);
                        intent.putExtra("nihss", nihss);
                        intent.putExtra("nknihss", nknihss);
                        intent.putExtra("total", total);
                        startActivity(intent);
                    }
                }
        );
    }
}
