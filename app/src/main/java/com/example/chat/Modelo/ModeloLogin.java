package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Interfaces.InterfacesLogin;

/**
 * The type Modelo login.
 */
public class ModeloLogin implements InterfacesLogin.Modelo {

    /**
     * The Presentador.
     */
    InterfacesLogin.Presentador presentador;
    /**
     * The Operador.
     */
    OperacionesFirebase operador;

    /**
     * Instantiates a new Modelo login.
     *
     * @param presentador the presentador
     */
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
