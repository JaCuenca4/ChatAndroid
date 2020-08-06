package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Clases.User;
import com.example.chat.Interfaces.InterfacesMain;

/**
 * The type Modelo main.
 */
public class ModeloMain implements InterfacesMain.Modelo {

    /**
     * The Presentador.
     */
    InterfacesMain.Presentador presentador;
    /**
     * The Operador.
     */
    OperacionesFirebase operador;

    /**
     * Instantiates a new Modelo main.
     *
     * @param presentador the presentador
     */
    public ModeloMain(InterfacesMain.Presentador presentador){
        this.presentador = presentador;
        operador = new OperacionesFirebase(this);
    }

    @Override
    public void obtenerUsuario() {
        operador.obtenerUsuario();
    }

    @Override
    public void enviarUsuario(User user) {
        presentador.desplegarUsuario(user);
    }

    @Override
    public void cerraSesion() {
        operador.cerrarSesion();
    }

    @Override
    public void permitirCerrarSesion() {
        presentador.concederCerrarSesion();
    }
}
