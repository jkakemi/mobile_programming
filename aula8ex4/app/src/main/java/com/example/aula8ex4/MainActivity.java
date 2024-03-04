package com.example.aula8ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private String arrayItem[] = {"PS5", "XBOX", "COMPUTADOR", "CARRO", "MANSÃO"};
    private Set<String> favSet;
    private SharedPreferences sharedPreferences;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> selecaoFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("PrefFav", Context.MODE_PRIVATE);
        favSet = sharedPreferences.getStringSet("favoritos", new HashSet<String>());

        ListView listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayItem);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String item = (String) adapterView.getItemAtPosition(i);
            botaoFavoritos(item);
        });

        selecaoFavoritos = new ArrayList<>();

        Button mostrarFavoritos = findViewById(R.id.showFavoritesTextViewButton);
        mostrarFavoritos.setOnClickListener(view -> mostrarFavoritos());

        Button addFavoritos = findViewById(R.id.addFavoriteButton);
        addFavoritos.setOnClickListener(view -> addSelectedFavorites());

        Button removerFavoritos = findViewById(R.id.removeFavoriteButton);
        removerFavoritos.setOnClickListener(view -> removeSelectedFavorites());
    }

    private void botaoFavoritos(String item) {
        if (favSet.contains(item)) {
            favSet.remove(item); // Remove o item favorito se já estiver na lista de favoritos
            Toast.makeText(MainActivity.this, item + " removido dos favoritos", Toast.LENGTH_SHORT).show();
        } else {
            favSet.add(item); // Adiciona o item favorito se não estiver na lista de favoritos
            Toast.makeText(MainActivity.this, item + " adicionado aos favoritos", Toast.LENGTH_SHORT).show();
        }
        salvarFavoritos();
    }

    private void salvarFavoritos() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("favorites", favSet);
        editor.apply();
    }

    private void mostrarFavoritos() {
        StringBuilder favoritesText = new StringBuilder("Itens favoritos:\n");
        for (String favorite : favSet) {
            favoritesText.append("- ").append(favorite).append("\n");
        }
        TextView favoritesTextView = findViewById(R.id.favoritesTextView);
        favoritesTextView.setText(favoritesText.toString());
        favoritesTextView.setVisibility(View.VISIBLE);
    }

    private void addSelectedFavorites() {
        for (String favorite : selecaoFavoritos) {
            favSet.add(favorite); // Adiciona os itens selecionados à lista de favoritos
            Toast.makeText(MainActivity.this, favorite + " adicionado aos favoritos", Toast.LENGTH_SHORT).show();
        }
        selecaoFavoritos.clear(); // Limpa a lista de itens selecionados
        salvarFavoritos(); // Salva a lista atualizada de favoritos
    }

    private void removeSelectedFavorites() {
        for (String favorite : selecaoFavoritos) {
            if (favSet.contains(favorite)) {
                favSet.remove(favorite); // Remove os itens selecionados da lista de favoritos
                Toast.makeText(MainActivity.this, favorite + " removido dos favoritos", Toast.LENGTH_SHORT).show();
            }
        }
        selecaoFavoritos.clear(); // Limpa a lista de itens selecionados
        salvarFavoritos(); // Salva a lista atualizada de favoritos
    }

}
