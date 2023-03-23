package com.example.itgirlsbooksaithor.services.interfaces;

import com.example.itgirlsbooksaithor.models.dto.AuthorDto;

public interface AuthorService {

    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByName(String name);

}
