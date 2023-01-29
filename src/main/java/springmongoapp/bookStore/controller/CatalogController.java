package springmongoapp.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springmongoapp.bookStore.model.Book;
import springmongoapp.bookStore.repository.BookRepository;
import springmongoapp.bookStore.service.BookService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class CatalogController {
    private final BookService service;

    public CatalogController(BookService service)
    {
        this.service = service;
    }


    @GetMapping("/catalog")
    public String getAll(Model model, String genre)
    {
        if(genre != null)
        {
            if(genre.isEmpty())
                model.addAttribute("books", service.getAll());
            else
                model.addAttribute("books", service.getByGenre(genre));
        }
        else
            model.addAttribute("books", service.getAll());

        return "catalog";
    }


}
