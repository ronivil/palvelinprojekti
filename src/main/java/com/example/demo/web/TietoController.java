package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Artisti;
import com.example.demo.domain.AlbumiRepository;
import com.example.demo.domain.ArtistiRepository;

@Controller
public class TietoController {
	@Autowired
	ArtistiRepository artistiRepository;
	
	@Autowired
	AlbumiRepository albumiRepository;
	
	//listaus
	@RequestMapping(value = "/artistit", method = RequestMethod.GET)
	public String getArtistit(Model model) {
		model.addAttribute("books", artistiRepository.findAll());
		return "listaus";
	}
}