package entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class LibrariumEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @OneToOne
    private PersonEntity personEntity;

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    @ManyToOne @JoinColumn
    private DepartmentEntity departament1;

    public DepartmentEntity getDepartament1() {
        return departament1;
    }

    public void setDepartament1(DepartmentEntity departament1) {
        this.departament1 = departament1;
    }

    @ManyToMany(mappedBy = "librarium")
    private List<BookEntity> bookEntitys;

    public List<BookEntity> getBookEntitys() {
        return bookEntitys;
    }

    public void setBookEntitys(List<BookEntity> bookEntitys) {
        this.bookEntitys = bookEntitys;
    }
}
