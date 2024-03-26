package com.springDBDemo.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class PokemonRepositoryImpl implements PokemonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void customInsertPokemon(String name, String type, int level) {
        PokemonModel newPokemon = new PokemonModel(name, type, level);
        this.entityManager.persist(newPokemon);
    }
}