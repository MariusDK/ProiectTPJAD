package entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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
    private DepartmentEntity departamentEntity;

    public DepartmentEntity getDepartamentEntity() {
        return departamentEntity;
    }

    public void setDepartamentEntity(DepartmentEntity departamentEntity) {
        this.departamentEntity = departamentEntity;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Borower_Book",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Librarium_ID", referencedColumnName = "ID"))
    private List<LibrariumEntity> librariumEntities;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Borower_Book",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Person_ID", referencedColumnName = "ID"))
    private List<PersonEntity> personEntities;

    public List<LibrariumEntity> getLibrariumEntities() {
        return librariumEntities;
    }

    public void setLibrariumEntities(List<LibrariumEntity> librariumEntities) {
        this.librariumEntities = librariumEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Book_Author",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Author_ID", referencedColumnName = "ID"))
    private List<AuthorEntity> authorEntities;

    public List<AuthorEntity> getAuthorEntities() {
        return authorEntities;
    }

    public void setAuthorEntities(List<AuthorEntity> authorEntities) {
        this.authorEntities = authorEntities;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Book_Genre",
            joinColumns = @JoinColumn( name = "Book_ID", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn (name = "Genre_ID", referencedColumnName = "ID"))
    private List<GenreEntity> genreEntities;
}
