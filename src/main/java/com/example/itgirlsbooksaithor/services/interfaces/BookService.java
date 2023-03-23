package com.example.itgirlsbooksaithor.services.interfaces;

import com.example.itgirlsbooksaithor.models.dto.BookDto;

public interface BookService {

    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

}
