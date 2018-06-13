package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import Classes.Banco;
import Classes.Edicao;
import Classes.GridViewQuadrinhos;
import Classes.RecyclerViewAdapter;
import Classes.Users;

public class TelaInicial extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        TextView oi = (TextView) findViewById(R.id.txtOla);
        Users usuario = identificaUsuario(getIntent().getExtras().getString("Email").toString(),getIntent().getExtras().getString("Senha"));
        oi.setText("Olá " + usuario.getNome());
        getImages();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        Banco bd = new Banco(this);
        ArrayList<Edicao> lista = bd.ListaEdicao();

        for (int i = 0; i < lista.size(); i++) {
            mImageUrls.add(lista.get(i).getCapa());
            mNames.add(lista.get(i).getTitulo());
        }

/*
        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");
*/
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init RecyclerView");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        //recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int idImagem =(int) parent.getItemAtPosition(position);
        Intent intent = new Intent(this,TelaQuadrinho.class);
        intent.putExtra("idImagem",idImagem);
        startActivity(intent);
    }

    public Users identificaUsuario(String pEmail, String pSenha){
        Banco bd = new Banco(this);
        ArrayList<Users> lista = bd.ListaUsuarios();

        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getEmail().equals(pEmail)) && (lista.get(i).getSenha().equals(pSenha)))
                return lista.get(i);
        }
        return null;
    }
}
