package com.example.appfinancas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText nomeEdit;
    private TextInputEditText emailEdit;
    private TextInputEditText senhaEdit;
    private TextInputEditText estadoEdit;
    private MaterialButton btnCadastrar;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        initViews();
        setupActions();
    }

    private void initViews() {

        // IMPORTANTE: esses IDs precisam existir no XML
        nomeEdit = findViewById(R.id.nome);
        emailEdit = findViewById(R.id.email);
        senhaEdit = findViewById(R.id.senha);
        estadoEdit = findViewById(R.id.estado);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        tvLogin = findViewById(R.id.tvLogin);
    }
    private void setupActions() {

        // Botão cadastrar → vai para login
        btnCadastrar.setOnClickListener(v -> {

            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(intent);

            finish(); // impede voltar para cadastro
        });

        // Já tem conta → vai para login
        tvLogin.setOnClickListener(v -> {

            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        });
    }
}