package com.example.chat.Presentador;

import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Interfaces.InterfacesStart;
import com.example.chat.Modelo.ModeloRegistro;
import com.example.chat.Modelo.ModeloStart;

/**
 * The type Start presentador.
 */
public class StartPresentador implements InterfacesStart.Presentador {

    /**
     * The Vista.
     */
    InterfacesStart.Vista vista;
    /**
     * The Modelo.
     */
    InterfacesStart.Modelo modelo;

    /**
     * Instantiates a new Start presentador.
     *
     * @param vista the vista
     */
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
