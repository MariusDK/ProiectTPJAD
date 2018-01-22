package interfaces;

import entities.BookEntity;
import entities.DepartmentEntity;
import entities.PersonEntity;

import java.util.List;

public interface IDepartmentBean
{
    void insertDepartment(String name, int roomNumber);
    List<DepartmentEntity> getAllDepartments();
    void deleteDepartment(DepartmentEntity departmentEntity);
    void updateDepartment(String name, int roomNumber);
    List<BookEntity> getAllBook(int idDepartment);
    List<PersonEntity> getAllPersons(int idDepartment);
}
