package controller;

import beans.DepartmentBean;
import entities.BookEntity;
import entities.DepartmentEntity;
import entities.PersonEntity;
import interfaces.IDepartmentBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class DepartmentController {

    DepartmentEntity departmentEntity = new DepartmentEntity();
    List<DepartmentEntity> departmentEntities = new ArrayList<>();
    @EJB
    IDepartmentBean departmentBean;
    List<PersonEntity> personEntities = new ArrayList<>();
    List<BookEntity> bookEntities = new ArrayList<>();

    public List<BookEntity> getBookEntities() {
        bookEntities = departmentBean.getAllBook(departmentEntity.getId());
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }

    public List<PersonEntity> getPersonEntities() {
        personEntities = departmentBean.getAllPersons(departmentEntity.getId());
        return personEntities;
    }


    public void setPersonEntities(List<PersonEntity> personEntities) {
        this.personEntities = personEntities;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }


    public List<DepartmentEntity> getDepartmentEntities() {
        departmentEntities = departmentBean.getAllDepartments();
        return departmentEntities;
    }

    public void setDepartmentEntities(List<DepartmentEntity> departmentEntities) {
        this.departmentEntities = departmentEntities;
    }

    public void saveDepartament()
    {

        departmentBean.insertDepartment(departmentEntity);
    }
    public void deleteDepartment()
    {
        departmentBean.deleteDepartment(departmentEntity);
    }
    public void updateDepartment()
    {
        departmentBean.updateDepartment(departmentEntity);
    }
    public List<BookEntity> showAllBooksForDepartment()
    {
        List<BookEntity> bookEntities = departmentBean.getAllBook(departmentEntity.getId());
        return bookEntities;
    }

}
