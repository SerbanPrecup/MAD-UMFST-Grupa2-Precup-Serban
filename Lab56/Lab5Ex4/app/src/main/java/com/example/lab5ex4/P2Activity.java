package com.example.lab5ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class P2Activity extends AppCompatActivity {

    TextInputEditText textInput2;
    FloatingActionButton btnSend;

    TextView txtSwitch;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);

        textInput2 = findViewById(R.id.Msg);
        btnSend = findViewById(R.id.btnSend);
        textView = findViewById(R.id.textMesaje);
        txtSwitch = findViewById(R.id.txtSwitch);

        textView.setText(Mesaje.mesaje);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textInput2.getText().toString().isEmpty())
                    Toast.makeText(P2Activity.this, "Scrie ceva!", Toast.LENGTH_SHORT).show();
                else{
                    String textP2 ="P2:" + textInput2.getText().toString();
                    textView.append("\n");
                    textView.append(textP2);
                    Mesaje.mesaje=Mesaje.mesaje.concat("\n" + textP2);
                }
            }
        });

        txtSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(P2Activity.this,P1Activity.class);
                startActivity(intent);
            }
        });
    }
}