package com.project.geeksworld.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "lists")
public class ListEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;
    private String name;

    @ManyToOne
    @JoinColumn (name="userId")
    @JsonIgnore
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "list_character",
            joinColumns = @JoinColumn(name = "listId"),
            inverseJoinColumns = @JoinColumn(name = "characterId")
    )
    @JsonIgnore
    private List<CharacterEntity> characterList;
}