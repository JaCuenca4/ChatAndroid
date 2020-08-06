package com.example.chat.Interfaces;

import com.example.chat.Clases.User;

/**
 * The interface Interfaces main.
 */
public interface InterfacesMain {

    /**
     * The interface Vista.
     */
    interface Vista{
        /**
         * Find element.
         */
        void findElement();

        /**
         * Mostrar usuario.
         *
         * @param user the user
         */
        void mostrarUsuario(User user);

        /**
         * Solicitar usuario.
         */
        void solicitarUsuario();

        /**
         * Cerrar.
         */
        void cerrar();
    }

    /**
     * The interface Presentador.
     */
    interface  Presentador{
        /**
         * Solicitar usuario.
         */
        void solicitarUsuario();

        /**
         * Desplegar usuario.
         *
         * @param user the user
         */
        void desplegarUsuario(User user);

        /**
         * Solicitar cerrar sesion.
         */
        void solicitarCerrarSesion();

        /**
         * Conceder cerrar sesion.
         */
        void concederCerrarSesion();
    }

    /**
     * The interface Modelo.
     */
    interface Modelo{
        /**
         * Obtener usuario.
         */
        void obtenerUsuario();

        /**
         * Enviar usuario.
         *
         * @param user the user
         */
        void enviarUsuario(User user);

        /**
         * Cerra sesion.
         */
        void cerraSesion();

        /**
         * Permitir cerrar sesion.
         */
        void permitirCerrarSesion();
    }
}
