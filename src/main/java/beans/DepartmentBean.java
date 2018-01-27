package beans;

import entities.BookEntity;
import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;
import interfaces.IDepartmentBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Local(interfaces.IDepartmentBean.class)
@Stateless(name = "DepartmentBean")
public class DepartmentBean implements IDepartmentBean{

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager manager;

    @Override
    public void insertDepartment(DepartmentEntity departmentEntity) {
        manager.persist(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        Query query = manager.createQuery("select d from DepartmentEntity d");
        List<DepartmentEntity> departmentEntities = query.getResultList();
        return departmentEntities;
    }

    @Override
    public void deleteDepartment(DepartmentEntity departmentEntity) {
        manager.remove(manager.merge(departmentEntity));
    }

    @Override
    public void updateDepartment(DepartmentEntity departmentEntity) {
        manager.merge(departmentEntity);
    }

    @Override
    public List<PersonEntity> getAllPersons(int idDepartment)
    {
        List<PersonEntity> personEntityList = new ArrayList<>();
        Query query = manager.createQuery("select d.librariumEntities from DepartmentEntity d where d.id ="+idDepartment);
        List<LibrariumEntity> librariumEntities  = query.getResultList();
        for (LibrariumEntity librariumEntity : librariumEntities)
        {
            personEntityList.add(librariumEntity.getPersonEntity());
        }
        return personEntityList;
    }

    @Override
    public List<BookEntity> getAllBook(int idDepartment)
    {
        List<BookEntity> bookEntities = new ArrayList<>();
        Query query = manager.createQuery("select d.bookEntities from DepartmentEntity d where d.id ="+idDepartment);
        bookEntities  = query.getResultList();
        for (BookEntity bookEntity : bookEntities)
        {
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }
}
