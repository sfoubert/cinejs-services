package fr.sebfou.cinejs.service;

import fr.sebfou.cinejs.dto.EntryDTO;
import fr.sebfou.cinejs.model.Entry;
import fr.sebfou.cinejs.model.Movie;
import fr.sebfou.cinejs.model.User;
import fr.sebfou.cinejs.repository.EntryRepository;
import fr.sebfou.cinejs.repository.MovieRepository;
import fr.sebfou.cinejs.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by seb_f on 31/12/2016.
 */
@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public Page<EntryDTO> findAll(Pageable pageable) {
        List<EntryDTO> entryDTOs = new ArrayList<>();

        Page<Entry> entries = entryRepository.findAll(pageable);

        Collection<ObjectId> movieIds = entries.map(e -> new ObjectId(e.getMovieId())).getContent();
        Collection<ObjectId> userIds = entries.map(e -> new ObjectId(e.getUserId())).getContent();

        Iterable<Movie> movies = movieRepository.findAll(movieIds);
        Iterable<User> users = userRepository.findAll(userIds);

        Map<ObjectId, Movie> mapMovies = StreamSupport.stream(movies.spliterator(), false)
                .collect(Collectors.toMap(m -> m.getId(), m -> m));

        Map<ObjectId, User> mapUsers = StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toMap(u -> u.getId(), u -> u));

        entries.forEach(e -> {
            EntryDTO entryDTO = new EntryDTO();
            entryDTO.setId(e.getId());
            entryDTO.setViewDate(e.getViewDate());
            entryDTO.setMovie(mapMovies.get(new ObjectId(e.getMovieId())));
            entryDTO.setUser(mapUsers.get(new ObjectId(e.getUserId())));
            entryDTOs.add(entryDTO);
        });

        return new PageImpl<EntryDTO>(entryDTOs, pageable, entries.getTotalElements());
    }
}
