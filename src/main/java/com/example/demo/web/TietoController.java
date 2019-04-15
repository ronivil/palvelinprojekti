package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Movie;
import com.example.demo.domain.GenreRepository;
import com.example.demo.domain.MovieRepository;

@Controller
public class TietoController {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	//login
	@RequestMapping(value="/login")
	   public String login() {	
	       return "login";
	   }	
	
	//listaus
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getMovies(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "listaus";
	}
	// RESTful service to get all movies
    @RequestMapping(value="/restmovies")
    public @ResponseBody List<Movie> movieListRest() {	
        return (List<Movie>) movieRepository.findAll();
    }    

	// RESTful service to get movies by id
    @RequestMapping(value="/movie/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {	
    	return movieRepository.findById(movieId);
    }       
    
    // Add new movie
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addMovie(Model model){
    	model.addAttribute("movie", new Movie());
    	model.addAttribute("genres", genreRepository.findAll());
        return "addmovie";
    }     
    
    // Save new movie
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Movie movie){
        movieRepository.save(movie);
        return "redirect:movies";
    }    

    // Delete movie
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
    	movieRepository.deleteById(movieId);
        return "redirect:../movies";
    }     
}