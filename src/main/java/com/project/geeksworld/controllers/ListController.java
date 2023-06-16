package com.project.geeksworld.controllers;

import com.project.geeksworld.models.ListEntity;
import com.project.geeksworld.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    ListRepository listRepository;

    @GetMapping
    public java.util.List<ListEntity> list(){
        return listRepository.findAll();
    }
    
    @GetMapping("/{listId}")
    public ListEntity getUser(@PathVariable Long listId) {
        return listRepository.findById(listId).orElse(null);
    }
    
    @PostMapping
    public ListEntity create (@RequestBody ListEntity list){
        return listRepository.save(list);
    }

    @PutMapping("/{listId}")
    public void update (@RequestBody ListEntity list){
        listRepository.save(list);
    }

    @DeleteMapping("/{listId}")
    public void delete (@PathVariable Long listId){
        listRepository.deleteById(listId);
    }
}
