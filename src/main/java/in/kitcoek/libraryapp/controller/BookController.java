package in.kitcoek.libraryapp.controller;

import in.kitcoek.libraryapp.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    static List<Book> books = new ArrayList<>();

    @PostMapping
    public boolean insertBook(@RequestBody Book book) {
        books.add(book);
        return true;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable int isbn) {
        for(int i=0; i<books.size(); i++) {
            if(books.get(i).getIsbn() == isbn) {
                return books.get(i);
            }
        }
        return null;
    }
    @PutMapping("/{isbn}")
    public boolean updateBook(@PathVariable int isbn, @RequestBody Book book) {
        for(int i=0; i<books.size(); i++) {
            if(books.get(i).getIsbn() == isbn) {
                books.set(i, book);
            }
        }
        return true;
    }
    @DeleteMapping("/deleteAll")
    public boolean deleteAllBooks() {
        books.clear();
        return true;
    }
    @DeleteMapping("/delete/{isbn}")
    public boolean deleteByIsbn(@PathVariable int isbn) {
        for(int i=0; i<books.size(); i++) {
            if(books.get(i).getIsbn() == isbn) {
                books.remove(i);
            }
        }
        return true;
    }
}