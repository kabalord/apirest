package com.myaudiolibrary.apirest.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)



    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;



    public Album(){

    }

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }




}
