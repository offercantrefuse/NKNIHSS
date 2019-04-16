package com.nknihss.kumc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {
    private NetworkService networkService;

    EditText StartTime;
    EditText EndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        networkService = RetrofitClientInstance.getRetrofitInstance().create(NetworkService.class);

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
        final int nihss = intent.getIntExtra("nihss", 0);
        final int nknihss = intent.getIntExtra("nknihss", 0);
        final int total = intent.getIntExtra("total", 0);

        StartTime = (EditText) findViewById(R.id.editText1);
        EndTime = (EditText) findViewById(R.id.editText2);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        Intent intent = new Intent(v.getContext(), EnterActivity.class);
                        Information information = new Information();
                        information.setSchool(school);
                        information.setExaminer(examiner);
                        information.setCaseNumber(caseNumber);
                        information.setTypeChoose(typeChoose);
                        information.setSex(sex);
                        information.setTimeStamp(timeStamp);
                        information.setOneA(oneA);
                        information.setOneB(oneB);
                        information.setOneC(oneC);
                        information.setTwo(two);
                        information.setTwoOne(twoOne);
                        information.setTwoTwo(twoTwo);
                        information.setTwoThree(twoThree);
                        information.setThree(three);
                        information.setFour(four);
                        information.setFourOne(fourOne);
                        information.setFourTwo(fourTwo);
                        information.setFiveA(fiveA);
                        information.setFiveB(fiveB);
                        information.setSixA(sixA);
                        information.setSixB(sixB);
                        information.setSeven(seven);
                        information.setSevenTwo(sevenTwo);
                        information.setEight(eight);
                        information.setNine(nine);
                        information.setTen(ten);
                        information.setEleven(eleven);
                        information.setNihss(nihss);
                        information.setNknihss(nknihss);
                        information.setTotal(total);
                        information.setStartTime(StartTime.getText().toString());
                        information.setEndTime(EndTime.getText().toString());
                        // DB 저장
                        Call<Information> call = networkService.createUser(information);
                        call.enqueue(new Callback<Information>() {
                            @Override
                            public void onResponse(Call<Information> call, Response<Information> response) {
                                Toast.makeText(getApplicationContext(),"결과가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<Information> call, Throwable t) {
                                Toast.makeText(getApplicationContext(),t.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }
        );
    }
}
