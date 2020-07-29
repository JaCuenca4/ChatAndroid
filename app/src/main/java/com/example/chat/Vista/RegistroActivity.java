package com.example.chat.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Presentador.RegistroPresentador;
import com.example.chat.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RegistroActivity extends AppCompatActivity implements InterfacesRegistro.Vista, View.OnClickListener {

    //Variables
    MaterialEditText username, email, password;
    Button btn_registrar;
    RegistroPresentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        presentador = new RegistroPresentador(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void findElement() {
        username = findViewById(R.id.username);
        email = findViewById(R.id.correo);
        password = findViewById(R.id.password);
        btn_registrar = findViewById(R.id.btn_registrar);
        btn_registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_registrar:
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
                }
                if(presentador.solicitarRegistro(username.getText().toString(), email.getText().toString(), password.getText().toString())){
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(this, "El correo o contraseña son erroneos. Verifíquelos y vuelva a intentarlo", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}