package fr.sebfou.cinejs.repository;

import fr.sebfou.cinejs.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by seb_f on 30/12/2016.
 */
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
}
