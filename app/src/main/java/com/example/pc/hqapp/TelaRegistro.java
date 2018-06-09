package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Classes.Users;

public class TelaRegistro extends AppCompatActivity{
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
                boolean emailCadastrado = false;
                Toast deuCerto = Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_LONG);
                if (Users.usuarios.isEmpty()) {
                    if (senha.getText().toString().equals(confirm.getText().toString())) {
                        new Users(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                        deuCerto.show();
                        startActivity(intentLogin);

                    } else {
                        Toast.makeText(getApplicationContext(), "A senha e a confirmação devem ser iguais", Toast.LENGTH_LONG).show();
                    }
                } else {
                    for (int i = 0; i < Users.usuarios.size(); i++) {
                        if (Users.usuarios.get(i).getEmail().toString().equals(email.getText().toString())) {
                            emailCadastrado = true;
                        }
                    }

                    if (emailCadastrado) {
                        Toast.makeText(getApplicationContext(), "Email ja cadastrado", Toast.LENGTH_LONG).show();
                    } else if (!senha.getText().toString().equals(confirm.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "A senha e a confirmação devem ser iguais", Toast.LENGTH_LONG).show();
                    } else {
                        new Users(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                        deuCerto.show();
                        startActivity(intentLogin);
                    }
                }
            }
        });
    }
}
