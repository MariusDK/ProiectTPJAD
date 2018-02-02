package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String release_year;


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

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    @ManyToOne @JoinColumn
    private DepartmentEntity departament2;

    public DepartmentEntity getDepartament2() {
        return departament2;
    }

    public void setDepartament2(DepartmentEntity departament2) {
        this.departament2 = departament2;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Borower_Book",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Librarium_ID", referencedColumnName = "ID" ))
    private List<LibrariumEntity> librarium;

    public List<LibrariumEntity> getLibrarium() {
        return librarium;
    }

    public void setLibrarium(List<LibrariumEntity> librarium) {
        this.librarium = librarium;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Borower_Book",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Person_ID", referencedColumnName = "ID"))
    private List<PersonEntity> personEntities;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Book_Author",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Author_ID", referencedColumnName = "ID"))
    private List<AuthorEntity> author;

    public List<AuthorEntity> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorEntity> author) {
        this.author = author;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Book_Genre",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Genre_ID", referencedColumnName = "ID"))
    private List<GenreEntity> genre;

    public List<GenreEntity> getGenre() {
        return genre;
    }

    public void setGenre(List<GenreEntity> genre) {
        this.genre = genre;
    }

    public List<PersonEntity> getPersonEntities() {
        return personEntities;
    }

    public void setPersonEntities(List<PersonEntity> personEntities) {
        this.personEntities = personEntities;
    }

    public List<AuthorEntity> authors() {
        return new ArrayList<>(author);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", release_year='" + release_year ;
    }
}
