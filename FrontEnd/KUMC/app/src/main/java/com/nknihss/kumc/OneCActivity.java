package com.nknihss.kumc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OneCActivity extends AppCompatActivity {
    int tmp = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_c);

        Intent intent = getIntent();
        final String school = intent.getStringExtra("school");
        final String examiner = intent.getStringExtra("examiner");
        final String caseNumber = intent.getStringExtra("caseNumber");
        final String typeChoose = intent.getStringExtra("typeChoose");
        final String sex = intent.getStringExtra("sex");
        final String timeStamp = intent.getStringExtra("timeStamp");
        final int oneA = intent.getIntExtra("oneA",0);
        final int oneB = intent.getIntExtra("oneB",0);

        RadioGroup Rg = (RadioGroup) findViewById(R.id.radioGroup);
        Rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId== R.id.radioButton1) {
                    tmp = 0;
                } else if(checkedId == R.id.radioButton2) {
                    tmp = 1;
                } else if(checkedId == R.id.radioButton3) {
                    tmp = 2;
                }
            }
        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(OneCActivity.this,PopOneC.class));
            }
        });

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if(tmp==-1) {
                            Toast.makeText(getApplicationContext(),"항목을 체크해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(v.getContext(), TwoActivity.class);
                            intent.putExtra("school", school);
                            intent.putExtra("examiner", examiner);
                            intent.putExtra("caseNumber", caseNumber);
                            intent.putExtra("typeChoose", typeChoose);
                            intent.putExtra("sex", sex);
                            intent.putExtra("timeStamp", timeStamp);
                            intent.putExtra("oneA", oneA);
                            intent.putExtra("oneB", oneB);
                            intent.putExtra("oneC", tmp);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
