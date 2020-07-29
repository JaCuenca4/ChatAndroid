package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Interfaces.InterfacesRegistro;

public class ModeloRegistro implements InterfacesRegistro.Modelo {

    InterfacesRegistro.Presentador presentador;
    OperacionesFirebase operador;

    public ModeloRegistro(InterfacesRegistro.Presentador presentador) {
        this.presentador = presentador;
        this.operador = new OperacionesFirebase();
    }

    @Override
    public boolean Registrar(String username, String email, String password) {
        return operador.registro(username, email, password);
    }
}
