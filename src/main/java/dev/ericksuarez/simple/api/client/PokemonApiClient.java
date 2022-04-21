package dev.ericksuarez.simple.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ericksuarez.simple.api.error.NotFoundException;
import dev.ericksuarez.simple.api.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Component
public class PokemonApiClient extends HttpClientBase {
    private String path;
    private String findPokemon;

    @Autowired
    public PokemonApiClient(
            @Value("${application.pokemonApi.path}") String path,
            @Value("${application.pokemonApi.findPokemon}") String findPokemon,
            HttpClient httpClient,
            ObjectMapper objectMapper) {
        super(httpClient, objectMapper);
        this.path = path;
        this.findPokemon = findPokemon;
    }

    public Pokemon findPokemonByID(String id) {
        var pokemon = findByUrl(URI.create(path + findPokemon + "/" + id), Pokemon.class);
        System.out.println(pokemon);
        return pokemon;
    }

    private <T> T findByUrl(URI url, Class<T> tClass) {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(url)
                .header("Content-Type", "application/json")
                .build();
        return makeRequest(request, tClass);
    }
}
