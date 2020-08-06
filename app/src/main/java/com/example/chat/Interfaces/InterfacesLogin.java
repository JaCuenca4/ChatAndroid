package com.example.chat.Interfaces;

/**
 * The interface Interfaces login.
 */
public interface InterfacesLogin {

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
         * Solicitar login.
         *
         * @param email    the email
         * @param password the password
         */
        void solicitarLogin(String email, String password);

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
         * Login.
         *
         * @param email    the email
         * @param password the password
         */
        void login(String email, String password);

        /**
         * Conceder acceso.
         */
        void concederAcceso();
    }
}
