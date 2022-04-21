package dev.ericksuarez.simple.api.controller;

import dev.ericksuarez.simple.api.model.Pokemon;
import dev.ericksuarez.simple.api.service.GreetingsService;
import dev.ericksuarez.simple.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PokemonController {
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon findPokemon(@PathVariable String id) {
        return this.pokemonService.findPokemon(id);
    }
}
