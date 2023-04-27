package com.example.itgirlsbooksaithor.services.interfaces;

import com.example.itgirlsbooksaithor.models.dto.AuthorCreateDto;
import com.example.itgirlsbooksaithor.models.dto.AuthorDto;
import com.example.itgirlsbooksaithor.models.dto.AuthorUpdateDto;

public interface AuthorService {

    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByName(String name);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);

    AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto);

    void deleteAuthor(Long id);

}
