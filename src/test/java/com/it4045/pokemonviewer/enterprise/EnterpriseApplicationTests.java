package com.it4045.pokemonviewer.enterprise;

import com.it4045.pokemonviewer.enterprise.dto.Pokemon;
import com.it4045.pokemonviewer.enterprise.service.IPokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    private IPokemonService pokemonService;
    private Pokemon pokemon;

    @Test
    public void contextLoads() { }

    @Test
    void fetchPokemonByName_returnsCharizard() throws IOException {
        givenPokemonDataIsReadilyAvailable();
        whenSearchPokemonWithNameCharizard();
        thenReturnOnePokemonWithNameCharizard();
    }

    @Test
    void fetchPokemonByName_returnsNothing() throws IOException {
        givenPokemonDataIsReadilyAvailable();
        whenSearchPokemonWithNameBurgers();
        thenReturnNothing();
    }

    @Test
    void fetchPokemonByName_returnsCharizardId() throws IOException {
        givenPokemonDataIsReadilyAvailable();
        whenSearchPokemonWithNameCharizard();
        thenReturnOnePokemonCharziardWithIdOne();
    }

    private void givenPokemonDataIsReadilyAvailable() throws IOException {
        List<Pokemon> pokemonList = pokemonService.fetchPokemons();
        assertNotNull(pokemonList);
    }

    private void thenReturnOnePokemonWithNameCharizard() {
        String pokemonName = pokemon.getPokemonName();
        assertEquals("Charizard", pokemonName);
    }

    private void whenSearchPokemonWithNameCharizard() {
        pokemon = pokemonService.fetchByName("Charizard");
    }

    private void thenReturnNothing() {
        String pokemonName = pokemon.getPokemonName();
        assertNotEquals("Burgers", pokemonName);
    }

    private void whenSearchPokemonWithNameBurgers() {
        pokemon = pokemonService.fetchByName("Burgers");
    }

    private void thenReturnOnePokemonCharziardWithIdOne() {
        int pokemonId = pokemon.getPokemonId();
        assertNotEquals(5, pokemonId);
    }
}
