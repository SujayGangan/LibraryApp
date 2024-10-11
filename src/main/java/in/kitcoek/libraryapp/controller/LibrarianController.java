package in.kitcoek.libraryapp.controller;


import in.kitcoek.libraryapp.model.IssuedBook;
import in.kitcoek.libraryapp.model.Librarian;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("librarian")
public class LibrarianController{
    Librarian librarian;
    List<IssuedBook> issuedBookList = new ArrayList<>();

    @PostMapping
    public boolean insertLibrarian(@RequestBody Librarian l) {
        if(librarian == null) {
            librarian = l;
            return true;
        }
        return false;
    }
    @GetMapping()
    public Librarian getLibrarian() {
        return librarian;
    }
    @PutMapping("/{id}")
    public boolean updateLibrarian(@PathVariable int id, @RequestBody Librarian librarian) {
        if(this.librarian.getId() == id){
            this.librarian = librarian;
            return true;
        }
        return false;
    }
    @DeleteMapping("/delete")
    public boolean deleteLibrarian() {
        librarian = null;
        return true;
    }
    @GetMapping("/issue/{isbn}/{prn}")
    public boolean issueBook(@PathVariable int isbn, @PathVariable int prn) {
        boolean studentFound = false,bookFound = false;
        for(int i = 0; i < StudentController.students.size(); i++) {
            if(StudentController.students.get(i).getPrn() == prn) {
                studentFound = true;
                break;
            }
        }
        for (int i = 0; i < BookController.books.size(); i++) {
            if(BookController.books.get(i).getIsbn() == isbn) {
                bookFound = true;
                break;
            }
        }
        if(studentFound && bookFound) {
            issuedBookList.add(new IssuedBook(prn, isbn));
        }
        else{
            return false;
        }
        return true;
    }
    @GetMapping("/issuedBooks")
    public List<IssuedBook> getIssuedBookList() {
        return issuedBookList;
    }
    @GetMapping("/collect/{isbn}/{prn}")
    public boolean collectBook(@PathVariable int isbn, @PathVariable int prn) {
        for (int i = 0; i < issuedBookList.size(); i++) {
            if(issuedBookList.get(i).getIsbn() == isbn && issuedBookList.get(i).getPrn() == prn) {
                issuedBookList.remove(i);
                return true;
            }
        }
        return false;
    }
}
