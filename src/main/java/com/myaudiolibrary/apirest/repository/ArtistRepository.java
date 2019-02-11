package com.myaudiolibrary.apirest.repository;


import com.myaudiolibrary.apirest.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, Long> {

    Artist findById(Long id);

    Page<Artist> findArtistByNameContaining(String name, Pageable pageable);

    Artist findArtistByName(String name);

}
