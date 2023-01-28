package springmongoapp.bookStore.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springmongoapp.bookStore.model.Book;
import springmongoapp.bookStore.service.BookService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service)
    {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Optional<Book> get(String id)
    {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(Book book)
    {
        service.add(book);

        return new ModelAndView(  "redirect:/catalog");
    }
    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public ModelAndView update(Book book)
    {
        service.update(book);
        return new ModelAndView( "redirect:/catalog");
    }

    @RequestMapping(value="/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView delete(String id)
    {
        service.delete(id);

        return new ModelAndView( "redirect:/catalog");
    }
}
