package com.example.chat.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chat.Interfaces.InterfacesLogin;
import com.example.chat.Presentador.LoginPresentador;
import com.example.chat.Presentador.RegistroPresentador;
import com.example.chat.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.w3c.dom.Text;

/**
 * The type Login activity.
 */
public class LoginActivity extends AppCompatActivity implements InterfacesLogin.Vista, View.OnClickListener {

    /**
     * The Email.
     */
    MaterialEditText email, /**
     * The Password.
     */
    password;
    /**
     * The Btn login.
     */
    Button btn_login;
    /**
     * The Presentador.
     */
    LoginPresentador presentador;
    /**
     * The Forgot password.
     */
    TextView forgot_password;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presentador = new LoginPresentador(this);

        findElement();
    }

    @Override
    public void findElement() {
        email = findViewById(R.id.correoLogin);
        password = findViewById(R.id.passwordLogin);
        btn_login = findViewById(R.id.btn_ingresar);
        btn_login.setOnClickListener(this);
        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(this);
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
            case R.id.btn_ingresar:
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
                }else{
                    presentador.solicitarLogin(email.getText().toString(), password.getText().toString());
                }
                break;
            case R.id.forgot_password:
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
        }
    }
}