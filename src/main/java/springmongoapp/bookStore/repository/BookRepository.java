package springmongoapp.bookStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import springmongoapp.bookStore.model.Book;

import java.util.List;

public interface BookRepository
        extends MongoRepository<Book, String> {

    @Query(value = "{ 'genre' : ?0 }")
    List<Book> findByGenre(@Param("genre") String genre);
}
