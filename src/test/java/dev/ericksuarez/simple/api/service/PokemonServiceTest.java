package dev.ericksuarez.simple.api.service;

import dev.ericksuarez.simple.api.client.PokemonApiClient;
import dev.ericksuarez.simple.api.error.NotFoundException;
import dev.ericksuarez.simple.api.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @Mock
    private PokemonApiClient pokemonApiClient;

    private PokemonService pokemonService;

    @BeforeEach
    public void setUp() {
        this.pokemonService = new PokemonService(pokemonApiClient);
    }

    @Test
    public void findPokemon_success_returnPokemon() {
        when(pokemonApiClient.findPokemonByID(anyString()))
                .thenReturn(Pokemon.builder()
                        .name("bulbasaur")
                        .id("1")
                        .build());
        var pokemon = pokemonService.findPokemon("bulbasaur");
        assertNotNull(pokemon);
    }
}
