package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Classes.Edicao;
import Classes.Users;

public class MainActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnLoginScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLoginScreen = (Button) findViewById(R.id.btnLoginScreen);
    }

    public void clickBtnRegister(View view){
        Intent intentRegister = new Intent(this,TelaRegistro.class);
        startActivity(intentRegister);
    }

    public void clickBtnLoginScreen(View view){
        Intent intentLoginScreen = new Intent(this,TelaLogin.class);
        startActivity(intentLoginScreen);
    }
}
