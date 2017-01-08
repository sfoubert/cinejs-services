package fr.sebfou.cinejs.rest;

import fr.sebfou.cinejs.assembler.UserResourceAssembler;
import fr.sebfou.cinejs.model.User;
import fr.sebfou.cinejs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by seb_f on 30/12/2016.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResourceAssembler userResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResources<User>> findAll(@PageableDefault(20) Pageable pageRequest, PagedResourcesAssembler assembler) {
        Page<User> users = userRepository.findAll(pageRequest);
        PagedResources<User> usersResource = assembler.toResource(users, userResourceAssembler);
        return ResponseEntity.ok(usersResource);
    }
}
