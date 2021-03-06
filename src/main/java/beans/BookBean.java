package beans;

import entities.*;
import interfaces.IBookBean;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Local(interfaces.IBookBean.class)
@Stateless(name = "BookBean")
public class BookBean implements IBookBean{
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    @PersistenceContext(unitName = "NewPersistenceUnit")

    private EntityManager manager;


    @Override
    public void insertBook(String name, String release_year, DepartmentEntity departmentEntity, List<AuthorEntity> authorEntities, List<GenreEntity> genreEntities) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(name);
        bookEntity.setRelease_year(release_year);
        bookEntity.setDepartament2(departmentEntity);

        bookEntity.setGenre(genreEntities);
        bookEntity.setAuthor(authorEntities);

        manager.merge(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        Query query = manager.createQuery("select b from BookEntity b");
        List<BookEntity> bookEntities = query.getResultList();
        return bookEntities;
    }
    @Override
    public List<BookEntity> getAllBooksAvailable(PersonEntity personEntity) {

        PersonEntity personEntity1 = manager.find(PersonEntity.class,personEntity.getId());
        List<BookEntity> bookEntities = getAllBooks();
        List<BookEntity> bookEntities2 = new ArrayList<>();
        if (personEntity1.getBookEntitys().size()==0)
        {
            return bookEntities;
        }
        for (BookEntity bookEntity:personEntity1.getBookEntitys()) {
            if (bookEntities.contains(bookEntity))
            {
                bookEntities.remove(bookEntity);
            }
        }
        return bookEntities;
    }
    @Override
    public List<BookEntity> getAllBooksBorrowed(PersonEntity personEntity) {
        PersonEntity personEntity1 = manager.find(PersonEntity.class,personEntity.getId());
        List<BookEntity> bookEntities = getAllBooks();
        List<BookEntity> bookEntities2 = new ArrayList<>();
        if (personEntity1.getBookEntitys().size()==0)
        {
            return bookEntities;
        }
        for (BookEntity bookEntity:personEntity1.getBookEntitys()) {
            if (bookEntities.contains(bookEntity))
            {
                bookEntities2.add(bookEntity);
            }
        }

        return bookEntities2;
    }
    @Override
    public void deleteBook(BookEntity bookEntity) {
        bookEntity.setGenre(new ArrayList<GenreEntity>());
        bookEntity.setAuthor(new ArrayList<AuthorEntity>());
        manager.remove(manager.merge(bookEntity));
        LOGGER.log(Level.INFO, "success");

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

    @Override
    public BookEntity getBook(int i) {
        return manager.find(BookEntity.class, i);
    }

}
