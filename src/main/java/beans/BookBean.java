package beans;

import entities.*;
import interfaces.IBookBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Local(interfaces.IBookBean.class)
@Stateless(name = "BookBean")
public class BookBean implements IBookBean{

    @PersistenceContext(unitName = "NewPersistenceUnit")

    private EntityManager manager;
    @Override
    public void insertBook(String name, String release_year, DepartmentEntity departmentEntity, String nameAuthor, List<GenreEntity> genreEntities) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(name);
        bookEntity.setRelease_year(release_year);
        bookEntity.setDepartament2(departmentEntity);
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(nameAuthor);


        bookEntity.setGenre(genreEntities);

        manager.persist(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        Query query = manager.createQuery("select b from PersonEntity b");
        List<BookEntity> bookEntities = query.getResultList();
        return bookEntities;
    }

    @Override
    public void deleteBook(BookEntity bookEntity) {
        manager.remove(manager.merge(bookEntity));
    }

    @Override
    public void updateBook(BookEntity bookEntity) {
        manager.merge(bookEntity);
    }

    @Override
    public void borowed(BookEntity bookEntity, List<PersonEntity> personEntities, List<LibrariumEntity> librariumEntity) {
        bookEntity.setPersonEntities(personEntities);
        bookEntity.setLibrarium(librariumEntity);
    }

}
