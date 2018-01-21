package interfaces;

import entites.PersonEntity;

import java.util.List;

public interface IPersonBean {
    public void insertPerson(String name, int CNP, int phoneNumber, String type);
    public List<PersonEntity> getAllPersons();
    public void deletePerson(PersonEntity personEntity);
    public void updatePerson(String name, int CNP, int phoneNumber, String type);

}
