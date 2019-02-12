package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
