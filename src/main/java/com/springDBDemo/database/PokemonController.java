package com.springDBDemo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }
    
    @PostMapping("/insertPokemon")
    public String insertPokemon(@RequestBody String name, @RequestBody String type, @RequestBody int level){
        pokemonRepository.customInsertPokemon(name, type, level);
        return "new pokemon added";
    }

    @GetMapping("/getPokemon")
    public String getPokemon(@RequestParam int id) {
        return pokemonRepository.findPokemonByID(id).toString();
    }

    @GetMapping("/updatePokemonName")
    public String updatePokemonName(@RequestParam int id, @RequestParam String newName) {
        pokemonRepository.updatePokemonName(id, newName);
        return "Pokemon name updated";
    }

    @GetMapping("/deletePokemon")
    public String deletePokemonById(@RequestParam int id) {
        pokemonRepository.deletePokemonById(id);
        return "Pokemon deleted";
    }
}
