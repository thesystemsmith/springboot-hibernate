package com.springDBDemo.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PokemonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pokemon_name")
    private String name;

    private String type;
    private int level;

    PokemonModel() {
        // Default constructor
    }

    PokemonModel(String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    // Getters and setters for id, name, type, level
}
