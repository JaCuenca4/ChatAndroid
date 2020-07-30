package com.example.chat.Presentador;

import com.example.chat.Interfaces.InterfacesLogin;
import com.example.chat.Modelo.ModeloLogin;

public class LoginPresentador implements InterfacesLogin.Presentador {

    InterfacesLogin.Vista vista;
    InterfacesLogin.Modelo modelo;

    public LoginPresentador(InterfacesLogin.Vista vista) {
        this.vista = vista;
        modelo = new ModeloLogin(this);
    }

    @Override
    public void solicitarLogin(String email, String password) {
       modelo.login(email,password);
    }

    @Override
    public void mostrarInicio() {
        vista.desplegarInicio();
    }
}
