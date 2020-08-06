package com.example.chat.Presentador;

import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Modelo.ModeloRegistro;

/**
 * The type Registro presentador.
 */
public class RegistroPresentador implements InterfacesRegistro.Presentador {

    /**
     * The Vista.
     */
    InterfacesRegistro.Vista vista;
    /**
     * The Modelo.
     */
    InterfacesRegistro.Modelo modelo;

    /**
     * Instantiates a new Registro presentador.
     *
     * @param vista the vista
     */
    public RegistroPresentador(InterfacesRegistro.Vista vista) {
        this.vista = vista;
        this.modelo = new ModeloRegistro(this);
    }

    @Override
    public void solicitarRegistro(String username, String email, String password) {
       modelo.registrar(username, email, password);
    }

    @Override
    public void mostrarInicio() {
        vista.desplegarInicio();
    }
}
