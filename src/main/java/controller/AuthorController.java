package controller;


import entities.AuthorEntity;
import entities.GenreEntity;
import interfaces.IAuthorBean;
import interfaces.IGenreBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean
public class AuthorController {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private AuthorEntity authorEntity = new AuthorEntity();
    private List<AuthorEntity> editAuthor = new ArrayList<AuthorEntity>();
    private AuthorEntity author = new AuthorEntity();

    @EJB
    IAuthorBean authorBean;

    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> authors = authorBean.getAllAuthors();
        editAuthor = authors;
        return authors;
    }

    public void saveAuthor(AuthorEntity entity) {
        authorBean.insertAuthor(entity.getName());
        setAuthorEntity(null);
    }

    public void deleteAuthor(AuthorEntity authorEntity) {
        authorBean.deleteAuthor(authorEntity);
    }


    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    public List<AuthorEntity> getEditAuthor() {
        return editAuthor;
    }

    public void setEditAuthor(List<AuthorEntity> editAuthor) {
        this.editAuthor = editAuthor;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public AuthorEntity getAuthorEntity(Integer id) {
        author.setId(authorBean.findAuthor(id).getId());
        author.setName(authorBean.findAuthor(id).getName());
        return author;
    }

    public void updateAuthor(AuthorEntity a) {
        authorBean.updateAuthor(a);
    }

    public void updateAuthor(Integer id, String newName) {

        AuthorEntity ae = getAuthorEntity(id);
        ae.setName(newName);
        authorBean.updateAuthor(ae);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "Author.xhtml");
    }
}
