package controller;

import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;
import interfaces.IDepartmentBean;
import interfaces.ILibrariumBean;
import interfaces.IPersonBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class PersonController {

    PersonEntity personEntity = new PersonEntity();
    LibrariumEntity librariumEntity = new LibrariumEntity();
    DepartmentEntity departmentEntity = new DepartmentEntity();

    List<PersonEntity> personEntities = new ArrayList<>();

    @EJB
    IPersonBean personBean;
    @EJB
    ILibrariumBean librariumBean;
    @EJB
    IDepartmentBean departmentBean;


    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public void setLibrariumEntity(LibrariumEntity librariumEntity) {
        this.librariumEntity = librariumEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public LibrariumEntity getLibrariumEntity() {
        return librariumEntity;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public List<PersonEntity> getPersonEntities() {
        personEntities = personBean.getAllPersons();
        return personEntities;
    }

    public void setPersonEntities(List<PersonEntity> personEntities) {
        this.personEntities = personEntities;
    }

    public void savePerson()
    {
        if (librariumEntity.getType()!=null) {
            int id = librariumBean.getIdForName(librariumEntity.getType());
            librariumEntity.setId(id);
        }
        personEntity.setAvailableBooks(5);
        personBean.insertPerson(personEntity, librariumEntity);
    }
    public void updatePerson()
    {
        personBean.updatePerson(personEntity);
    }

    public void deletePerson()
    {
        personBean.deletePerson(personEntity);
    }
    public void selectPerson()
    {

    }
    public List<PersonEntity> ListPersons()
    {
        return personBean.getAllPersons();
    }
    public List<LibrariumEntity> getAllLibrarium()
    {
        List<LibrariumEntity> librariumEntities = new ArrayList<>();
        for (LibrariumEntity librariumEntity:librariumBean.getAllLibrarium())
        {
            if (librariumEntity.getPersonEntity()==null)
            {
                librariumEntities.add(librariumEntity);
            }
        }
        return librariumEntities;
    }
    public List<DepartmentEntity> getAllDepartments()
    {

        return departmentBean.getAllDepartments();
    }
    public String convertStringLibrarium()
    {

        return librariumEntity.toString();
    }


}
