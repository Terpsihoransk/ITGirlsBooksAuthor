package com.example.itgirlsbooksaithor.services.impl;

import com.example.itgirlsbooksaithor.models.Book;
import com.example.itgirlsbooksaithor.models.Genre;
import com.example.itgirlsbooksaithor.models.dto.BookCreateDto;
import com.example.itgirlsbooksaithor.models.dto.BookDto;
import com.example.itgirlsbooksaithor.models.dto.BookUpdateDto;
import com.example.itgirlsbooksaithor.repositories.BookRepository;
import com.example.itgirlsbooksaithor.repositories.GenreRepository;
import com.example.itgirlsbooksaithor.services.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public Optional<Long> getGenreId() {
        Long genreId = null;
        return Optional.ofNullable(genreId);
    }

    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            BookDto bookDto = convertEntityToDto(book.get());
            return bookDto;
        } else {
            throw new IllegalStateException("Книга не найдена");
        }
    }

    @Override
    public BookDto getByNameV1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV2(String name) {
        Book book = bookRepository.findBookByNameBySql(name).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        Genre genre = genreRepository.findById(bookCreateDto.getGenreId()).orElseThrow(() -> new RuntimeException("Жанр не найден")); // получили жанр из БД
        Book book = new Book();
        book.setName(bookCreateDto.getName());
        book.setGenre(genre);
        bookRepository.save(book);
        BookDto bookDto = convertEntityToDto(book);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        Book book = bookRepository.findById(bookUpdateDto.getId()).orElseThrow();
        book.setName(bookUpdateDto.getName());
        Genre genre = genreRepository.findById(bookUpdateDto.getGenreId()).orElseThrow(() -> new RuntimeException("Жанр не найден"));
        book.setGenre(genre);
        Book saveBook = bookRepository.save(book);
        BookDto bookDto = convertEntityToDto(saveBook);
        return bookDto;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDto convertEntityToDto(Book book) {
        return BookDto.builder()
                .name(book.getName())
                .genre(book.getGenre().getName())
                .id(book.getId())
                .build();
    }

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        return Book.builder()
                .name(bookCreateDto.getName())
                .build();
    }
}
