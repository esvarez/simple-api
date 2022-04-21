package dev.ericksuarez.simple.api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetingsServiceTest {
    private GreetingsService greetingsService;

    @BeforeEach
    public void setUp(){
        this.greetingsService = new GreetingsService();
    }

    @Test
    public void greetings_success() {
        assertEquals("Hello, World!", this.greetingsService.greetings());
    }
}
