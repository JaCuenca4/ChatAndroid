package com.example.chat.Interfaces;

public interface InterfacesRegistro {

    interface Vista{
        void findElement();
        void desplegarInicio();
    }

    interface Presentador{
        void solicitarRegistro(String username, String email, String password);
        void mostrarInicio();
    }

    interface Modelo{
        void registrar(String username, String email, String password);
        void concederAcceso();
    }

}