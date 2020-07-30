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
    public void solicitarRegistro(String username, String email, String password) {
       modelo.registrar(username, email, password);
    }

    @Override
    public void mostrarInicio() {
        vista.desplegarInicio();
    }
}
