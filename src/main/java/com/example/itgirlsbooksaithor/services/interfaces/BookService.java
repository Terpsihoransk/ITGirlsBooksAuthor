package com.example.itgirlsbooksaithor.services.interfaces;

import com.example.itgirlsbooksaithor.models.Book;
import com.example.itgirlsbooksaithor.models.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    List<BookDto> getAllBooks();

}
