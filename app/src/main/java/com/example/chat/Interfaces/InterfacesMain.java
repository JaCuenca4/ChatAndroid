package com.example.chat.Interfaces;

import com.example.chat.Clases.User;

public interface InterfacesMain {

    interface Vista{
        void findElement();
        void mostrarUsuario(User user);
        void solicitarUsuario();
        void cerrar();
    }

    interface  Presentador{
        void solicitarUsuario();
        void desplegarUsuario(User user);
        void solicitarCerrarSesion();
        void concederCerrarSesion();
    }

    interface Modelo{
        void obtenerUsuario();
        void enviarUsuario(User user);
        void cerraSesion();
        void permitirCerrarSesion();
    }
}
