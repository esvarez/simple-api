package dev.ericksuarez.simple.api.service;

import dev.ericksuarez.simple.api.client.PokemonApiClient;
import dev.ericksuarez.simple.api.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private PokemonApiClient pokemonApiClient;

    @Autowired
    public PokemonService(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }

    public Pokemon findPokemon(String idPokemon) {
        return this.pokemonApiClient.findPokemonByID(idPokemon);
    }
}
