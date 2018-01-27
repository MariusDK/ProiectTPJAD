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
    public void insertPerson(PersonEntity personEntity, LibrariumEntity librariumEntity) {


        //departament list
        if (librariumEntity.getType() == null) {
            manager.persist(personEntity);
        } else {
            LibrariumEntity librariumEntity1 = manager.find(LibrariumEntity.class, librariumEntity.getId());

            librariumEntity1.setPersonEntity(personEntity);
            personEntity.setLibrarium(librariumEntity1);
            manager.persist(personEntity);
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
        PersonEntity personEntity1 = manager.find(PersonEntity.class, personEntity.getId());

        if (personEntity1.getLibrarium() == null) {
            manager.remove(manager.merge(personEntity));
        } else {
            LibrariumEntity librariumEntity = getLibrariumFromPersonId(personEntity.getId());
            LibrariumEntity librariumEntity1 = manager.find(LibrariumEntity.class, librariumEntity.getId());
            librariumEntity1.setPersonEntity(null);
            manager.remove(manager.merge(personEntity));
        }
    }

    @Override
    public void updatePerson(PersonEntity personEntity) {
        //PersonEntity personEntity1 = getPersonWithCNP(personEntity.getCNP());
        PersonEntity personEntity2 = manager.find(PersonEntity.class, personEntity.getId());
        personEntity2.setCNP(personEntity.getCNP());
        personEntity2.setName(personEntity.getName());
        personEntity2.setPhoneNumber(personEntity.getPhoneNumber());
        manager.merge(personEntity2);
    }

    @Override
    public LibrariumEntity getLibrariumFromPersonId(int id) {
        Query query = manager.createQuery("select l from LibrariumEntity l where l.personEntity.id=:Nid");
        query.setParameter("Nid", id);
        LibrariumEntity librariumEntity = (LibrariumEntity) query.getSingleResult();
        return librariumEntity;
    }
    @Override
    public PersonEntity getPersonWithCNP(int CNP) {
        Query query = manager.createQuery("select p from PersonEntity p where p.CNP=:NCNP");
        query.setParameter("NCNP", CNP);
        PersonEntity personEntity = (PersonEntity) query.getSingleResult();
        return personEntity;

    }
    @Override
    public PersonEntity selectHelper(PersonEntity personEntity)
    {
        PersonEntity personEntity1 = manager.find(PersonEntity.class, personEntity.getId());
        if (personEntity1.getLibrarium() != null) {

        } else {
            LibrariumEntity librariumEntity = getLibrariumFromPersonId(personEntity.getId());
            LibrariumEntity librariumEntity1 = manager.find(LibrariumEntity.class, librariumEntity.getId());
            librariumEntity1.setPersonEntity(null);
        }
        return personEntity1;
    }
}
