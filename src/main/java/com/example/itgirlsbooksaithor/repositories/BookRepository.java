package com.example.itgirlsbooksaithor.repositories;

import com.example.itgirlsbooksaithor.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByName(String name);

    @Query(nativeQuery = true, value = "SELECT * from book where name = ?")
    Optional<Book> findBookByNameBySql(String name);
}
