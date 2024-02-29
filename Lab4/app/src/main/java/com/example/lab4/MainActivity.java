package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ADD;
    Button SUB;
    Button DIV;
    Button MUL;
    EditText first;
    EditText second;

    TextView txtResult;

    private void calculate(char operation) {
        if (first.getText().toString().isEmpty() || second.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Introduceți valori în ambele câmpuri", Toast.LENGTH_SHORT).show();
            txtResult.setText("");
            return;
        }
        double result = 0;
        double num1 = Double.parseDouble(first.getText().toString());
        double num2 = Double.parseDouble(second.getText().toString());

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    Toast.makeText(MainActivity.this, "Împărțire la zero!", Toast.LENGTH_SHORT).show();
                    txtResult.setText("");
                    return;
                }
                result = num1 / num2;
                break;
        }
        txtResult.setText(String.valueOf(result));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ADD = findViewById(R.id.btnAdd);
        SUB = findViewById(R.id.btnSub);
        DIV = findViewById(R.id.btnDiv);
        MUL = findViewById(R.id.btnMul);

        first = findViewById(R.id.edtxtFirst);
        second = findViewById(R.id.edtxtSecond);

        txtResult = findViewById(R.id.txtResult);

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        SUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        DIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        MUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });
        }
    }