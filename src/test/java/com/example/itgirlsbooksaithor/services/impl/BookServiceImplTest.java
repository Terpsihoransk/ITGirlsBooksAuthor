package com.example.itgirlsbooksaithor.services.impl;

import com.example.itgirlsbooksaithor.models.Book;
import com.example.itgirlsbooksaithor.models.Genre;
import com.example.itgirlsbooksaithor.models.dto.BookCreateDto;
import com.example.itgirlsbooksaithor.models.dto.BookDto;
import com.example.itgirlsbooksaithor.repositories.BookRepository;
import com.example.itgirlsbooksaithor.repositories.GenreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookServiceImpl bookService;

    @Test
    void createBook() {
        BookCreateDto bookCreateDto = new BookCreateDto();
        bookCreateDto.setName("test");
        bookCreateDto.setGenreId(2L);

        BookDto bookDto = bookService.createBook(bookCreateDto);

        assertNotNull(bookDto.getId()); // проверяем, что книга была сохранена

        // получаем книгу из БД
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow(() -> new RuntimeException("Книга не найдена"));

        // проверяем, что книга была сохранена с правильными данными
        assertEquals(bookCreateDto.getGenreId(), book.getGenre().getId());
    }
}