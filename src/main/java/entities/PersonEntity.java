package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class PersonEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int CNP;
    private int phoneNumber;

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

    public int getCNP() {
        return CNP;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @OneToOne
    private LibrariumEntity librarium;

    @ManyToMany(mappedBy = "personEntities")
    private List<BookEntity> bookEntitys;


    public LibrariumEntity getLibrarium() {
        return librarium;
    }

    public void setLibrarium(LibrariumEntity librarium) {
        this.librarium = librarium;
    }

    public List<BookEntity> getBookEntitys() {
        return bookEntitys;
    }

    public void setBookEntitys(List<BookEntity> bookEntitys) {
        this.bookEntitys = bookEntitys;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CNP=" + CNP +
                ", phoneNumber=" + phoneNumber +
                ", librarium=" + librarium +
                '}';
    }
}
