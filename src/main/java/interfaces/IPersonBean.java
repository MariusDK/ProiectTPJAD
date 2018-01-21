package interfaces;

import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;

import java.util.List;

public interface IPersonBean {
    public void insertPerson(PersonEntity personEntity, String type);
    public List<PersonEntity> getAllPersons();
    public void deletePerson(PersonEntity personEntity);
    public void updatePerson(PersonEntity personEntity, LibrariumEntity librariumEntity);

}
