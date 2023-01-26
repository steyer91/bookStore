package springmongoapp.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String index(Model model, String genre)
    {
        if(genre != null)
        {
            if(genre.isEmpty())
                model.addAttribute("books", repository.findAll());
            else
                model.addAttribute("books", repository.findByGenre(genre));
        }
        else
            model.addAttribute("books", repository.findAll());

        return "catalog";
    }

    @PostMapping("/catalog/add")
    public String add(Book book)
    {
        repository.insert(book);

        return "redirect:/catalog";
    }

    @RequestMapping(value="/catalog/delete/", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(String id)
    {
        repository.deleteById(id);

        return "redirect:/catalog";
    }

}
