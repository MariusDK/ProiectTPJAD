package beans;

import entites.LibrariumEntity;
import entites.PersonEntity;
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
    public void insertPerson(String name, int CNP, int phoneNumber, String type) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(name);
        personEntity.setCNP(CNP);
        personEntity.setPhoneNumber(phoneNumber);
        LibrariumEntity librariumEntity = new LibrariumEntity();
        librariumEntity.setType(type);
        //departament list
        manager.persist(personEntity);
        librariumEntity.setPersonEntity(personEntity);
        manager.persist(librariumEntity);
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
    public void updatePerson(String name, int CNP, int phoneNumber, String type) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setPhoneNumber(phoneNumber);
        personEntity.setCNP(CNP);
        personEntity.setName(name);
        PersonEntity personEntity1 = manager.merge(personEntity);

        LibrariumEntity librariumEntity = personEntity1.getLibrarium();
        librariumEntity.setType(type);
        manager.merge(librariumEntity);
    }
}
