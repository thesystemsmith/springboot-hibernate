package com.springDBDemo.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

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

    public PokemonModel findPokemonByID(int id) {
        return entityManager.find(PokemonModel.class, id);
    }

    // query based on sorted level
    public List<PokemonModel> findAllPokemonSorted() {
        TypedQuery<PokemonModel> query = entityManager.createQuery("From PokemonModel order by level",
                    PokemonModel.class);
        return query.getResultList();
    }

    // query based on name
    public PokemonModel findPokemonByName(String name) {
        TypedQuery<PokemonModel> query = entityManager.createQuery("From PokemonModel where name=:n",
                PokemonModel.class);
        query.setParameter("n", name);
        return query.getSingleResult();
    }

    @Transactional
    public void updatePokemonName(int id, String newName){
        PokemonModel pokemon = entityManager.find(PokemonModel.class, id);
        if(pokemon != null) {
            pokemon.setName(newName); //implement this setter in the model
            entityManager.merge(pokemon);
        }
    }

    @Transactional
    public void deletePokemonById(int id) {
        PokemonModel pokemon = entityManager.find(PokemonModel.class, id);
        if(pokemon != null){
            entityManager.remove(pokemon);
        }
    }
}