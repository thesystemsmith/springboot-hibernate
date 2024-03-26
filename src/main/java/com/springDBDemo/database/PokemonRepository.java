package com.springDBDemo.database;

import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository {

    void customInsertPokemon(String name, String type, int level);
    PokemonModel findPokemonByID(int id);
}
