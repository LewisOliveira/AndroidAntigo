package com.example.pc.hqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Classes.Users;

public class TelaLogin extends AppCompatActivity {
    EditText txtLogin;
    EditText txtPassword;
    Button btnLogin;
    Button btnForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnForgotPassword = (Button) findViewById(R.id.btnForgotPassword);
    }

    public void clickBtnLogin(View view){
        if(Users.autenticacaoUsuarioCadastrado(txtLogin.getText().toString(),txtPassword.getText().toString())) {
            String txt = txtLogin.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("Email",txt);
            Intent intentLogin = new Intent(this, TelaInicial.class);
            intentLogin.putExtras(bundle);
            startActivity(intentLogin);
        }
        else{
            Toast.makeText(this,"Usuario não encontrado",Toast.LENGTH_LONG);
        }
    }

    public void clickBtnForgotPassword(View view){

    }
}
