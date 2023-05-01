package com.example.itgirlsbooksaithor.services.interfaces;

import com.example.itgirlsbooksaithor.models.Book;
import com.example.itgirlsbooksaithor.models.dto.BookCreateDto;
import com.example.itgirlsbooksaithor.models.dto.BookDto;
import com.example.itgirlsbooksaithor.models.dto.BookUpdateDto;

import java.util.List;

public interface BookService {

    BookDto getBookById(Long id);

    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    List<BookDto> getAllBooks();

    BookDto createBook(BookCreateDto bookCreateDto);

    BookDto updateBook(BookUpdateDto bookUpdateDto);

    void deleteBook (Long id);

}
