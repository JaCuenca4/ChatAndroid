package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Interfaces.InterfacesStart;

/**
 * The type Modelo start.
 */
public class ModeloStart implements InterfacesStart.Modelo {

    /**
     * The Presentador.
     */
    InterfacesStart.Presentador presentador;
    /**
     * The Operador.
     */
    OperacionesFirebase operador;

    /**
     * Instantiates a new Modelo start.
     *
     * @param presentador the presentador
     */
    public ModeloStart(InterfacesStart.Presentador presentador) {
        this.presentador = presentador;
        this.operador = new OperacionesFirebase(this);
    }

    @Override
    public void consultarSesion() {
        operador.verificarSesion();
    }

    @Override
    public void concederInicio() {
        presentador.concederInicio();
    }
}
