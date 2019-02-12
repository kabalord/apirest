package com.myaudiolibrary.apirest.repository;

import com.myaudiolibrary.apirest.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {


}
