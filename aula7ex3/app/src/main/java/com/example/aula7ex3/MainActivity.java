package com.example.aula7ex3;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aula7ex3.R;

public class MainActivity extends AppCompatActivity {

    private TextView textViewEscolaridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewEscolaridade = findViewById(R.id.textViewEscolaridade);
    }

    public void onRadioClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.radio_fundamental) {
            if (checked)
                textViewEscolaridade.setText("Ensino Fundamental");
        } else if (view.getId() == R.id.radio_medio) {
            if (checked)
                textViewEscolaridade.setText("Ensino Médio");
        } else if (view.getId() == R.id.radio_incompleto) {
            if (checked)
                textViewEscolaridade.setText("Superior Incompleto");
        } else if (view.getId() == R.id.radio_completo) {
            if (checked)
                textViewEscolaridade.setText("Superior Completo");
        } else if (view.getId() == R.id.radio_eincompleto) {
            if (checked)
                textViewEscolaridade.setText("Esp. Incompleto");
        } else if (view.getId() == R.id.radio_ecompleto) {
            if (checked)
                textViewEscolaridade.setText("Esp. Completo");
        } else if (view.getId() == R.id.radio_mincompleto) {
            if (checked)
                textViewEscolaridade.setText("Mestrado Incompleto");
        } else if (view.getId() == R.id.radio_mcompleto) {
            if (checked)
                textViewEscolaridade.setText("Mestrado Completo");
        } else if (view.getId() == R.id.radio_dincompleto) {
            if (checked)
                textViewEscolaridade.setText("Doutorado Incompleto");
        } else if (view.getId() == R.id.radio_dcompleto) {
            if (checked)
                textViewEscolaridade.setText("Doutorado Completo");
        }
    }
}

