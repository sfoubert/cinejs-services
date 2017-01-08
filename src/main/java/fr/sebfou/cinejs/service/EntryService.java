package fr.sebfou.cinejs.service;

import fr.sebfou.cinejs.dto.EntryDTO;
import fr.sebfou.cinejs.model.Entry;
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
import java.util.List;

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
        entries.forEach(e -> {
            EntryDTO entryDTO = new EntryDTO();
            entryDTO.setId(e.getId());
            entryDTO.setViewDate(e.getViewDate());
            entryDTO.setMovie(movieRepository.findOne(new ObjectId(e.getMovieId())));
            entryDTO.setUser(userRepository.findOne(new ObjectId(e.getUserId())));
            entryDTOs.add(entryDTO);
        });

        return new PageImpl<EntryDTO>(entryDTOs, pageable, entries.getTotalElements());
    }
}
