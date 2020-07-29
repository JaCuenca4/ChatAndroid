package com.example.chat.Interfaces;

public interface InterfacesRegistro {

    interface Vista{
        void findElement();
    }

    interface Presentador{
        boolean solicitarRegistro(String username, String email, String password);
    }

    interface Modelo{
        boolean Registrar(String username, String email, String password);
    }

}
