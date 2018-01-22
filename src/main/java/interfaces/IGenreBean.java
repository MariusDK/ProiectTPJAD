package interfaces;

import entities.BookEntity;
import entities.GenreEntity;

import java.util.List;

public interface IGenreBean {
    void insertGenre(String name);
    List<GenreEntity> getAllGenre();
    void deleteGenre(GenreEntity genreEntity);
    void updateGenre(GenreEntity genreEntity);
    List<BookEntity> findAllBooksForGenre(GenreEntity genreEntity);
}
