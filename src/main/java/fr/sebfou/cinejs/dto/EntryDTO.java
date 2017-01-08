package fr.sebfou.cinejs.dto;

import fr.sebfou.cinejs.model.Movie;
import fr.sebfou.cinejs.model.User;

import java.util.Date;

/**
 * Created by seb_f on 31/12/2016.
 */
public class EntryDTO {

    private String id;
    private User user;
    private Movie movie;
    private Date viewDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }
}
