package com.project.geeksworld.controllers;

import com.project.geeksworld.models.CharacterEntity;
import com.project.geeksworld.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping
    public List<CharacterEntity> list() {
        return characterRepository.findAll();
    }
    
    @GetMapping("/{characterId}")
    public CharacterEntity getUser(@PathVariable Long characterId) {
        return characterRepository.findById(characterId).orElse(null);
    }

    @PostMapping
    public CharacterEntity create(@RequestBody CharacterEntity character) {
        return characterRepository.save(character);
    }

    @PutMapping("/{characterId}")
    public void update (@RequestBody CharacterEntity character){
    	characterRepository.save(character);
    }

    @DeleteMapping("/{characterId}")
    public ResponseEntity<Void> delete(@PathVariable Long characterId) {
        Optional<CharacterEntity> characterOptional = characterRepository.findById(characterId);
        if (characterOptional.isPresent()) {
            characterRepository.delete(characterOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
