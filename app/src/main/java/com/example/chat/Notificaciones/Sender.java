package com.example.chat.Notificaciones;

/**
 * The type Sender.
 */
public class Sender {
    /**
     * The Data.
     */
    public Data data;
    /**
     * The To.
     */
    public String to;

    /**
     * Instantiates a new Sender.
     *
     * @param data the data
     * @param to   the to
     */
    public Sender(Data data, String to) {
        this.data = data;
        this.to = to;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }
}
