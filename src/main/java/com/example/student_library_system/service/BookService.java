package com.example.student_library_system.service;

import com.example.student_library_system.model.Book;
import com.example.student_library_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // Save Book
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "Book saved successfully";
    }

    // Find Book By Id
    public Book getBookById(int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            throw new RuntimeException("Book not found with id : " + id);
        }
    }

    // Find All Books
    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    // Update Book
    public String updateBook(int id, Book newBook) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(newBook.getTitle());
        existingBook.setPublisherName(newBook.getPublisherName());
        existingBook.setPublishedDate(newBook.getPublishedDate());
        existingBook.setPages(newBook.getPages());
        existingBook.setAvailability(newBook.isAvailability());
        existingBook.setCategory(newBook.getCategory());
        existingBook.setRackNo(newBook.getRackNo());

        bookRepository.save(existingBook);

        return "Book updated successfully";
    }

    // Delete Book
    public String deleteBookById(int id) {
        Book book = getBookById(id);
        bookRepository.delete(book);

        return "Book with id " + id + " is deleted successfully!";
    }
}