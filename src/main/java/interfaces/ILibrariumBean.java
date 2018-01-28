package interfaces;

import entities.BookEntity;
import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;

import java.util.List;

public interface ILibrariumBean {
    void insertLibrarium(String type, DepartmentEntity departmentEntity);
    List<LibrariumEntity> getAllLibrarium();
    void deleteLibrarium(LibrariumEntity librariumEntity);
    void updateLibrarium(LibrariumEntity librariumEntity);
    List<BookEntity> getBorowed_BookForLibrarium(LibrariumEntity librariumEntity);
    PersonEntity getPersonForLibrarium(LibrariumEntity librariumEntity);
    public int getIdForName(String name);
    public List<LibrariumEntity> getAllFreePost();
    public List<LibrariumEntity> getLibrariumWithPerson();
    public int getDepartmentId(String name);
}
