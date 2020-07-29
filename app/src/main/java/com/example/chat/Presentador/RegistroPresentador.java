package com.example.chat.Presentador;

import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Modelo.ModeloRegistro;

public class RegistroPresentador implements InterfacesRegistro.Presentador {

    InterfacesRegistro.Vista vista;
    InterfacesRegistro.Modelo modelo;

    public RegistroPresentador(InterfacesRegistro.Vista vista) {
        this.vista = vista;
        this.modelo = new ModeloRegistro(this);
    }

    @Override
    public boolean solicitarRegistro(String username, String email, String password) {
       return modelo.Registrar(username, email, password);
    }
}
