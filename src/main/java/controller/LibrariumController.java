package controller;



import beans.DepartmentBean;
import beans.LibrariumBean;
import entities.DepartmentEntity;
import entities.LibrariumEntity;
import interfaces.IDepartmentBean;
import interfaces.ILibrariumBean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class LibrariumController {

  private List<LibrariumEntity> librariumEntities = new ArrayList<>();
  private LibrariumEntity librariumEntity = new LibrariumEntity();
  private DepartmentEntity departmentEntity = new DepartmentEntity();
  private List<LibrariumEntity> librariumEntityWithPerson = new ArrayList<>();


    @EJB
    private ILibrariumBean librariumBean;
    @EJB
    private IDepartmentBean departmentBean;


    public List<LibrariumEntity> getLibrariumEntityWithPerson() {
        librariumEntityWithPerson = librariumBean.getLibrariumWithPerson();
        return librariumEntityWithPerson;
    }

    public void setLibrariumEntityWithPerson(List<LibrariumEntity> librariumEntityWithPerson) {
        this.librariumEntityWithPerson = librariumEntityWithPerson;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public List<LibrariumEntity> getLibrariumEntities() {
        librariumEntities = librariumBean.getAllFreePost();
        return librariumEntities;
    }

    public void setLibrariumEntities(List<LibrariumEntity> librariumEntities) {
        this.librariumEntities = librariumEntities;
    }

    public LibrariumEntity getLibrariumEntity() {
        return librariumEntity;
    }

    public void setLibrariumEntity(LibrariumEntity librariumEntity) {
        this.librariumEntity = librariumEntity;
    }

    public void saveLibrarium()
    {
        departmentEntity.setId(librariumBean.getDepartmentId(departmentEntity.getName()));
        librariumBean.insertLibrarium(librariumEntity.getType(),departmentEntity);
    }
//    public void updateLibrarium()
//    {
//        librariumBean.updateLibrarium();
//
//    }

    public void deleteLibrarium()
    {
        librariumBean.deleteLibrarium(librariumEntity);
    }
    public List<DepartmentEntity> getAllDepartments()
    {

        return departmentBean.getAllDepartments();
    }


}
