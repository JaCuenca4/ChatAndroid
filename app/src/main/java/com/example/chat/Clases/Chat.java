package com.example.chat.Clases;

/**
 * The type Chat.
 */
public class Chat {
    private String sender;
    private String receiver;
    private String message;
    private boolean isseen;

    /**
     * Instantiates a new Chat.
     *
     * @param sender   the sender
     * @param receiver the receiver
     * @param message  the message
     * @param isseen   the isseen
     */
    public Chat(String sender, String receiver, String message, boolean isseen) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isseen = isseen;
    }

    /**
     * Instantiates a new Chat.
     */
    public Chat() {
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Sets receiver.
     *
     * @param receiver the receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Is isseen boolean.
     *
     * @return the boolean
     */
    public boolean isIsseen() {
        return isseen;
    }

    /**
     * Sets isseen.
     *
     * @param isseen the isseen
     */
    public void setIsseen(boolean isseen) {
        this.isseen = isseen;
    }
}
