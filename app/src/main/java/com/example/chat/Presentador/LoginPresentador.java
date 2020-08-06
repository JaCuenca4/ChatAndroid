package com.example.chat.Presentador;

import com.example.chat.Interfaces.InterfacesLogin;
import com.example.chat.Modelo.ModeloLogin;

/**
 * The type Login presentador.
 */
public class LoginPresentador implements InterfacesLogin.Presentador {

    /**
     * The Vista.
     */
    InterfacesLogin.Vista vista;
    /**
     * The Modelo.
     */
    InterfacesLogin.Modelo modelo;

    /**
     * Instantiates a new Login presentador.
     *
     * @param vista the vista
     */
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
