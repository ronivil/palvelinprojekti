package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Artisti;
import com.example.demo.domain.ArtistiRepository;
import com.example.demo.domain.Albumi;
import com.example.demo.domain.AlbumiRepository;

@SpringBootApplication
public class ArtistiApplication {

	private static final Logger log = LoggerFactory.getLogger(ArtistiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ArtistiApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(ArtistiRepository artistiRepository, AlbumiRepository albumiRepository) {
		return (args) -> {
			log.info("Save your favorite artists");
			albumiRepository.save(new Albumi("Iowa"));
			albumiRepository.save(new Albumi("All hope is gone"));
			
			artistiRepository.save(new Artisti("Bring me the horizon", 1243));
			artistiRepository.save(new Artisti("Slipknot", 1234));	
			
			log.info("Fetch all artists");
			for (Artisti artist : artistiRepository.findAll()) {
				log.info(artist.toString());
			}
		};
	}
}
