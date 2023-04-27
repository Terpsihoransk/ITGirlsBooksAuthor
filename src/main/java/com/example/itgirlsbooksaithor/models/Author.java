package com.example.itgirlsbooksaithor.models;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

}
