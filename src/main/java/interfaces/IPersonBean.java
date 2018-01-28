package interfaces;

import entities.BookEntity;
import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;

import java.util.List;

public interface IPersonBean {
    void insertPerson(PersonEntity personEntity, LibrariumEntity librariumEntity);
    List<PersonEntity> getAllPersons();
    void deletePerson(PersonEntity personEntity);
    void updatePerson(PersonEntity personEntity);
    public LibrariumEntity getLibrariumFromPersonId(int id);
    public PersonEntity selectHelper(PersonEntity personEntity);
    public PersonEntity getPersonWithCNP(int CNP);
    public void updatePersonBook(PersonEntity personEntity, BookEntity bookEntity);
    public List<PersonEntity> getAllPersonWithAvailableBookS();
    public void returnBook(BookEntity book,PersonEntity personEntity);
}
