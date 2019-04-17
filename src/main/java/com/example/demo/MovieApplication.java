package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Movie;
import com.example.demo.domain.MovieRepository;
import com.example.demo.domain.DesRepository;
import com.example.demo.domain.Description;
import com.example.demo.domain.Genre;
import com.example.demo.domain.GenreRepository;
import com.example.demo.domain.UserRepository;
import com.example.demo.domain.User;

@SpringBootApplication
public class MovieApplication {

	private static final Logger log = LoggerFactory.getLogger(MovieApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(MovieRepository movieRepository, GenreRepository genreRepository, UserRepository userRepository, DesRepository desRepository) {
		return (args) -> {
			log.info("Save your favorite movies");
			genreRepository.save(new Genre("Sci-fi"));
			genreRepository.save(new Genre("Horror"));
			genreRepository.save(new Genre("Thriller"));
			genreRepository.save(new Genre("Drama"));
			
			desRepository.save(new Description("nerd movie"));
			
			movieRepository.save(new Movie("Star wars: Episode IV - A New Hope", 1977, genreRepository.findByName("Sci-fi").get(0), desRepository.findByName("nerd movie").get(0)));
			movieRepository.save(new Movie("Star wars: Episode V - The Empire Strikes Back", 1980, genreRepository.findByName("Sci-fi").get(0), desRepository.findByName("nerd movie").get(0)));	
			movieRepository.save(new Movie("Star wars: Episode VI - Return of the jedi", 1983, genreRepository.findByName("Sci-fi").get(0), desRepository.findByName("nerd movie").get(0)));	
			movieRepository.save(new Movie("Interstellar", 2016, genreRepository.findByName("Sci-fi").get(0), desRepository.findByName("nerd movie").get(0)));	
			
			User user1 = new User("roni", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("adminroni", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("Fetch all movies");
			for (Movie movie : movieRepository.findAll()) {
				log.info(movie.toString());
			}
		};
	}
}
