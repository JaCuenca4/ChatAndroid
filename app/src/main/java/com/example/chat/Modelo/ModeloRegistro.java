package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Interfaces.InterfacesRegistro;

/**
 * The type Modelo registro.
 */
public class ModeloRegistro implements InterfacesRegistro.Modelo {

    /**
     * The Presentador.
     */
    InterfacesRegistro.Presentador presentador;
    /**
     * The Operador.
     */
    OperacionesFirebase operador;

    /**
     * Instantiates a new Modelo registro.
     *
     * @param presentador the presentador
     */
    public ModeloRegistro(InterfacesRegistro.Presentador presentador) {
        this.presentador = presentador;
        this.operador = new OperacionesFirebase(this);
    }

    @Override
    public void registrar(String username, String email, String password) {
        operador.registro(username, email, password);
    }

    @Override
    public void concederAcceso() {
        presentador.mostrarInicio();
    }
}
