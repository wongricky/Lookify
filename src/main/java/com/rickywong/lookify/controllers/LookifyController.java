package com.rickywong.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rickywong.lookify.models.Song;
import com.rickywong.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookService;
	
	public LookifyController(LookifyService lookService) {
		this.lookService = lookService;
	}
	
	//Mappings
	@RequestMapping("/") 
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard") // dashboard - main page
	public String dashboard(Model model) {
	List<Song> songs = lookService.allSongs();
	model.addAttribute("songs", songs);
	return "dashboard.jsp";
	}
	@RequestMapping("/songs/new") // new song page
	 public String newBook(@ModelAttribute("song") Song song) {
	     return "songs/new.jsp";
	}
	@RequestMapping(value="/dashboard", method=RequestMethod.POST) // new song POST method
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		}
		else {
			lookService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}") // find song show page
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = lookService.findSong(id);
		model.addAttribute("song", song);
		return "songs/show.jsp";
	}
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE) // delete song
	public String destroy(@PathVariable("id") Long id) {
		lookService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/search") // search 
	public String search(@ModelAttribute("artist") Song artist) {
		return "/search.jsp";
	}
	
	@RequestMapping(value="/search/{artist}", method=RequestMethod.POST) // search for songs
	public String search(@PathVariable("artist") @RequestBody String artist) {
		lookService.searchSongs(artist);
		return "/search.jsp";
	}
//	@RequestMapping(value = "/search/{artist}")
//	public String search(@PathVariable("artist") String artist, Model model) {
//
//	    if(artist != null){
//	        Object searchResult = lookService.searchSongs(artist);
//	        model.addAttribute("searchResult", searchResult);  
//	    }
//	    return "/search.jsp";
//	}
	
}
