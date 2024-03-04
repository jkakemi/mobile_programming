package com.example.aula8ex2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNome, editTextIdade, editTextAltura;
    private TextView textViewMaior, verificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextAltura = findViewById(R.id.editTextAltura);
        textViewMaior = findViewById(R.id.textViewMaior);
        verificar = findViewById(R.id.textViewVerificar);

        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);

        btnSalvar.setOnClickListener(v -> salvar());

        btnRecuperar.setOnClickListener(v -> recuperar());
    }

    private void salvar() {
        SharedPreferences sharedPref = getSharedPreferences("PessoaMaisAlta", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        float atual = sharedPref.getFloat("altura", 0);
        float inserida = Float.parseFloat(editTextAltura.getText().toString());

        if (inserida > atual) {
            editor.putString("nome", editTextNome.getText().toString());
            editor.putInt("idade", Integer.parseInt(editTextIdade.getText().toString()));
            editor.putFloat("altura", inserida);
            editor.commit();
            verificar.setText("Os dados foram salvos com sucesos!");
        } else {
            verificar.setText("Altura é menor do que a atual!");
        }
    }


    private void recuperar() {
        SharedPreferences sharedPreferences = getSharedPreferences("PessoaMaisAlta", Context.MODE_PRIVATE);

        String nome = sharedPreferences.getString("nome", "");
        int idade = sharedPreferences.getInt("idade", 0);
        float altura = sharedPreferences.getFloat("altura", 0);

        if (nome.isEmpty()) {
            verificar.setText("Nenhum dado encontrado!");
        } else {
            editTextNome.setText(nome);
            editTextIdade.setText(String.valueOf(idade));
            editTextAltura.setText(String.valueOf(altura));
        }
    }
}
