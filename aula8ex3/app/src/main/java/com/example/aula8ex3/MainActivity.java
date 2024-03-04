package com.example.aula8ex3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "Configuracoes";
    private static final String TEMA_CLARO = "ModoClaro";
    private static final String TEMA_ESCURO = "ModoEscuro";

    private SharedPreferences sharedPreferences;

    private Switch switchNotificacoes;
    private Button modoClaro;
    private Button modoEscuro;
    private ConstraintLayout constraintLayout;
    private SeekBar seekBarTamanhoFonte;
    private TextView textViewTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        switchNotificacoes = findViewById(R.id.switchNotificacoes);
        modoClaro = findViewById(R.id.btnClaro);
        modoEscuro = findViewById(R.id.btnEscuro);
        constraintLayout = findViewById(R.id.rl);
        seekBarTamanhoFonte = findViewById(R.id.seekBarTamanhoFonte);
        textViewTitulo = findViewById(R.id.textViewTitulo);

        modoClaro.setOnClickListener(v -> {
            constraintLayout.setBackgroundResource(R.color.cool);
            salvarTema(TEMA_CLARO);
        });

        modoEscuro.setOnClickListener(view -> {
            constraintLayout.setBackgroundResource(R.color.warm);
            salvarTema(TEMA_ESCURO);
        });

        String temaSalvo = sharedPreferences.getString("TEMA", "");
        if (temaSalvo.equals(TEMA_CLARO)) {
            constraintLayout.setBackgroundResource(R.color.cool);
        } else if (temaSalvo.equals(TEMA_ESCURO)) {
            constraintLayout.setBackgroundResource(R.color.warm);
        }

        int tamFonteSalvo = sharedPreferences.getInt("TAMANHO_FONTE", 16);
        seekBarTamanhoFonte.setProgress(tamFonteSalvo);
        textViewTitulo.setTextSize(tamFonteSalvo);

        boolean notificacoesAtivadas = sharedPreferences.getBoolean("NOTIFICACOES_ATIVADAS", true);
        switchNotificacoes.setChecked(notificacoesAtivadas);

        switchNotificacoes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Notificações ativadas", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Notificações desativadas", Toast.LENGTH_SHORT).show();
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("NOTIFICACOES_ATIVADAS", isChecked);
                editor.apply();
            }
        });

        switchNotificacoes.setChecked(notificacoesAtivadas);
    }

    private void salvarTema(String tema) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TEMA", tema);
        editor.apply();
    }
}
