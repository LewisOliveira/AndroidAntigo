package com.example.pc.hqapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaQuadrinho extends AppCompatActivity {

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

    }
}
