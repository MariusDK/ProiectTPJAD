package controller;

import beans.DepartmentBean;
import beans.LibrariumBean;
import beans.PersonBean;
import entities.DepartmentEntity;
import entities.LibrariumEntity;
import entities.PersonEntity;
import interfaces.IDepartmentBean;
import interfaces.ILibrariumBean;
import interfaces.IPersonBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class PersonController {

    PersonEntity personEntity = new PersonEntity();
    LibrariumEntity librariumEntity = new LibrariumEntity();
    DepartmentEntity departmentEntity = new DepartmentEntity();

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

    public void savePerson(PersonEntity personEntity, String type)
    {
        System.out.println(type);
        personBean.insertPerson(personEntity, type);
    }
    public void updatePerson(PersonEntity personEntity,LibrariumEntity librariumEntity)
    {
        personBean.updatePerson(personEntity,librariumEntity);
    }
    public void deletePerson(PersonEntity personEntity)
    {
        personBean.deletePerson(personEntity);
    }
    public List<PersonEntity> ListPersons()
    {
        return personBean.getAllPersons();
    }
    public List<LibrariumEntity> getAllLibrarium()
    {

        return librariumBean.getAllLibrarium();
    }
    public List<DepartmentEntity> getAllDepartments()
    {

        return departmentBean.getAllDepartments();
    }


}
