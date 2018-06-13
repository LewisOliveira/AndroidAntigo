package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Classes.Banco;
import Classes.Users;

public class TelaRegistro extends AppCompatActivity{
    Users usuario = new Users();
    EditText nome;
    EditText senha;
    EditText confirm;
    EditText email;
    Button cadastrar;

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
                if(validarUsuario(email.getText().toString(),senha.getText().toString()) == false){
                    salvarUsuario();
                    startActivity(intentLogin);
                }

                if(SenhaDiferente(senha.getText().toString()))
                    Toast.makeText(getApplicationContext(), "A senha e a confirmação devem ser iguais", Toast.LENGTH_LONG).show();
                else if (EmailCadastrado(email.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Email ja cadastrado", Toast.LENGTH_LONG).show();
                else {
                    salvarUsuario();
                    startActivity(intentLogin);
                }
            }
        });
    }

    public void salvarUsuario(){
        usuario.setNome(nome.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setSenha(senha.getText().toString());

        Banco bd = new Banco(this);
        bd.inserirUsuario(usuario);

        Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
    }

    public boolean validarUsuario(String pEmail, String pSenha) {
        Banco bd = new Banco(this);
        ArrayList<Users> usuarios = bd.ListaUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if ((usuarios.get(i).getEmail().equals(pEmail)) && (usuarios.get(i).getSenha().equals(pSenha)))
                return true;
        }
        return false;
    }
    public boolean SenhaDiferente(String pSenha){
        Banco bd = new Banco(this);
        ArrayList<Users> usuarios = bd.ListaUsuarios();
        for (int i = 0; i < usuarios.size(); i++){
            if(!usuarios.get(i).getSenha().equals(pSenha))
                return true;
        }
        return false;
    }
    public boolean EmailCadastrado(String pEmail){
        Banco bd = new Banco(this);
        ArrayList<Users> usuarios = bd.ListaUsuarios();
        for (int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getEmail().equals(pEmail))
                return true;
        }
        return false;
    }
}