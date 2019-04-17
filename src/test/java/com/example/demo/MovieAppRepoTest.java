package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Movie;
import com.example.demo.domain.MovieRepository;
import com.example.demo.domain.Description;
import com.example.demo.domain.Genre;
import com.example.demo.domain.GenreRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieAppRepoTest {
	
	
	@Autowired
	private MovieRepository movierepo;
	
	@Autowired
	private GenreRepository genrerepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Test
	public void findMovieByNameTest() {
		List<Movie> movies = movierepo.findByName("Star wars: Episode IV - A New Hope");
		assertThat(movies).hasSize(1);
		assertThat(movies.get(0).getName()).isEqualTo("Star wars: Episode IV - A New Hope");
	}
	@Test
	public void findGenreByNameTest() {
		List<Genre> genres = genrerepo.findByName("Sci-fi");
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getName()).isEqualTo("Sci-fi");
	}
	@Test 
	public void findUserByUsername() {
		User user = userrepo.findByUsername("adminroni");
		assertThat(user.getUsername()).isEqualTo("adminroni");
	}
	@Test
	public void createMovieTest() {
		Movie movie = new Movie("Indiana Jones", 2010, new Genre("Horror"), new Description("new nerdy movie"));
		movierepo.save(movie);
		assertThat(movie.getId()).isNotNull(); 
	}
	@Test
	public void createGenreTest() {
		Genre genre = new Genre("Action");
		genrerepo.save(genre);
		assertThat(genre.getGenreid()).isNotNull();
	}
	@Test
	public void createUserTest() {
		User user = new User("uuskäyttäjä", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		userrepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	@Test
	public void deleteMovieTest() {
		List<Movie> movies = movierepo.findByName("Interstellar");
		movierepo.deleteAll(movies);
		assertThat(movierepo.findByName("Interstellas")).isEmpty();
	} 
}