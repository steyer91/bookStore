package springmongoapp.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springmongoapp.bookStore.model.Book;
import springmongoapp.bookStore.repository.BookRepository;

import java.util.List;

@Controller
public class CatalogController {
    private final BookRepository repository;

    public CatalogController(BookRepository repository)
    {
        this.repository = repository;
    }


    @GetMapping("/catalog")
    public String index(Model model)
    {
        List<Book> books = repository.findAll();
        model.addAttribute("books", books);
        return "catalog";
    }
}
