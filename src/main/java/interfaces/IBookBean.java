package interfaces;

import entites.*;

import java.util.List;

public interface IBookBean {
    public void insertBook(String name, String release_year, DepartmentEntity departmentEntity, String nameAuthor, List<GenreEntity> genreEntities);
    public List<BookEntity> getAllBooks();
    public void deleteBook(BookEntity bookEntity);
    public void updateBook(BookEntity bookEntity);

    public void borowed(BookEntity bookEntities, List<PersonEntity> personEntities, List<LibrariumEntity> librariumEntity);


}
