package controller;


import entities.AuthorEntity;
import entities.BookEntity;
import entities.GenreEntity;
import interfaces.IAuthorBean;
import interfaces.IBookBean;
import interfaces.IGenreBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class BookController {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private BookEntity bookEntity = new BookEntity();
    private String[] selectedG;
    private String[] selectedA;
    private BookEntity book = new BookEntity();
    private String[] selectedForEdit;
    @EJB
    IBookBean bookBean;

    @EJB
    IGenreBean genreBean;

    @EJB
    IAuthorBean authorBean;


    public List<GenreEntity> allGenres() {
        return genreBean.getAllGenre();
    }

    public List<AuthorEntity> allAuthors() {
        return authorBean.getAllAuthors();
    }

    public void saveBook(BookEntity book) {
        bookBean.insertBook(book.getName(), book.getRelease_year(), null, selectedAuthorEntities(), selectedGenreEntities());
        setBookEntity(null);
    }

    private List<AuthorEntity> selectedAuthorEntities() {
        List<AuthorEntity> g = new ArrayList<>();
        for(AuthorEntity author:allAuthors()) {
            boolean found = false;
            for (String id: selectedA) {
                if (id.equals(Integer.toString(author.getId()))) {
                    found = true;
                }
            }
            if (found) {
                g.add(author);
            }
        }

        return g;
    }

    public List<BookEntity> getAllBooks() {
        return bookBean.getAllBooks();
    }

    private List<GenreEntity> selectedGenreEntities() {
        List<GenreEntity> g = new ArrayList<>();

        for (GenreEntity genre:allGenres()) {
            boolean found = false;
            for (String id: selectedG) {
                if (id.equals(Integer.toString(genre.getId()))) {
                    found = true;
                }
            }
            if (found) {
                g.add(genre);
            }
        }

        return g;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public void selectGenre(GenreEntity genre) {
        LOGGER.log(Level.INFO, genre.getName());
    }

    public void setGenres(ArrayList<GenreEntity> genres) {
        LOGGER.log(Level.INFO, String.valueOf(genres.size()));
    }

    public void setGenres(List<GenreEntity> genres) {
        LOGGER.log(Level.INFO, String.valueOf(genres.size()));
    }

    public void setGenres(GenreEntity genre) {
        if (genre != null) {
            LOGGER.log(Level.INFO, genre.getName());
        }
    }

    public String[] getSelectedG() {
        return selectedG;
    }

    public void setSelectedG(String[] selectedG) {
        this.selectedG = selectedG;
    }

    public String getSelectedGInString() {
        return Arrays.toString(selectedG);
    }

    public void deleteBook(BookEntity book) {

        bookBean.deleteBook(book);
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public void updateBook(String bookId, String name, String year) {
        LOGGER.log(Level.INFO, name);
        LOGGER.log(Level.INFO, String.valueOf(year));
        BookEntity bookE = getBookFromId(bookId);
        bookE.setName(name);
        bookE.setRelease_year(year);
        bookE.setGenre(selectedGenreEntities());
        bookBean.updateBook(bookE);

        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "Book.xhtml");
//        LOGGER.log(Level.INFO,);
//        LOGGER.log(Level.INFO,);
    }

    private BookEntity getBookFromId(String bookId) {
        return  bookBean.getBook(Integer.parseInt(bookId));
    }

//    @PostConstruct
//    public void init() {
//        BookEntity b = getBookFromId(FacesContext.getCurrentInstance().
//                getExternalContext().getRequestParameterMap().get("id"));
//        for (GenreEntity g:b.getGenre()) {
////            selectedForEdit.clone(selectedForEdit String.valueOf(g.getId()));
//            List<String> s= new ArrayList<>();
//            s.add(String.valueOf(selectedForEdit));
//            selectedForEdit = (String[]) s.toArray();
//        }
//    }

    public String[] getSelectedForEdit() {
        return selectedForEdit;
    }

    public void setSelectedForEdit(String[] selectedForEdit) {
        this.selectedForEdit = selectedForEdit;
    }

    public String[] getSelectedA() {
        return selectedA;
    }

    public void setSelectedA(String[] selectedA) {
        this.selectedA = selectedA;
    }
}
