package com.example.chat.Interfaces;

import com.example.chat.Clases.Chat;
import com.example.chat.Clases.User;

import java.util.List;

public interface InterfacesMessage {
    interface Vista{
        void findelement();
        void desplegarChat(User user);
        void mostrarMensajes(List<Chat> chats, String imageurl);
    }

    interface Presentador{
        void enviarUserId(String userid);
        void mostrarChat(User user);
        void enviarMensaje(String userid, String msg);
        void obtenerMensajes( String userid, String imageurl);
        void enviarMensajes(List<Chat> chats,String imageurl);

    }

    interface Modelo{
        void enviarUserId(String userid);
        void mostrarChat(User user);
        void solicitarEnvioMensaje(String userid, String msg);
        void solicitarMensajes(String userid, String imageurl);
        void enviarMensajes(List<Chat> chats, String imageurl);
    }
}
