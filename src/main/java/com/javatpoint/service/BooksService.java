package com.javatpoint.service;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface BooksService {

    public List<Books> getAllBooks();

    public Books getBooksById(int id);

    public Books saveBook(Books books);

    public int deleteBook(int id);

    public Books updateBook(Books books, int bookid);
}