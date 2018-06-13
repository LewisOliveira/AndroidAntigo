package com.example.pc.hqapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaQuadrinho extends AppCompatActivity {
    Button btnAdicionarColecao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quadrinho);
        int imagemName = getIntent().getIntExtra("idImagem",-1);
        if(imagemName == -1){
            Toast.makeText(this, "Nenhuma Imagem Encontrada", Toast.LENGTH_SHORT).show();
        }else{
            ImageView img = findViewById(R.id.ImageTelaImage);
            img.setImageResource(imagemName);
        }
        btnAdicionarColecao = (Button) findViewById(R.id.btnAdicionarColecao);
    }

    public void clickBtnAdicionarColecao(View view){
        Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
    }

}
