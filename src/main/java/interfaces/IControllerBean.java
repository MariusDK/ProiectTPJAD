package interfaces;

import entities.AuthorEntity;
import entities.BookEntity;
import entities.DepartmentEntity;
import entities.PersonEntity;


import java.util.List;

public interface IControllerBean {
    //CRUD Person
    void insertPerson(String name, int CNP, int phoneNumber, String type);
    List<PersonEntity> getAllPersons();
    void deletePerson(PersonEntity personEntity);
    void updatePerson(String name, int CNP, int phoneNumber, String type);

    //CRUD Departament
    void insertDepartment(String name, int roomNumber);
    List<DepartmentEntity> getAllDepartments();
    void deleteDepartment(DepartmentEntity departmentEntity);
    void updateDepartment(String name, int roomNumber);

    //CRUD Book
    void insertBook(String name, String release_year);
    List<BookEntity> getAllBooks();
    void deleteBook(BookEntity bookEntity);
    void updateBook(String name, String release_year);

    //CRUD Author
    void insertAuthor(String name);
    List<AuthorEntity> getAllAuthors();
    void deleteAuthor(AuthorEntity authorEntity);
    void updateAuthor(String name);

    //CRUD Genre
    void insertGenre(String name);
    List<AuthorEntity> getAllGenre();
    void deleteGenre(AuthorEntity authorEntity);
    void updateGenre(String name);

}
