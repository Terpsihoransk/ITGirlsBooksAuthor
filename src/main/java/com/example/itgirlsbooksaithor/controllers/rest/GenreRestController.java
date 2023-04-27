package com.example.itgirlsbooksaithor.controllers.rest;

import com.example.itgirlsbooksaithor.models.dto.GenreDto;
import com.example.itgirlsbooksaithor.services.interfaces.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GenreRestController {

    private final GenreService genreService;

    @GetMapping("/genre")
    GenreDto getGenreByName(@RequestParam(value = "name", required = false) String name) {
        return genreService.getByName(name);
    }
}
