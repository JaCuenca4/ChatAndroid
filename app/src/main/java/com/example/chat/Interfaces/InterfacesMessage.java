package com.example.chat.Interfaces;

import com.example.chat.Clases.Chat;
import com.example.chat.Clases.User;

import java.util.List;

/**
 * The interface Interfaces message.
 */
public interface InterfacesMessage {
    /**
     * The interface Vista.
     */
    interface Vista{
        /**
         * Findelement.
         */
        void findelement();

        /**
         * Desplegar chat.
         *
         * @param user the user
         */
        void desplegarChat(User user);

        /**
         * Mostrar mensajes.
         *
         * @param chats    the chats
         * @param imageurl the imageurl
         */
        void mostrarMensajes(List<Chat> chats, String imageurl);
    }

    /**
     * The interface Presentador.
     */
    interface Presentador{
        /**
         * Enviar user id.
         *
         * @param userid the userid
         */
        void enviarUserId(String userid);

        /**
         * Mostrar chat.
         *
         * @param user the user
         */
        void mostrarChat(User user);

        /**
         * Enviar mensaje.
         *
         * @param userid the userid
         * @param msg    the msg
         */
        void enviarMensaje(String userid, String msg);

        /**
         * Obtener mensajes.
         *
         * @param userid   the userid
         * @param imageurl the imageurl
         */
        void obtenerMensajes( String userid, String imageurl);

        /**
         * Enviar mensajes.
         *
         * @param chats    the chats
         * @param imageurl the imageurl
         */
        void enviarMensajes(List<Chat> chats,String imageurl);

    }

    /**
     * The interface Modelo.
     */
    interface Modelo{
        /**
         * Enviar user id.
         *
         * @param userid the userid
         */
        void enviarUserId(String userid);

        /**
         * Mostrar chat.
         *
         * @param user the user
         */
        void mostrarChat(User user);

        /**
         * Solicitar envio mensaje.
         *
         * @param userid the userid
         * @param msg    the msg
         */
        void solicitarEnvioMensaje(String userid, String msg);

        /**
         * Solicitar mensajes.
         *
         * @param userid   the userid
         * @param imageurl the imageurl
         */
        void solicitarMensajes(String userid, String imageurl);

        /**
         * Enviar mensajes.
         *
         * @param chats    the chats
         * @param imageurl the imageurl
         */
        void enviarMensajes(List<Chat> chats, String imageurl);
    }
}
