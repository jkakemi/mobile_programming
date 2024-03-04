package com.example.aula7ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView precoFinal;
    private double total = 4.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoFinal = findViewById(R.id.textViewTotal);
    }

    public void onCheckClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.checkbox_alface) {
            if (checked) {
                total += 0.30;
            } else {
                total -= 0.30;
            }
        } else if (view.getId() == R.id.checkbox_presunto) {
            if (checked) {
                total += 0.70;
            } else {
                total -= 0.70;
            }
        } else if (view.getId() == R.id.checkbox_peru) {
            if (checked) {
                total += 1.00;
            } else {
                total -= 1.00;
            }
        } else if (view.getId() == R.id.checkbox_azeitona) {
            if (checked) {
                total += 0.50;
            } else {
                total -= 0.50;
            }
        }
        else if (view.getId() == R.id.checkbox_tomate) {
            if (checked) {
                total += 0.50;
            } else {
                total -= 0.50;
            }
        }
        else if (view.getId() == R.id.checkbox_queijo) {
            if (checked) {
                total += 1.00;
            } else {
                total -= 1.00;
            }
        }
        else if (view.getId() == R.id.checkbox_ovo) {
            if (checked) {
                total += 0.50;
            } else {
                total -= 0.50;
            }
        }
        else if (view.getId() == R.id.checkbox_milho) {
            if (checked) {
                total += 0.30;
            } else {
                total -= 0.30;
            }
        }
        else if (view.getId() == R.id.checkbox_frango) {
            if (checked) {
                total += 2.00;
            } else {
                total -= 2.00;
            }
        }
        precoFinal.setText("Preço total: R$" + total);
    }

}