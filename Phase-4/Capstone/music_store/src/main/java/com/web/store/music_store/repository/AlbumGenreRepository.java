package com.web.store.music_store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.store.music_store.model.AlbumGenre;

@Repository
public interface AlbumGenreRepository extends CrudRepository<AlbumGenre, Integer>{

}
