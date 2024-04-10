package com.testtecnico.testtecnico;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("http://localhost:8081/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

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

    //ricerca il libro dell'utente !!!
    @GetMapping("/user/{userId}")
    public List<Book> getBooksByUserId(@PathVariable Long userId) {
        return bookRepository.findByUserId(userId);
    }


    //aggiungi un libro al database
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //aggiungi un libro al database dato un id specifico
    @PostMapping("/user/{userId}")
    public Book createBookForUser(@PathVariable Long userId, @RequestBody Book book) {
        // Verifica se l'utente esiste
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id " + userId));

        // Imposta l'utente per il libro
        book.setUser(user);

        // Salva il libro nel repository
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

}
