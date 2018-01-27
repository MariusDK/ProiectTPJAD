package interfaces;

import entities.*;

import java.util.List;

public interface IBookBean {

    public void insertBook(String name, String release_year, DepartmentEntity departmentEntity, List<AuthorEntity> ae, List<GenreEntity> genreEntities);
    public List<BookEntity> getAllBooks();
    public void deleteBook(BookEntity bookEntity);
    public void updateBook(BookEntity bookEntity);
    void borowed(BookEntity bookEntities, List<PersonEntity> personEntities, List<LibrariumEntity> librariumEntity);


    public  BookEntity getBook(int i);
}
