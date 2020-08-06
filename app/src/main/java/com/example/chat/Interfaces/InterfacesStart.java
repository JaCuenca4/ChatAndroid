package com.example.chat.Interfaces;

/**
 * The interface Interfaces start.
 */
public interface InterfacesStart {
    /**
     * The interface Vista.
     */
    interface Vista{
        /**
         * Find element.
         */
        void findElement();

        /**
         * Verificar sesion.
         */
        void verificarSesion();

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
         * Verificar sesion.
         */
        void verificarSesion();

        /**
         * Conceder inicio.
         */
        void concederInicio();
    }

    /**
     * The interface Modelo.
     */
    interface Modelo{
        /**
         * Consultar sesion.
         */
        void consultarSesion();

        /**
         * Conceder inicio.
         */
        void concederInicio();
    }
}
