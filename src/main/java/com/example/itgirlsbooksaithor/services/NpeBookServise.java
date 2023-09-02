package com.example.itgirlsbooksaithor.services;

import com.example.itgirlsbooksaithor.models.Book;
import com.example.itgirlsbooksaithor.models.Genre;
import com.example.itgirlsbooksaithor.repositories.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class NpeBookServise {

    private BookRepository bookRepository;

    void getGenre() {
        Optional<Book> book = bookRepository.findById(1L);


       Genre genre = book.get().getGenre();
       Long genreId = genre != null ? genre.getId() : 0L;

       Long genreId2 = Optional.of(book.get().getGenre())
               .map(Genre::getId)
               .orElse(0L);

       Long genreId3;
       try {
           genreId3 = book.get().getGenre().getId();
       } catch (NullPointerException e) {
           genreId3 = 10L;
       }
    }
}
