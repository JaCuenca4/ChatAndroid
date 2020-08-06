package com.example.chat.Presentador;

import com.example.chat.Clases.Chat;
import com.example.chat.Clases.User;
import com.example.chat.Interfaces.InterfacesMessage;
import com.example.chat.Modelo.ModeloMessage;

import java.util.List;

/**
 * The type Message presentador.
 */
public class MessagePresentador implements InterfacesMessage.Presentador{

    /**
     * The Vista.
     */
    InterfacesMessage.Vista vista;
    /**
     * The Modelo.
     */
    InterfacesMessage.Modelo modelo;

    /**
     * Instantiates a new Message presentador.
     *
     * @param vista the vista
     */
    public MessagePresentador(InterfacesMessage.Vista vista){
        this.vista = vista;
        modelo = new ModeloMessage(this);
    }

    @Override
    public void enviarUserId(String userid) {
        modelo.enviarUserId(userid);
    }

    @Override
    public void mostrarChat(User user) {
        vista.desplegarChat(user);
    }

    @Override
    public void enviarMensaje(String userid, String msg) {
        modelo.solicitarEnvioMensaje(userid, msg);
    }

    @Override
    public void obtenerMensajes(String userid, String imageurl) {
        modelo.solicitarMensajes(userid, imageurl);
    }

    @Override
    public void enviarMensajes(List<Chat> chats, String imageurl) {
        vista.mostrarMensajes(chats, imageurl);
    }
}
