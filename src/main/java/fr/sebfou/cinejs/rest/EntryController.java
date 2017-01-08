package fr.sebfou.cinejs.rest;

import fr.sebfou.cinejs.assembler.EntryResourceAssembler;
import fr.sebfou.cinejs.dto.EntryDTO;
import fr.sebfou.cinejs.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
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
@RequestMapping("/api/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private EntryResourceAssembler entryResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResources<EntryDTO>> findAll(@PageableDefault(20) @SortDefault(direction = Sort.Direction.ASC, sort = "viewDate") Pageable pageRequest, PagedResourcesAssembler assembler) {
        Page<EntryDTO> entries = entryService.findAll(pageRequest);
        PagedResources<EntryDTO> entriesResource = assembler.toResource(entries, entryResourceAssembler);
        return ResponseEntity.ok(entriesResource);
    }
}
