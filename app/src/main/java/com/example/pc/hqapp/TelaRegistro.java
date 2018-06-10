package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Classes.Banco;
import Classes.Users;

public class TelaRegistro extends AppCompatActivity{
    EditText nome;
    EditText senha;
    EditText confirm;
    EditText email;
    Button cadastrar;
    Banco b = new Banco(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);
        nome = (EditText) findViewById(R.id.txtName);
        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtPasswordNew);
        confirm = (EditText) findViewById(R.id.txtPasswordConfirm);
        cadastrar = (Button) findViewById(R.id.btnSignUp);
        cadastrar.setOnClickListener(new View.OnClickListener(){

            @Override
        public void onClick(View v) {
            Intent intentLogin = new Intent(getApplicationContext(), TelaLogin.class);
            Toast deuCerto = Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_LONG);
            if(b.JaCadastrado(email.getText().toString(),senha.getText().toString()) == false){
                new Users(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                deuCerto.show();
                startActivity(intentLogin);

            }
            if(b.SenhaDiferente(senha.getText().toString()))
                Toast.makeText(getApplicationContext(), "A senha e a confirmação devem ser iguais", Toast.LENGTH_LONG).show();
                else if (b.EmailCadastrado(email.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Email ja cadastrado", Toast.LENGTH_LONG).show();
                else {
                    new Users(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                    deuCerto.show();
                    startActivity(intentLogin);
                }
            }
        });
    }
}