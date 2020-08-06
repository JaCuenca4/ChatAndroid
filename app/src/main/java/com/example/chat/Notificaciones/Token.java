package com.example.chat.Notificaciones;

/**
 * The type Token.
 */
public class Token {
    private String token;

    /**
     * Instantiates a new Token.
     *
     * @param token the token
     */
    public Token(String token){
        this.token = token;
    }

    /**
     * Instantiates a new Token.
     */
    public Token(){

    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
