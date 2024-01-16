package com.javatpoint.controller;
import java.util.List;

import com.javatpoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.javatpoint.model.Books;

@RestController
@RequestMapping("/api/v1")
public class BooksController
{
    @Autowired
    BooksService booksService;

    @GetMapping("/book")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    private ResponseEntity<Books> getBooks(@PathVariable("id") int bookid)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        Books book = booksService.getBooksById(bookid);
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    private ResponseEntity<String> deleteBook(@PathVariable("id") int bookid)
    {
        try {
            int count= booksService.deleteBook(bookid);
            if(count == 1) {
                return new ResponseEntity<>("Deleted record successfully", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Deleted record Not Found", HttpStatus.NOT_FOUND);
            }
        }catch(Exception ex) {
            return new ResponseEntity<>("Deleted record failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/books")
    private Books saveBook(@RequestBody Books books)
    {
        booksService.saveBook(books);
        return books;
    }
    @PutMapping("/books/{id}")
    private Books updateBook(@PathVariable("id") int bookid, @RequestBody Books books)
    {
        booksService.updateBook(books, bookid);
        return books;
    }
}
