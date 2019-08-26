package com.rickywong.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rickywong.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtist(String artist);
}
