package fr.sebfou.cinejs.repository;

import fr.sebfou.cinejs.model.Entry;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by seb_f on 30/12/2016.
 */
public interface EntryRepository extends PagingAndSortingRepository<Entry, ObjectId> {

}
