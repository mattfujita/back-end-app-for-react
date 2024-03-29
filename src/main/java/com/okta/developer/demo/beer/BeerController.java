package com.okta.developer.demo.beer;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {
	
	private BeerRepository repository;
	
	public BeerController(BeerRepository repository)
	{
		this.repository = repository;
	}
	
	@GetMapping("/good-beers")
	public Collection<Beer> goodBeers()
	{
		return repository.findAll().stream()
				.filter(this::isGreat)
				.collect(Collectors.toList());
	}
	
	private boolean isGreat(Beer beer)
	{
		return !beer.getName().equals("PBR") &&
				!beer.getName().equals("Coors Light") &&
				!beer.getName().equals("Budweiser");
	}

}
