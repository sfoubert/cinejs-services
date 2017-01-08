package fr.sebfou.cinejs.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * Created by seb_f on 30/12/2016.
 */
public class Movie {

    @Id
    private ObjectId id;

    private String title;
    private Set<String> categories;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
