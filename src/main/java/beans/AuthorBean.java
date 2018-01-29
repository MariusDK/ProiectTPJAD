package beans;

import entities.AuthorEntity;
import entities.BookEntity;
import entities.GenreEntity;
import interfaces.IAuthorBean;
import interfaces.IGenreBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Local(IAuthorBean.class)
@Stateless(name = "AuthorBean")
public class AuthorBean implements IAuthorBean {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    @PersistenceContext(unitName = "NewPersistenceUnit")

    private EntityManager manager;

    @Override
    public void insertAuthor(String name) {
        AuthorEntity a = new AuthorEntity();
        a.setName(name);
        manager.persist(a);
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        Query query = manager.createQuery("select g from AuthorEntity g");
        List<AuthorEntity> ae = query.getResultList();
        return ae;
    }

    @Override
    public void deleteAuthor(AuthorEntity a) {
        LOGGER.info(String.valueOf(a.getId()));
        a.setBookEntities(new ArrayList<BookEntity>());
        manager.remove(manager.merge(a));

    }

    @Override
    public void updateAuthor(AuthorEntity a) {
        LOGGER.info(String.valueOf(a.getId()));
        LOGGER.info(String.valueOf(a.getName()));
        manager.merge(a);
    }


    @Override
    public AuthorEntity findAuthor(Integer id) {
        return manager.find(AuthorEntity.class, id);
    }
}
