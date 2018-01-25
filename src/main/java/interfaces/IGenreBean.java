package interfaces;

import entities.BookEntity;
import entities.GenreEntity;

import java.util.List;

public interface IGenreBean {
    public void insertGenre(String name);
    public List<GenreEntity> getAllGenre();
    public void deleteGenre(GenreEntity genreEntity);
    public void updateGenre(GenreEntity genreEntity);
    public List<BookEntity> findAllBooksForGenre(GenreEntity genreEntity);
    public GenreEntity findGenre(Integer id);
}
