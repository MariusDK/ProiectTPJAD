package interfaces;

import entities.BookEntity;
import entities.DepartmentEntity;
import entities.PersonEntity;

import java.util.List;

public interface IDepartmentBean
{
    void insertDepartment(DepartmentEntity departmentEntity);
    List<DepartmentEntity> getAllDepartments();
    void deleteDepartment(DepartmentEntity departmentEntity);
    void updateDepartment(DepartmentEntity departmentEntity);
    List<BookEntity> getAllBook(int idDepartment);
    List<PersonEntity> getAllPersons(int idDepartment);
}
