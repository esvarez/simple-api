package dev.ericksuarez.simple.api.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ericksuarez.simple.api.error.NotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = {
        "application.pokemonApi.path=testValue",
        "application.pokemonApi.findPokemon=test"
})
public class PokemonApiClientTest {
    private PokemonApiClient pokemonApiClient;

    @BeforeEach
    public void setUp() {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        var objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.pokemonApiClient = new PokemonApiClient("https://pokeapi.co/api/v2","/pokemon", httpClient, objectMapper);
    }

    @Test
    public void findPokemonByID_returnPokemon() {
        final var pokemon = this.pokemonApiClient.findPokemonByID("charmander");
        System.out.println(pokemon);
        assertNotNull(pokemon);
    }

    @Test
    public void findPokemonByID_pokemonNoExist_throwException() {
        final var thrown = assertThrows(NotFoundException.class,
                () -> pokemonApiClient.findPokemonByID("agumon"));
        assertTrue(thrown.getMessage().contains("Resource not found"));
    }
}
