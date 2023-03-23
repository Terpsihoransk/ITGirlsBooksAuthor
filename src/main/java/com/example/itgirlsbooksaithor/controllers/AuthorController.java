package com.example.itgirlsbooksaithor.controllers;

import com.example.itgirlsbooksaithor.models.dto.AuthorDto;
import com.example.itgirlsbooksaithor.services.interfaces.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorByName(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName(name);
    }

}
