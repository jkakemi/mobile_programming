package com.example.aula8ex1;

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
    private EditText mensagem;
    private TextView verificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensagem = findViewById(R.id.editTextMensagem);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);
        verificar = findViewById(R.id.textViewVerificar);

        btnSalvar.setOnClickListener(v -> MensagemSalva());

        btnRecuperar.setOnClickListener(v -> MensagemRecuperada());
    }

    private void MensagemSalva() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saved_message), mensagem.getText().toString());
        editor.commit();
        verificar.setText("Mensagem salva com sucesso!");
    }

    private void MensagemRecuperada() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String aux = sharedPref.getString(getString(R.string.saved_message),null);
        if(aux != null){
            mensagem.setText(aux);
            verificar.setText("");
        }
        else{
            verificar.setText("Não foi possível recuperar a mensagem!");
        }
    }
}
