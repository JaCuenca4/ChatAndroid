package com.example.chat.Clases;

/**
 * The type User.
 */
public class User    {
    private String id;
    private String username;
    private String imageURL;
    private String status;
    private String search;

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param username the username
     * @param imageURL the image url
     * @param status   the status
     * @param search   the search
     */
    public User(String id, String username, String imageURL, String status, String search){
       this.id=id;
       this.username=username;
       this.imageURL=imageURL;
       this.status = status;
       this.search = search;
   }

    /**
     * Instantiates a new User.
     */
    public User(){

   }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets image url.
     *
     * @param imageURL the image url
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets search.
     *
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets search.
     *
     * @param search the search
     */
    public void setSearch(String search) {
        this.search = search;
    }
}
