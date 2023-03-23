package com.example.itgirlsbooksaithor.repositories;

import com.example.itgirlsbooksaithor.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(nativeQuery = true, value = "SELECT * from genre where name = ?")
    Optional<Genre> findGenreByName(String name);
}
