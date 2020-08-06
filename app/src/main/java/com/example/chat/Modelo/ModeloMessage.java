package com.example.chat.Modelo;

import com.example.chat.Clases.Chat;
import com.example.chat.Clases.OperacionesFirebase;
import com.example.chat.Clases.User;
import com.example.chat.Interfaces.InterfacesMessage;

import java.util.List;

/**
 * The type Modelo message.
 */
public class ModeloMessage implements InterfacesMessage.Modelo{

    /**
     * The Presentador.
     */
    InterfacesMessage.Presentador presentador;
    /**
     * The Operador.
     */
    OperacionesFirebase operador;

    /**
     * Instantiates a new Modelo message.
     *
     * @param presentador the presentador
     */
    public ModeloMessage(InterfacesMessage.Presentador presentador){
        this.presentador = presentador;
        this.operador = new OperacionesFirebase(this);
    }

    @Override
    public void enviarUserId(String userid) {
        operador.cargarChat(userid);
    }

    @Override
    public void mostrarChat(User user) {
        presentador.mostrarChat(user);
    }

    @Override
    public void solicitarEnvioMensaje(String userid, String msg) {
        operador.sendMessage(userid, msg);
    }

    @Override
    public void solicitarMensajes( String userid, String imageurl) {
        operador.readMessages(userid, imageurl);
    }

    @Override
    public void enviarMensajes(List<Chat> chat, String imageurl) {
        presentador.enviarMensajes(chat, imageurl);
    }
}
