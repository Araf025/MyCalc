package com.example.ayazs.mycalc;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {


    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button div;
    private Button mul;
    private Button sub;
    private Button add;
    private Button equal;
    private Button clear;
    private Button decimal;
    private Button sign;
    private Button doubleZero;
    private Button percent;
    private TextView info;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char PERCENT = '%';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+".");
            }
        });
        doubleZero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"00");
            }
        });
        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(info.getText().toString()=="") {
                    info.setText(info.getText().toString() + "-");
                }
                else if(info.getText().toString()=="-"){
                    info.setText(info.getText().toString() + "");
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString()!=""){
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
                }
                else{
                    result.setText("Error");
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString()!=""){
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
                }
                else{
                    result.setText("Error");
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString()!=""){
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
                }
                else{
                    result.setText("Error");
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString()!=""){
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
                }
                else{
                    result.setText("Error");
                }
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString()!=""){
                    compute();
                    ACTION = PERCENT;
                    result.setText(String.valueOf(val1) + "%");
                    info.setText(null);
                }
                else{
                    result.setText("Error");
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString()!=""){
                compute();
                ACTION = EQU;
                result.setText(String.valueOf(val1));
                info.setText(null);
                saveInfo(v);
                }
                else{
                    displayResult(v);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });


    }

    private void setupUIViews(){
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        zero = (Button)findViewById(R.id.btn0);
        div = (Button)findViewById(R.id.btndiv);
        mul = (Button)findViewById(R.id.btnmul);
        sub = (Button)findViewById(R.id.btnsub);
        add = (Button)findViewById(R.id.btnadd);
        decimal = (Button)findViewById(R.id.btndec);
        sign = (Button)findViewById(R.id.btnsign);
        doubleZero = (Button)findViewById(R.id.btnd0);
        percent = (Button)findViewById(R.id.btnper);
        equal = (Button)findViewById(R.id.btne);
        clear = (Button)findViewById(R.id.btnclear);
        info = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case PERCENT:
                    val1 = val1*(val2/100);
                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

    public void saveInfo(View v){
        SharedPreferences sharedPref = getSharedPreferences("calcInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("answer",result.getText().toString());
        editor.apply();
    }

    public void displayResult(View v){
        SharedPreferences sharedPref = getSharedPreferences("calcInfo",Context.MODE_PRIVATE);
        String answer = sharedPref.getString("answer","");
        info.setText(answer);
    }
}
