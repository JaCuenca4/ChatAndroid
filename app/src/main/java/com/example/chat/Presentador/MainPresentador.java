package com.example.chat.Presentador;

import com.example.chat.Clases.User;
import com.example.chat.Interfaces.InterfacesMain;
import com.example.chat.Modelo.ModeloMain;

public class MainPresentador implements InterfacesMain.Presentador {

    InterfacesMain.Vista vista;
    InterfacesMain.Modelo modelo;

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
