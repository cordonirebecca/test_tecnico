package com.testtecnico.testtecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    //visualizzo tutti i libri
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //ricerca un libro di un utente
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));
    }

    @GetMapping("/user/{userId}")
    public List<Book> getBooksByUserId(@PathVariable Long userId) {
        return bookRepository.findByUserId(userId);
    }



    //aggiungi un libro al database
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }


    //aggiorni tutti i dati dei libri che voglio nome,indice...
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));

        // Update book details here...

        return bookRepository.save(book);
    }

    //cancello un libro
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
