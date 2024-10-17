package com.itschool.library.controllers;

import com.itschool.library.models.dtos.ResponseBookDTO;
import com.itschool.library.models.entities.Book;
import com.itschool.library.services.BookService;
import com.itschool.library.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final BookService bookService;

    public CustomerController(CustomerService customerService, BookService bookService) {
        this.customerService = customerService;
        this.bookService = bookService;
    }

    @Operation(summary = "Get all filtered books by title, author and genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the books",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "Books not found",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<List<ResponseBookDTO>> getBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "genre", required = false) String genre) {
        return ResponseEntity.ok(bookService.getBooks(title, author, genre));
    }
}