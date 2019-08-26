package com.rickywong.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickywong.lookify.models.Song;
import com.rickywong.lookify.repositories.LookifyRepository;
import com.rickywong.lookify.repositories.SearchRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookRepo;
	private final SearchRepository sRepo;
	
	public LookifyService(LookifyRepository lookRepo, SearchRepository sRepo) {
		this.lookRepo = lookRepo;
		this.sRepo = sRepo;
	}

	
	public List<Song> allSongs(){
		return lookRepo.findAll();
	}
	public Song createSong(Song song) {
		return lookRepo.save(song);
	}
	public void deleteSong(Long id) {
		lookRepo.deleteById(id);
	}
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	public List<Song> searchSongs(String artist) {
		return sRepo.findByArtist(artist);
	}

}
