package fr.sebfou.cinejs.repository;

import fr.sebfou.cinejs.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by seb_f on 30/12/2016.
 */
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
