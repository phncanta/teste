package com.example.appfinancas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MeusGastos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_gastos);

    }
    //Botão para excluir gasto
    public void excluirg (View v){

            Intent intent = new Intent(MeusGastos.this, ConfirmarExclusao.class);
            startActivity(intent);

            finish();

    }
    //Botão para excluir gasto
    public void excluirg2 (View v){

            Intent intent = new Intent(MeusGastos.this, ConfirmarExclusao.class);
            startActivity(intent);

            finish();

    }
    //Botão para ir a cadastro gastos
    public void ircadastrogastos (View v){
            Intent intent = new Intent(MeusGastos.this, CadastroGasto.class);
            startActivity(intent);
    }

    //Botão para voltar de Meus Gastos para GraficoActivity
    public void voltarg(View v){

        Intent intent = new Intent(this, GraficoActivity.class);
        startActivity(intent);
    }

}