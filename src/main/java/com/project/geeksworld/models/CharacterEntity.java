package com.project.geeksworld.models;

import lombok.*;

import jakarta.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "characters")
public class CharacterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;
    private String name;
    private File photo;
    private String about;
 
}
