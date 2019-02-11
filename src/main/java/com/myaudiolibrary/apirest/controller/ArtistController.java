package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import com.myaudiolibrary.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

// 1 - Afficher un artiste
// Prèmiere manière de faire une exception dans le delete artiste

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Artist findById (@PathVariable("id") Long id) throws EntityExistsException {
        Artist a = artistRepository.findById(id);
        if (a == null){
            throw new EntityNotFoundException("L'artist d'identifiant " + id + " n'a pas été trouvé");
        }
        return a;
    }
// 2 - Recherche par nom

    @RequestMapping(value = "", params = {"name","page", "size", "sortProperty", "sortDirection"})
    public Page<Artist> findArtistByName(@RequestParam String name,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size,
                                         @RequestParam String sortProperty,
                                         @RequestParam String sortDirection ){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artistRepository.findArtistByNameContaining(name, pageRequest);
    }


// 3 - Liste des artistes
    @RequestMapping("")
    public Page<Artist> findAllPaging(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortProperty") String sortProperty,
            @RequestParam("sortDirection") String sortDirection){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artistRepository.findAll(pageRequest);
    }

// 4 - Création d'un artiste

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"

    )
    public Artist createArtist(
            @RequestBody Artist artist){
        return artistRepository.save(artist);
    }

// 5 - Modification d'un artiste

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json",
            value = "/{id}"
    )
    public Artist modifyArtist(
            @PathVariable("id") Long id,
            @RequestBody Artist artist){
        return artistRepository.save(artist);
    }



}

















