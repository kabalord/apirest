package com.myaudiolibrary.apirest.repository;


import com.myaudiolibrary.apirest.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findById(Long id);

    Page<Artist> findArtistByNameContaining(String name, Pageable pageable);

    Artist findArtistByName(String name);

}