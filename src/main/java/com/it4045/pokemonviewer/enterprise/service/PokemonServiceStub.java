package com.it4045.pokemonviewer.enterprise.service;

import com.it4045.pokemonviewer.enterprise.dto.Pokedex;
import com.it4045.pokemonviewer.enterprise.dto.Pokemon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonServiceStub implements IPokemonService{

    private final Pokemon pokemon = new Pokemon();
    private final Pokedex pokedex = new Pokedex();

    /**
     * Currently used in unit tests
     */
    @Override
    public Pokemon fetchByName(String pokemonName) {
        pokemon.setPokemonName("Charizard");
        pokemon.setPokemonId(1);
        return pokemon;
    }

    /**
     * Will be used once Pokemon API is called/connected
     */
    @Override
    public List<Pokemon> fetchAllPokemon() {
        return pokedex.getAllPokemon();
    }
}
