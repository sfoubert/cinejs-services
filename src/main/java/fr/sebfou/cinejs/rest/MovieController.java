package fr.sebfou.cinejs.rest;

import fr.sebfou.cinejs.assembler.MovieResourceAssembler;
import fr.sebfou.cinejs.model.Movie;
import fr.sebfou.cinejs.repository.MovieRepository;
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
 * Created by seb_f on 31/12/2016.
 */
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieResourceAssembler movieResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResources<Movie>> findAll(@PageableDefault(20) Pageable pageRequest, PagedResourcesAssembler assembler) {
        Page<Movie> movies = movieRepository.findAll(pageRequest);
        PagedResources<Movie> moviesResource = assembler.toResource(movies, movieResourceAssembler);
        return ResponseEntity.ok(moviesResource);
    }
}
