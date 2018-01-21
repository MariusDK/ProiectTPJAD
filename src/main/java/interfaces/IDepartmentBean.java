package interfaces;

import entities.BookEntity;
import entities.DepartmentEntity;
import entities.PersonEntity;

import java.util.List;

public interface IDepartmentBean
{
    public void insertDepartment(String name, int roomNumber);
    public List<DepartmentEntity> getAllDepartments();
    public void deleteDepartment(DepartmentEntity departmentEntity);
    public void updateDepartment(String name, int roomNumber);
    public List<BookEntity> getAllBook(int idDepartment);
    public List<PersonEntity> getAllPersons(int idDepartment);
}
