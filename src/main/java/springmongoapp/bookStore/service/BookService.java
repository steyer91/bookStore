package springmongoapp.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmongoapp.bookStore.model.Book;
import springmongoapp.bookStore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll()
    {
        return repository.findAll();
    }

    public Optional<Book> getById(String id)
    {
        return repository.findById(id);
    }

    public List<Book> getByGenre(String genre)
    {
        return repository.findByGenre(genre);
    }

    public void add(Book book)
    {
        if(book.getId() == "")
            book.setId(null);

        repository.insert(book);
    }

    public void update(Book book)
    {
        repository.save(book);
    }

    public void delete(String id)
    {
        repository.deleteById(id);
    }
}