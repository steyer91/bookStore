package springmongoapp.bookStore.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springmongoapp.bookStore.model.Book;
import springmongoapp.bookStore.repository.BookRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

class BookServiceTest {
    private BookService underTest;
    private AutoCloseable autoCloseable;
    @Mock
    private BookRepository repository;

    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new BookService(repository);
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void ShouldGetAllBook() {
        //when
        underTest.getAll();
        //then
        verify(repository).findAll();
    }

    @Test
    void ShouldGetBookById() {
        //when
        underTest.getById(anyString());
        //then
        verify(repository).findById(anyString());
    }

    @Test
    void ShouldGetBookByGenre() {
        //when
        underTest.getByGenre(anyString());
        //then
        verify(repository).findByGenre(anyString());
    }

    @Test
    void ShouldAddBook() {
        //given
        Book book = new Book(
                "9781234556497",
                "Wieża Jaskółki",
                "Andrzej Sapkowski",
                "Fantasy",
                3
        );

        //when
        underTest.add(book);
        //then
        bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(repository).insert(bookArgumentCaptor.capture());

        Book capturedBook = bookArgumentCaptor.getValue();
        //assert
        assertThat(capturedBook).isEqualTo(book);
    }

    @Test
    void ShouldUpdateBook() {
        //given
        Book book = new Book(
                "9781234556497",
                "Wieża Jaskółki",
                "Andrzej Sapkowski",
                "Fantasy",
                3
        );

        //when
        underTest.update(book);
        //then
        bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(repository).save(bookArgumentCaptor.capture());

        Book capturedBook = bookArgumentCaptor.getValue();
        //assert
        assertThat(capturedBook).isEqualTo(book);
    }

    @Test
    void ShouldDeleteBook() {
        //when
        underTest.delete(anyString());
        //then
        verify(repository).deleteById(anyString());
    }
}