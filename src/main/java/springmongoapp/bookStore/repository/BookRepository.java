package springmongoapp.bookStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springmongoapp.bookStore.model.Book;

public interface BookRepository
        extends MongoRepository<Book, String> {
}
