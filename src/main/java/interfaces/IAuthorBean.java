package interfaces;

import entities.AuthorEntity;
import entities.BookEntity;
import entities.GenreEntity;

import java.util.List;

public interface IAuthorBean {
    public void insertAuthor(String name);
    public List<AuthorEntity> getAllAuthors();
    public void deleteAuthor(AuthorEntity a);
    public void updateAuthor(AuthorEntity a);
    public AuthorEntity findAuthor(Integer id);
}
