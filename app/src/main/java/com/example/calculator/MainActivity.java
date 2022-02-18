package com.example.calculator;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;




import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView screen;
    private String saveScreen = "";
    public static final String SAVE = "SCREEN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        if (savedInstanceState != null) {
            saveScreen = savedInstanceState.getString(SAVE, "");
        }

        screen.setText(saveScreen);
    }

    private void initView() {

        screen = findViewById(R.id.input_view);
        initClickListener();

    }


    private void initClickListener() {

        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonPoint = findViewById(R.id.button_point);
        Button buttonPercent = findViewById(R.id.button_percent);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonReset = findViewById(R.id.button_clear);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonReset.setOnClickListener(this);

    }

    private void setText(String s) {
        saveScreen = saveScreen + s;
        screen.setText(saveScreen);
    }

    private void deleteAll(){
        saveScreen = "";
        screen.setText(saveScreen);
    }
    private void deleteNumber(){
        saveScreen = saveScreen;
        screen.setText(screen.length()-1);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_0:
                setText("0");
                break;
            case R.id.button_1:
                setText("1");
                break;
            case R.id.button_2:
                setText("2");
                break;
            case R.id.button_3:
                setText("3");
                break;
            case R.id.button_4:
                setText("4");
                break;
            case R.id.button_5:
                setText("5");
                break;
            case R.id.button_6:
                setText("6");
                break;
            case R.id.button_7:
                setText("7");
                break;
            case R.id.button_8:
                setText("8");
                break;
            case R.id.button_9:
                setText("9");
                break;
            case R.id.button_percent:
                setText("%");
                break;
            case R.id.button_point:
                setText(".");
                break;
            case R.id.button_multiply:
                setText("*");
                break;
            case R.id.button_divide:
                setText("/");
                break;
            case R.id.button_plus:
                setText("+");
                break;
            case R.id.button_minus:
                setText("-");
                break;

            case R.id.button_clear:
                deleteAll();
                break;
            case R.id.button_equals:
                setText("=");
                break;
            case R.id.button_delete:
                deleteNumber();
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVE, saveScreen);
    }
}