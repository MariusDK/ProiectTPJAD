package interfaces;

import entites.BookEntity;
import entites.LibrariumEntity;
import entites.PersonEntity;

import java.util.List;

public interface ILibrariumBean {
    public void insertLibrarium(String type);
    public List<LibrariumEntity> getAllLibrarium();
    public void deleteLibrarium(LibrariumEntity librariumEntity);
    public void updateLibrarium(String type);
    public List<BookEntity> getBorowed_BookForLibrarium(LibrariumEntity librariumEntity);
    public PersonEntity getPersonForLibrarium(LibrariumEntity librariumEntity);
}
