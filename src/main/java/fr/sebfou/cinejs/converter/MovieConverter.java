package fr.sebfou.cinejs.converter;

import fr.sebfou.cinejs.model.Movie;
import fr.sebfou.cinejs.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by seb_f on 31/12/2016.
 */
@Component
public class MovieConverter implements Converter<ObjectId, Movie> {

    @Autowired
    private MovieRepository movieRepository;

    public Movie convert(ObjectId objectId) {
        return new Movie();
    }
}
