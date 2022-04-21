package dev.ericksuarez.simple.api.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
    public String greetings() {
        return "Hello, world!";
    }
}
