package com.example.chat.Presentador;

import com.example.chat.Clases.User;
import com.example.chat.Interfaces.InterfacesMain;
import com.example.chat.Modelo.ModeloMain;

/**
 * The type Main presentador.
 */
public class MainPresentador implements InterfacesMain.Presentador {

    /**
     * The Vista.
     */
    InterfacesMain.Vista vista;
    /**
     * The Modelo.
     */
    InterfacesMain.Modelo modelo;

    /**
     * Instantiates a new Main presentador.
     *
     * @param vista the vista
     */
    public MainPresentador(InterfacesMain.Vista vista){
        this.vista = vista;
        this.modelo = new ModeloMain( this );
    }

    @Override
    public void solicitarUsuario() {
        modelo.obtenerUsuario();
    }

    @Override
    public void desplegarUsuario(User user) {
        vista.mostrarUsuario(user);
    }

    @Override
    public void solicitarCerrarSesion() {
        modelo.cerraSesion();
    }

    @Override
    public void concederCerrarSesion() {
        vista.cerrar();
    }
}
