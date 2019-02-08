package com.myaudiolibrary.apirest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@RequestMapping("/albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)



    private Long id;

    private String title;

    private long ArtistId;

    public Album(){

    }

    public Album(String title, long artistId) {
        this.title = title;
        this.ArtistId = artistId;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public Long getArtistId() {

        return ArtistId;
    }

    public void setArtistId(long artistId) {

        ArtistId = artistId;
    }
}
