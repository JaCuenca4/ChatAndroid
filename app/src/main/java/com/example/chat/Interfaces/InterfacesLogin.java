package com.example.chat.Interfaces;

public interface InterfacesLogin {

    interface Vista{
        void findElement();
        void desplegarInicio();
    }

    interface Presentador{
        void solicitarLogin(String email, String password);
        void mostrarInicio();
    }

    interface Modelo{
        void login(String email, String password);
        void concederAcceso();
    }
}
