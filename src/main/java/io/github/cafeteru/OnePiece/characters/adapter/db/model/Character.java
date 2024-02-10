package io.github.cafeteru.OnePiece.characters.adapter.db.model;

import jakarta.persistence.*;

@Entity
@Table
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
}