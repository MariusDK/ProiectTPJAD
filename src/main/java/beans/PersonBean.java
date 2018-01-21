package beans;

import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;
import interfaces.IPersonBean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Local(interfaces.IPersonBean.class)
@Stateless(name = "PersonBean")
public class PersonBean implements IPersonBean {

    @PersistenceContext(unitName = "NewPersistenceUnit")

    private EntityManager manager;

    @Override
    public void insertPerson(PersonEntity personEntity, String type) {

        //departament list
        if (type.equals("")) {
            manager.persist(personEntity);
        } else {
            LibrariumEntity librariumEntity = new LibrariumEntity();
            librariumEntity.setType(type);
            librariumEntity.setPersonEntity(personEntity);
            manager.merge(librariumEntity);
        }
    }

    @Override
    public List<PersonEntity> getAllPersons() {
        Query query = manager.createQuery("select p from PersonEntity p");
        List<PersonEntity> personEntities = query.getResultList();
        return personEntities;
    }

    @Override
    public void deletePerson(PersonEntity personEntity) {
        manager.remove(manager.merge(personEntity));
    }

    @Override
    public void updatePerson(PersonEntity personEntity,LibrariumEntity librariumEntity) {
        personEntity.setLibrarium(librariumEntity);
        manager.merge(personEntity);
    }
}
