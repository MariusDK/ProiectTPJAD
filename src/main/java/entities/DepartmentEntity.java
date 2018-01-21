package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class DepartmentEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int roomNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @OneToMany(mappedBy = "departament1")
    private List<LibrariumEntity> librariumEntities;

    public List<LibrariumEntity> getLibrariumEntities() {
        return librariumEntities;
    }

    public void setLibrariumEntities(List<LibrariumEntity> librariumEntities) {
        this.librariumEntities = librariumEntities;
    }
    @OneToMany(mappedBy = "departament2")
    private List<BookEntity> bookEntities;

    public List<BookEntity> getBookEntities() {
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }
}
