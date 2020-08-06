package com.example.chat.Presentador;

import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Interfaces.InterfacesStart;
import com.example.chat.Modelo.ModeloRegistro;
import com.example.chat.Modelo.ModeloStart;

public class StartPresentador implements InterfacesStart.Presentador {

    InterfacesStart.Vista vista;
    InterfacesStart.Modelo modelo;

    public StartPresentador(InterfacesStart.Vista vista) {
        this.vista = vista;
        this.modelo = new ModeloStart(this);
    }

    @Override
    public void verificarSesion() {
        modelo.consultarSesion();
    }

    @Override
    public void concederInicio() {
        vista.desplegarInicio();
    }
}
