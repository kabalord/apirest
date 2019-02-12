package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")

public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

//  7 - Ajout d'un album

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public Album createAlbum(@RequestBody Album album){
        return albumRepository.save(album);
    }


// 8 - Suppression d'un album

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable Long id){
        albumRepository.delete(id);
    }

}
