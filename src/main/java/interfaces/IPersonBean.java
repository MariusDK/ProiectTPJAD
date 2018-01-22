package interfaces;

import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;

import java.util.List;

public interface IPersonBean {
    void insertPerson(PersonEntity personEntity, LibrariumEntity librariumEntity);
    List<PersonEntity> getAllPersons();
    void deletePerson(PersonEntity personEntity);
    void updatePerson(PersonEntity personEntity, LibrariumEntity librariumEntity);

}
