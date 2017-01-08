package fr.sebfou.cinejs.assembler;

import fr.sebfou.cinejs.model.User;
import fr.sebfou.cinejs.rest.UserController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by seb_f on 08/01/2017.
 */
@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, Resource> {

    public UserResourceAssembler() {
        super(UserController.class, Resource.class);
    }

    @Override
    public Resource toResource(User user) {
        return new Resource<User>(user, linkTo(UserController.class).slash(user.getId()).withSelfRel());
    }
}
