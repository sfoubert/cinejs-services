package fr.sebfou.cinejs.model;

import java.util.Date;

/**
 * Created by seb_f on 30/12/2016.
 */
public class Audit {

    private Date createdOn;
    private Date lastLogin;

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
