package com.example.lab5ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class P1Activity extends AppCompatActivity {

    TextInputEditText textInput1;
    FloatingActionButton btnSend;
    TextView txtSwitch;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput1 = findViewById(R.id.Msg);
        btnSend = findViewById(R.id.btnSend);
        textView = findViewById(R.id.textMesaje);
        txtSwitch = findViewById(R.id.txtSwitch);

        textView.setText(Mesaje.mesaje);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textInput1.getText().toString().isEmpty())
                    Toast.makeText(P1Activity.this, "Scrie ceva!", Toast.LENGTH_SHORT).show();
                else{
                String textP1 ="P1:" + textInput1.getText().toString();
                textView.append("\n");
                textView.append(textP1);
                Mesaje.mesaje=Mesaje.mesaje.concat("\n" + textP1);
                }
            }
        });

        txtSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(P1Activity.this,P2Activity.class);
                startActivity(intent);
            }
        });

    }
}