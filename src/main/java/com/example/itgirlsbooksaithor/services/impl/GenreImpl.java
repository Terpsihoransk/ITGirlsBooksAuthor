package com.example.itgirlsbooksaithor.services.impl;

import com.example.itgirlsbooksaithor.models.Genre;
import com.example.itgirlsbooksaithor.models.dto.GenreDto;
import com.example.itgirlsbooksaithor.repositories.GenreRepository;
import com.example.itgirlsbooksaithor.services.interfaces.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GenreImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDto getByName(String name) {
       Genre genre = genreRepository.findGenreByName(name).orElseThrow();
       return convertEntityToDto(genre);
    }

    private GenreDto convertEntityToDto(Genre genre) {
        return GenreDto.builder()
                .name(genre.getName())
                .id(genre.getId())
                .build();
    }
}
