package interfaces;

import entites.AuthorEntity;
import entites.BookEntity;
import entites.DepartmentEntity;
import entites.PersonEntity;


import java.util.List;

public interface IControllerBean {
    //CRUD Person
    public void insertPerson(String name, int CNP, int phoneNumber, String type);
    public List<PersonEntity> getAllPersons();
    public void deletePerson(PersonEntity personEntity);
    public void updatePerson(String name, int CNP, int phoneNumber, String type);

    //CRUD Departament
    public void insertDepartment(String name, int roomNumber);
    public List<DepartmentEntity> getAllDepartments();
    public void deleteDepartment(DepartmentEntity departmentEntity);
    public void updateDepartment(String name, int roomNumber);

    //CRUD Book
    public void insertBook(String name, String release_year);
    public List<BookEntity> getAllBooks();
    public void deleteBook(BookEntity bookEntity);
    public void updateBook(String name, String release_year);

    //CRUD Author
    public void insertAuthor(String name);
    public List<AuthorEntity> getAllAuthors();
    public void deleteAuthor(AuthorEntity authorEntity);
    public void updateAuthor(String name);

    //CRUD Genre
    public void insertGenre(String name);
    public List<AuthorEntity> getAllGenre();
    public void deleteGenre(AuthorEntity authorEntity);
    public void updateGenre(String name);

}
