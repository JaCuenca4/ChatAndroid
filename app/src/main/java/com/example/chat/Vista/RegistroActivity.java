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

/**
 * The type Registro activity.
 */
public class RegistroActivity extends AppCompatActivity implements InterfacesRegistro.Vista, View.OnClickListener {

    /**
     * The Username.
     */
//Variables
    MaterialEditText username, /**
     * The Email.
     */
    email, /**
     * The Password.
     */
    password;
    /**
     * The Btn registrar.
     */
    Button btn_registrar;
    /**
     * The Presentador.
     */
    RegistroPresentador presentador;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        presentador = new RegistroPresentador(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findElement();
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
    public void desplegarInicio() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_registrar:
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
                }else{
                    presentador.solicitarRegistro(username.getText().toString(), email.getText().toString(), password.getText().toString());
                }
        }
    }
}