package com.example.itgirlsbooksaithor.services.impl;

import com.example.itgirlsbooksaithor.models.Author;
import com.example.itgirlsbooksaithor.models.Book;
import com.example.itgirlsbooksaithor.models.dto.AuthorDto;
import com.example.itgirlsbooksaithor.repositories.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void testGetAuthorById() {
        Long id = 1L;
        String name = "Jon";
        String surname = "Doe";
        Set<Book> books = new HashSet<>();

        Author author = new Author(id, name, surname, books);

        when(authorRepository.findById(id)).thenReturn(Optional.of(author));

        AuthorDto authorDto = authorService.getAuthorById(id); // вызываем метод, который тестируем
        verify(authorRepository).findById(id); // проверяем как отрабатывает метод

        Assertions.assertEquals(authorDto.getId(), author.getId()); // проверим равны ли объекты
        Assertions.assertEquals(authorDto.getName(), author.getName());
        Assertions.assertEquals(authorDto.getSurname(), author.getSurname());
    }

    @Test
    public void testGetAuthorByIdFailed() {
        Long id = 1L;

        when(authorRepository.findById(id)).thenReturn(Optional.empty()); // проверка 2 кейса, когда автора нет

        Assertions.assertThrows(IllegalStateException.class, () -> authorService.getAuthorById(id)); // что должно произойти, что приведет к ошибке
        verify(authorRepository).findById(id); // проверим, что был вызван метод репозитория
    }
}