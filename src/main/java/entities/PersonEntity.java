package entities;

import javax.persistence.*;
import java.io.Serializable;

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

    public LibrariumEntity getLibrarium() {
        return librarium;
    }

    public void setLibrarium(LibrariumEntity librarium) {
        this.librarium = librarium;
    }
}
