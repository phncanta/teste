package com.example.appfinancas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEdit;
    private TextInputEditText senhaEdit;

    private MaterialButton btnEntrar;
    private TextView tvCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailEdit = findViewById(R.id.email); // se você ainda não colocou id, me avisa
        senhaEdit = findViewById(R.id.senha); // idem
        btnEntrar = findViewById(R.id.btnEntrar);
        tvCriarConta = findViewById(R.id.tvCriarConta);

        setupActions();
    }

    private void setupActions() {

        // Entrar no app (vai para gráfico)
        btnEntrar.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, GraficoActivity.class);
            startActivity(intent);

            finish(); // não volta para login
        });

        // Ir para cadastro
        tvCriarConta.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }
}