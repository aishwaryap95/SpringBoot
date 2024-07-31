package com.example.SpringBootRestRepo.rest;

import com.example.SpringBootRestRepo.entity.Book;
import com.example.SpringBootRestRepo.service.BookService;
import com.example.SpringBootRestRepo.utility.AppConstants;
import com.example.SpringBootRestRepo.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    /*
    * 1. Display all books
    * 2. get book by id
    * 3. getBookById that doesnt exist(handle exception)
    *
    * 4. get book by author ( http://localhost:8090/books?author=hotsmann )
    *
    * */

    /*
    @GetMapping
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }
    */

    /*
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.getBookById(id) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    //  @RequestParam, which extracts query parameters from the request URL.
    //  For example, /books?author=someAuthor.

    // @PathVariable, which extracts values directly from the URI path.
    // For example, /books/someAuthor.

    // Below code, the author parameter is required by default,
    // so Spring will not set it to null if it is missing.
    // Instead, it will throw an error or ignore the method.

    /*
    @GetMapping
    public List<Book> getBooks(@RequestParam String author){
        if(author == null)
            return bookService.getAllBooks();
        return bookService.getBooksByAuthor(author);
    }
    */

    // All books: http://localhost:8090/books
    // Books by author: http://localhost:8090/books?author=Kelly
    @GetMapping
    public List<Book> getBooks(@RequestParam( required = false) String author){
        if(author == null)
            return bookService.getAllBooks();
        return bookService.getBooksByAuthor(author);
    }

    // http://localhost:8090/books/hotsmann       below code works
    // If you have other @GetMapping methods with similar paths, such as /books/{id},
    // Spring may get confused about which method to call. Ensure there are no conflicting paths.

    /*
    @GetMapping("/{author}")
    public ResponseEntity<Object> getBookByAuthor(@PathVariable String author){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.getBooksByAuthor(author) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }
    */

    // http://localhost:8090/books
    // Add content-Type   AS  application/json
    // Add book details in raw format in Body > run POST
    // Except id, each field is null
    // Therefore add @RequestBody
    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.addNewBook(book) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateBook(@RequestBody Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.updateBook(book) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }


    public BookRestController() {
        System.out.println("Book Rest Controller default constructor");
    }
}
