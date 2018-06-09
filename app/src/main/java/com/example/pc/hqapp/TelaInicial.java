package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import Classes.Edicao;
import Classes.GridViewQuadrinhos;
import Classes.Users;

public class TelaInicial extends AppCompatActivity implements AdapterView.OnItemClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        TextView oi = (TextView) findViewById(R.id.txtOla);
        String Email = getIntent().getExtras().getString("Email");
        String Login = Users.getNomeByEmail(Email);
        oi.setText("Olá " + Login);
        GridView grid1 = (GridView) findViewById(R.id.gridQuadrinhos);
        GridView grid2 = (GridView) findViewById(R.id.gridColecao);
        Users usuario = Users.procuraUsuario(Email,Login);
        //usuario.insereQuadrinhoColecao(Edicao.edicoes,"Alias",1);
        int[] imagens1 = new int[]{
                R.mipmap.imagem1,
                R.mipmap.imagem2,
                R.mipmap.imagem3,
                R.mipmap.imagem4,
                R.mipmap.imagem5,
                R.mipmap.imagem6,
                R.mipmap.imagem7,
                R.mipmap.imagem8,
        };

        int[] imagens2 = new int[]{
               R.mipmap.imagem8,
               R.mipmap.imagem7,
               R.mipmap.imagem6,
               R.mipmap.imagem5,
               R.mipmap.imagem4,
               R.mipmap.imagem3,
               R.mipmap.imagem2,
               R.mipmap.imagem1,

        };

        grid1.setOnItemClickListener(this);
        grid2.setOnItemClickListener(this);
        grid1.setAdapter(new GridViewQuadrinhos(this,imagens1));
        grid2.setAdapter(new GridViewQuadrinhos(this,imagens2));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int idImagem =(int) parent.getItemAtPosition(position);
        Intent intent = new Intent(this,TelaQuadrinho.class);
        intent.putExtra("idImagem",idImagem);
        startActivity(intent);
    }
}
