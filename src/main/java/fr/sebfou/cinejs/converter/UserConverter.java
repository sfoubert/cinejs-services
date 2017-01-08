package fr.sebfou.cinejs.converter;

import fr.sebfou.cinejs.model.User;
import fr.sebfou.cinejs.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by seb_f on 31/12/2016.
 */
@Component
public class UserConverter implements Converter<ObjectId, User> {

    @Autowired
    private UserRepository userRepository;

    public User convert(ObjectId objectId) {
        return new User();
    }
}
