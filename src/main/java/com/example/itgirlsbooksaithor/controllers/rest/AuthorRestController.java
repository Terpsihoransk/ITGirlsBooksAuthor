package com.example.itgirlsbooksaithor.controllers.rest;

import com.example.itgirlsbooksaithor.models.dto.AuthorCreateDto;
import com.example.itgirlsbooksaithor.models.dto.AuthorDto;
import com.example.itgirlsbooksaithor.models.dto.AuthorUpdateDto;
import com.example.itgirlsbooksaithor.services.interfaces.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorByName(@RequestParam(value = "name", required = false) String name) {
        return authorService.getAuthorByName(name);
    }

    @PostMapping("/author/create")
    AuthorDto createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
        return authorService.createAuthor(authorCreateDto);
    }

    @PutMapping("/author/update")
    AuthorDto updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto) {
        return authorService.updateAuthor(authorUpdateDto);
    }

    @DeleteMapping("/author/delete/{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
