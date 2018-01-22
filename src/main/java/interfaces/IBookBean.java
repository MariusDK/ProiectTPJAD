package interfaces;

import entities.*;

import java.util.List;

public interface IBookBean {
    void insertBook(String name, String release_year, DepartmentEntity departmentEntity, String nameAuthor, List<GenreEntity> genreEntities);
    List<BookEntity> getAllBooks();
    void deleteBook(BookEntity bookEntity);
    void updateBook(BookEntity bookEntity);

    void borowed(BookEntity bookEntities, List<PersonEntity> personEntities, List<LibrariumEntity> librariumEntity);


}
