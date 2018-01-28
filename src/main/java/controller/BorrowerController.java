package controller;


import java.util.ArrayList;
import java.util.List;
import entities.BookEntity;
import entities.PersonEntity;
import interfaces.IBookBean;
import interfaces.IPersonBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BorrowerController {

    private PersonEntity personEntity = new PersonEntity();
    private BookEntity bookEntity = new BookEntity();
    private BookEntity bookEntity2 = new BookEntity();
    private List<PersonEntity> personEntityList = new ArrayList<>();
    private List<BookEntity> bookEntityList = new ArrayList<>();
    private List<BookEntity> bookEntityList2 = new ArrayList<>();
    private String PersonName = "";
    private String BookName = "";

    @EJB
    private IPersonBean personBean;

    @EJB
    private IBookBean bookBean;


    public BookEntity getBookEntity2() {
        return bookEntity2;
    }

    public void setBookEntity2(BookEntity bookEntity2) {
        this.bookEntity2 = bookEntity2;
    }

    public List<BookEntity> getBookEntityList2() {
        if (personEntity.getAvailableBooks()==5)
        {
            return bookEntityList2;
        }
        else{
            bookEntityList2 = bookBean.getAllBooksBorrowed(personEntity);
            return bookEntityList2;
        }
    }

    public void setBookEntityList2(List<BookEntity> bookEntityList2) {
        this.bookEntityList2 = bookEntityList2;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public List<PersonEntity> getPersonEntityList() {
        personEntityList = personBean.getAllPersons();
        return personEntityList;
    }

    public void setPersonEntityList(List<PersonEntity> personEntityList) {
        this.personEntityList = personEntityList;
    }

    public List<BookEntity> getBookEntityList() {
        if (personEntity.getAvailableBooks()==5)
        {
            return bookEntityList = bookBean.getAllBooks();
        }
        else{
            return bookEntityList = bookBean.getAllBooksAvailable(personEntity);
        }

    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }
    public void searchPerson()
    {
        List<PersonEntity> personEntities = new ArrayList<>();
        for (PersonEntity personEntity1:personEntityList)
        {
            if (personEntity1.getName().equals(PersonName)) {
                personEntities.add(personEntity1);
            }
        }
        if (PersonName.equals(""))
        {
            personEntityList = getPersonEntityList();
        }
        else
        {
            personEntityList = personEntities;
        }
    }
    public void borrowedBook()
    {
        personBean.updatePersonBook(personEntity,bookEntity);
    }
    public void searchBook()
    {
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookEntity bookEntity1:bookEntityList)
        {
            if (bookEntity1.getName().equals(BookName)) {
                bookEntities.add(bookEntity1);
            }
        }
        if (BookName.equals(""))
        {
            bookEntityList = getBookEntityList();
        }
        else
        {
            bookEntityList = bookEntities;
        }
    }
    public void ReturnBook()
    {
        personBean.returnBook(bookEntity2,personEntity);
    }


}
