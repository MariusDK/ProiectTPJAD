package beans;


import entities.BookEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;
import interfaces.ILibrariumBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Local(interfaces.ILibrariumBean.class)
@Stateless(name = "LibrariumBean")
public class LibrariumBean implements ILibrariumBean{
    @PersistenceContext(unitName = "NewPersistenceUnit")

    private EntityManager manager;
    @Override
    public void insertLibrarium(String type) {
        LibrariumEntity librariumEntity = new LibrariumEntity();
        librariumEntity.setType(type);
        manager.persist(librariumEntity);
    }

    @Override
    public List<LibrariumEntity> getAllLibrarium() {
        Query query = manager.createQuery("select l from LibrariumEntity l");
        List<LibrariumEntity> librariumEntities = query.getResultList();
        return librariumEntities;
    }

    @Override
    public void deleteLibrarium(LibrariumEntity librariumEntity) {
        manager.remove(manager.merge(librariumEntity));
    }

    @Override
    public void updateLibrarium(String type) {
        LibrariumEntity librariumEntity = new LibrariumEntity();
        librariumEntity.setType(type);
        manager.merge(librariumEntity);
    }

    @Override
    public List<BookEntity> getBorowed_BookForLibrarium(LibrariumEntity librariumEntity) {
        Query query = manager.createQuery("select l.bookEntitys from LibrariumEntity l where id =="+librariumEntity.getId());
        List<BookEntity> bookEntities = query.getResultList();
        return bookEntities;
    }

    @Override
    public PersonEntity getPersonForLibrarium(LibrariumEntity librariumEntity) {
        return librariumEntity.getPersonEntity();
    }
    @Override
    public int getIdForName(String type)
    {
        Query query = manager.createQuery("select l.id from LibrariumEntity l where l.type=:Ntype");
        query.setParameter("Ntype", type);
        int id_librarium=(int)query.getSingleResult();
        return id_librarium;

    }

}
