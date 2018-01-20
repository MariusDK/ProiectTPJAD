package beans;

import entites.AuthorEntity;
import entites.BookEntity;
import entites.DepartmentEntity;
import entites.PersonEntity;
import interfaces.IControllerBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "ControllerBean")
@Local(interfaces.IControllerBean.class)

public class ControllerBean implements IControllerBean {
    public ControllerBean() {
    }

    @Override
    public void insertPerson(String name, int CNP, int phoneNumber, String type) {

    }

    @Override
    public List<PersonEntity> getAllPersons() {
        return null;
    }

    @Override
    public void deletePerson(PersonEntity personEntity) {

    }

    @Override
    public void updatePerson(String name, int CNP, int phoneNumber, String type) {

    }

    @Override
    public void insertDepartment(String name, int roomNumber) {

    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return null;
    }

    @Override
    public void deleteDepartment(DepartmentEntity departmentEntity) {

    }

    @Override
    public void updateDepartment(String name, int roomNumber) {

    }

    @Override
    public void insertBook(String name, String release_year) {

    }

    @Override
    public List<BookEntity> getAllBooks() {
        return null;
    }

    @Override
    public void deleteBook(BookEntity bookEntity) {

    }

    @Override
    public void updateBook(String name, String release_year) {

    }

    @Override
    public void insertAuthor(String name) {

    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return null;
    }

    @Override
    public void deleteAuthor(AuthorEntity authorEntity) {

    }

    @Override
    public void updateAuthor(String name) {

    }

    @Override
    public void insertGenre(String name) {

    }

    @Override
    public List<AuthorEntity> getAllGenre() {
        return null;
    }

    @Override
    public void deleteGenre(AuthorEntity authorEntity) {

    }

    @Override
    public void updateGenre(String name) {

    }
}
