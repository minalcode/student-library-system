
package com.example.student_library_system.controller;

import com.example.student_library_system.model.Book;
import com.example.student_library_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/apis")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/findById/{id}")
    public Book findBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/findAll")
    public List<Book> findAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }
}
