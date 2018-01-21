package beans;

import entites.BookEntity;
import entites.GenreEntity;
import interfaces.IGenreBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Local(interfaces.IGenreBean.class)
@Stateless(name = "GenreBean")
public class GenreBean implements IGenreBean {

    @PersistenceContext(unitName = "NewPersistenceUnit")

    private EntityManager manager;

    @Override
    public void insertGenre(String name) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(name);
        manager.persist(genreEntity);
    }

    @Override
    public List<GenreEntity> getAllGenre() {
        Query query = manager.createQuery("select g from GenreEntity g");
        List<GenreEntity> genreEntities = query.getResultList();
        return genreEntities;
    }

    @Override
    public void deleteGenre(GenreEntity genreEntity) {
        manager.remove(manager.merge(genreEntity));
    }

    @Override
    public void updateGenre(GenreEntity genreEntity) {
        manager.merge(genreEntity);
    }

    @Override
    public List<BookEntity> findAllBooksForGenre(GenreEntity genreEntity) {
        Query query = manager.createQuery("select g.bookEntities from GenreEntity g");
        List<BookEntity> bookEntities = query.getResultList();
        return bookEntities;
    }


}
