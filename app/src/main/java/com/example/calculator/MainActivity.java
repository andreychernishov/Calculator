package com.example.calculator;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String SAVE = "SCREEN";
    private CalculatorModel calculator;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[] {
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9
        };

        int[] actionsIds = new int[] {
                R.id.button_plus,
                R.id.button_minus,
                R.id.button_multiply,
                R.id.button_divide,
                R.id.button_equals
        };

        tvResult = findViewById(R.id.result_view);

        calculator = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = view -> {
            calculator.onNumPressed(view.getId());
            tvResult.setText(calculator.getText());
        };

        View.OnClickListener actionButtonOnclickListener = view -> {
            calculator.onActionPressed(view.getId());
            tvResult.setText(calculator.getText());
        };

        for (int numberId : numberIds) {
            findViewById(numberId).setOnClickListener(numberButtonClickListener);
        }

        for (int actionsId : actionsIds) {
            findViewById(actionsId).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.button_clear).setOnClickListener(view -> {
            calculator.reset();
            tvResult.setText(calculator.getText());
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVE, String.valueOf(calculator));
    }
}