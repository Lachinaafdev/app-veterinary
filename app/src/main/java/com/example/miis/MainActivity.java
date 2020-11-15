package com.example.miis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_user;
    private EditText txt_user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_user = (EditText)findViewById(R.id.txt_name_user);
        txt_user_password = (EditText)findViewById(R.id.txt_user_password);
    }


    public void verify(View view){
        String user = txt_user.getText().toString();
        String password = txt_user_password.getText().toString();

        if(user.isEmpty() && password.isEmpty()){
            Toast.makeText(this, "Usuario y Contraseña Vacios", Toast.LENGTH_SHORT).show();
        }else if(user.length() == 0){
            Toast.makeText(this, "Campo Usuario Vacio", Toast.LENGTH_SHORT).show();
        }else if(password.length() == 0){
            Toast.makeText(this, "Campo Contraseña Vacia", Toast.LENGTH_SHORT).show();
        }
        else if(!user.equals("admin") && !password.equals("admin")){
            Toast.makeText(this, "Usuario o Contraseña Invalida", Toast.LENGTH_SHORT).show();
        }

        if(user.equals("admin") && password.equals("admin")){
            Intent i = new Intent(this, ListPets.class);
            Toast.makeText(this,"Inicio Correcto", Toast.LENGTH_SHORT).show();
            startActivity(i);
            finish();
        }
    }
}