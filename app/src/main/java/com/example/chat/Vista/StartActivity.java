package com.example.chat.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chat.Interfaces.InterfacesStart;
import com.example.chat.Presentador.StartPresentador;
import com.example.chat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity implements View.OnClickListener, InterfacesStart.Vista {

    Button login, registro;

    InterfacesStart.Presentador presentador;

    @Override
    protected void onStart() {
        super.onStart();
        presentador = new StartPresentador(this);
        verificarSesion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findElement();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.registrar:
                startActivity(new Intent(this, RegistroActivity.class));
                break;
        }
    }

    @Override
    public void findElement(){
        login = findViewById(R.id.login);
        registro = findViewById(R.id.registrar);

        login.setOnClickListener(this);
        registro.setOnClickListener(this);
    }

    @Override
    public void verificarSesion(){
        presentador.verificarSesion();
    }

    @Override
    public void desplegarInicio() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}