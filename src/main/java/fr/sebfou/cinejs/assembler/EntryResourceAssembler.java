package fr.sebfou.cinejs.assembler;

import fr.sebfou.cinejs.dto.EntryDTO;
import fr.sebfou.cinejs.rest.EntryController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by seb_f on 01/01/2017.
 */
@Component
public class EntryResourceAssembler extends ResourceAssemblerSupport<EntryDTO, Resource> {

    public EntryResourceAssembler() {
        super(EntryController.class, Resource.class);
    }

    @Override
    public Resource toResource(EntryDTO entry) {
        return new Resource<EntryDTO>(entry, linkTo(EntryController.class).slash(entry.getId()).withSelfRel());
    }

    @Override
    public List<Resource> toResources(Iterable<? extends EntryDTO> entries) {
        List<Resource> resources = new ArrayList<Resource>();
        for(EntryDTO entry : entries) {
            resources.add(new Resource<EntryDTO>(entry, linkTo(EntryController.class).slash(entry.getId()).withSelfRel()));
        }
        return resources;
    }

}
