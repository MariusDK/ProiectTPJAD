package entites;

import entites.BookEntity;

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

    @OneToMany(mappedBy = "departamentEntity")
    private List<main.java.entites.LibrariumEntity> librariumEntities;

    public List<main.java.entites.LibrariumEntity> getLibrariumEntities() {
        return librariumEntities;
    }

    public void setLibrariumEntities(List<main.java.entites.LibrariumEntity> librariumEntities) {
        this.librariumEntities = librariumEntities;
    }
    @OneToMany(mappedBy = "departamentEntity")
    private List<BookEntity> bookEntities;

    public List<BookEntity> getBookEntities() {
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }
}
