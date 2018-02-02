package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entities.BookEntity;
import entities.PersonEntity;
import interfaces.IBookBean;
import interfaces.IPersonBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@ManagedBean
public class BorrowerController {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
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
            PersonEntity personEntity1 = (PersonEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("1");
            bookEntityList2 = bookBean.getAllBooksBorrowed(personEntity1);
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
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("1", personEntity);
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
            PersonEntity personEntity1 = (PersonEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("1");
            System.out.println(personEntity1);
            bookEntityList = bookBean.getAllBooksAvailable(personEntity1);
            return bookEntityList;
        }
    }
    public void availableBooksList()
    {
        List<BookEntity> bookEntities = bookBean.getAllBooks();

        //for (BookEntity bookEntity1:bookBean.)


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
        System.out.println("$$$$"+personEntity.toString());
        personBean.updatePersonBook(personEntity,bookEntity);
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        try {
//            ec.redirect("BorrowedPanel.xhtml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
        System.out.println("$$$$$$ "+bookEntity.getId());
        personBean.returnBook(bookEntity,personEntity);
    }


}
