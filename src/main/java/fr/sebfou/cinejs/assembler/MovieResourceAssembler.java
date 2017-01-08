package fr.sebfou.cinejs.assembler;

import fr.sebfou.cinejs.model.Movie;
import fr.sebfou.cinejs.rest.MovieController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by seb_f on 08/01/2017.
 */
@Component
public class MovieResourceAssembler extends ResourceAssemblerSupport<Movie, Resource> {

    public MovieResourceAssembler() {
        super(MovieController.class, Resource.class);
    }

    @Override
    public Resource toResource(Movie movie) {
        return new Resource<Movie>(movie, linkTo(MovieController.class).slash(movie.getId()).withSelfRel());
    }
}
