package com.example.itgirlsbooksaithor.services.impl;

import com.example.itgirlsbooksaithor.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void getByNameV1() {
    }

    @Test
    void getByNameV2() {
    }

    @Test
    void getAllBooks() {
    }
}