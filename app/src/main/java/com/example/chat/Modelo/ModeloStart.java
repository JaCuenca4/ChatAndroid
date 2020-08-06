package com.example.chat.Modelo;

import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Interfaces.InterfacesStart;

public class ModeloStart implements InterfacesStart.Modelo {

    InterfacesStart.Presentador presentador;
    OperacionesFirebase operador;

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
