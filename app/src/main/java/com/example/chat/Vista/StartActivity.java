package com.example.chat.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chat.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, registro;

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

    public void findElement(){
        login = findViewById(R.id.login);
        registro = findViewById(R.id.registrar);

        login.setOnClickListener(this);
        registro.setOnClickListener(this);
    }
}