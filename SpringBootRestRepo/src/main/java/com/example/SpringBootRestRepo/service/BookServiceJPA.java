package com.example.SpringBootRestRepo.service;

import com.example.SpringBootRestRepo.entity.Book;
import com.example.SpringBootRestRepo.repository.BookRepo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceJPA {

    @Autowired
    private BookRepo bookRepo;

    public long getTotalBookCount(){
        return bookRepo.count();
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book addNewBook(Book book){
        if(bookRepo.existsById(book.getBookid()))
            throw new EntityExistsException("Cannot add "+book.getBookid()+" already exists");
        return bookRepo.save(book);
    }
    public Book updateBook(Book book){
        if(!bookRepo.existsById(book.getBookid()))
            throw new EntityNotFoundException("cannot update "+book.getBookid()+" does not exist");
        return bookRepo.save(book);
    }
    public boolean deleteBook(int id){
        if(!bookRepo.existsById(id))
            throw new EntityNotFoundException("cannot delete "+id+" does not exist");
        bookRepo.deleteById(id);
        return true;
    }
    public List<Book> getBooksByAuthor(String author){
        return null;
    }
    public Book getBookById(int id){
        if(!bookRepo.existsById(id))
            throw new EntityNotFoundException(id+" not found");
        return bookRepo.findById(id).get();
    }
}
