package com.example.itgirlsbooksaithor.controllers;

import com.example.itgirlsbooksaithor.models.dto.BookDto;
import com.example.itgirlsbooksaithor.services.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    BookDto getBookByNameV1(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV1(name);
    }

    @GetMapping("/book/v2")
    BookDto getBookByNameV2(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV2(name);
    }


}
