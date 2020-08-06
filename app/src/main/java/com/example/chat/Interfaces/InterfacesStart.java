package com.example.chat.Interfaces;

public interface InterfacesStart {
    interface Vista{
        void findElement();
        void verificarSesion();
        void desplegarInicio();
    }

    interface Presentador{
        void verificarSesion();
        void concederInicio();
    }

    interface Modelo{
        void consultarSesion();
        void concederInicio();
    }
}
