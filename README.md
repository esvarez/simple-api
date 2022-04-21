# Java simple API

Simple API that consumes the [Pokémon api](https://pokeapi.co/) just to show th name and Pokédex id.

## How run

To run the API you need Java 11 and gradle.

In the root of the project run the gradlew file `./gradlew bootRun`

## Endpoints

| Name         | Method | url                                            | Description                                                                                                                       |
|--------------|--------|------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| hello_world  | GET    | http://localhost:8080/api                      | Show the "Hello, World!" Message to verify the api is working                                                                     |
| find_pokemon | GET    | http://localhost:8080/api/pokemon/{pokemon_id} | Find a pokemon by name or id (pokédex number), if the pokemon exist return the name and pokédex number, if not return a 404 error |
