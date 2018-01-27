package interfaces;

import entities.BookEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;

import java.util.List;

public interface ILibrariumBean {
    void insertLibrarium(String type);
    List<LibrariumEntity> getAllLibrarium();
    void deleteLibrarium(LibrariumEntity librariumEntity);
    void updateLibrarium(String type);
    List<BookEntity> getBorowed_BookForLibrarium(LibrariumEntity librariumEntity);
    PersonEntity getPersonForLibrarium(LibrariumEntity librariumEntity);
    public int getIdForName(String name);
}
