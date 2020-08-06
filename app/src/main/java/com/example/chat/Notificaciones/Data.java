package com.example.chat.Notificaciones;

/**
 * The type Data.
 */
public class Data {

    private String user;
    private int icon;
    private String body;
    private String title;
    private String sented;

    /**
     * Instantiates a new Data.
     *
     * @param user   the user
     * @param icon   the icon
     * @param body   the body
     * @param title  the title
     * @param sented the sented
     */
    public Data(String user, int icon, String body, String title, String sented) {
        this.user = user;
        this.icon = icon;
        this.body = body;
        this.title = title;
        this.sented = sented;
    }

    /**
     * Instantiates a new Data.
     */
    public Data() {
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public int getIcon() {
        return icon;
    }

    /**
     * Sets icon.
     *
     * @param icon the icon
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets sented.
     *
     * @return the sented
     */
    public String getSented() {
        return sented;
    }

    /**
     * Sets sented.
     *
     * @param sented the sented
     */
    public void setSented(String sented) {
        this.sented = sented;
    }
}
