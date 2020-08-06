package com.example.chat.Interfaces;

/**
 * The interface Interfaces registro.
 */
public interface InterfacesRegistro {

    /**
     * The interface Vista.
     */
    interface Vista{
        /**
         * Find element.
         */
        void findElement();

        /**
         * Desplegar inicio.
         */
        void desplegarInicio();
    }

    /**
     * The interface Presentador.
     */
    interface Presentador{
        /**
         * Solicitar registro.
         *
         * @param username the username
         * @param email    the email
         * @param password the password
         */
        void solicitarRegistro(String username, String email, String password);

        /**
         * Mostrar inicio.
         */
        void mostrarInicio();
    }

    /**
     * The interface Modelo.
     */
    interface Modelo{
        /**
         * Registrar.
         *
         * @param username the username
         * @param email    the email
         * @param password the password
         */
        void registrar(String username, String email, String password);

        /**
         * Conceder acceso.
         */
        void concederAcceso();
    }

}
