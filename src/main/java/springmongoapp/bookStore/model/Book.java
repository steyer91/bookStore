package springmongoapp.bookStore.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {

    @Id
    private String id;
    @Indexed(unique = true)
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int amount;

    public Book(String isbn, String title, String author, String genre, int amount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.amount = amount;
    }

}
