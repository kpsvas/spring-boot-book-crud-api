package com.javatpoint.service;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService
{
    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks()
    {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    public Books getBooksById(int id)
    {
        return booksRepository.findById(id).get();
    }
    public Books updateBook(Books books, int id)
    {
        Books booksDb= booksRepository.findById(id).get();
        booksDb.setBookName(books.getBookName());
        booksDb.setAuthor(books.getAuthor());
        booksDb.setPrice(books.getPrice());
        booksRepository.save(booksDb);
        return booksDb;
    }

    public int deleteBook(int id)
    {
        booksRepository.deleteById(id);
        return 1;
    }
    public Books saveBook(Books books)
    {
       booksRepository.save(books);
       return books;
    }
}