package dev.ericksuarez.simple.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PokemonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findPokemon_success() throws Exception {
        mockMvc.perform(get("/api/pokemon/{idPokemon}", "charmander"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("charmander")))
                .andExpect(jsonPath("$.id", is("4")));
    }

    @Test
    public void findPokemon_fail_return404() throws Exception {
        mockMvc.perform(get("/api/pokemon/{idPokemon}", "rojo"))
                .andExpect(status().isNotFound());
    }
}
