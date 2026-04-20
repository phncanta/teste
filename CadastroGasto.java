package com.example.appfinancas;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CadastroGasto extends AppCompatActivity {

    EditText edtValor, edtData;
    Spinner spCategoria;
    Button btnSalvar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_gasto);

        // Referências
        edtValor = findViewById(R.id.edtValor);
        edtData = findViewById(R.id.edtData);
        spCategoria = findViewById(R.id.spCategoria);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCancelar = findViewById(R.id.btnCancelar);

        // Spinner
        String[] categorias = {"Alimentação", "Transporte", "Lazer", "Outros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                categorias
        );
        spCategoria.setAdapter(adapter);

        // DatePicker
        edtData.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            new DatePickerDialog(this,
                    (view, year, month, day) -> {
                        String data = day + "/" + (month + 1) + "/" + year;
                        edtData.setText(data);
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            ).show();
        });

        // Botão salvar
        btnSalvar.setOnClickListener(v -> {
            String valor = edtValor.getText().toString();
            String data = edtData.getText().toString();

            if (valor.isEmpty() || data.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Gasto salvo com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CadastroGasto.this, GraficoActivity.class);
                startActivity(intent);
            }
        });

        // Cancelar
        btnCancelar.setOnClickListener(v -> {

            Intent intent = new Intent(CadastroGasto.this, GraficoActivity.class);
            startActivity(intent);

            finish();
        });
    }
}
