package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Interfaces.InterfacesLogin;

public class ModeloLogin implements InterfacesLogin.Modelo {

    InterfacesLogin.Presentador presentador;
    OperacionesFirebase operador;

    public ModeloLogin(InterfacesLogin.Presentador presentador) {
        this.presentador = presentador;
        this.operador = new OperacionesFirebase(this);
    }

    @Override
    public void login(String email, String password) {
        operador.login(email,password);
    }

    @Override
    public void concederAcceso() {
        presentador.mostrarInicio();
    }
}
