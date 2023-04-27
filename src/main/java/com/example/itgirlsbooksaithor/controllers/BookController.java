package com.example.itgirlsbooksaithor.controllers;

import com.example.itgirlsbooksaithor.models.dto.BookDto;
import com.example.itgirlsbooksaithor.services.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    String getBooksView(Model model) {
        List<BookDto> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
