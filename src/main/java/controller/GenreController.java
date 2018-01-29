package controller;


import entities.GenreEntity;
import interfaces.IGenreBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class GenreController {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private GenreEntity genreEntity = new GenreEntity();
    private List<GenreEntity> editGenre = new ArrayList<GenreEntity>();
    private String error;

    @EJB
    IGenreBean genreBean;

    public List<GenreEntity> getAllGenres() {
        List<GenreEntity> genres = genreBean.getAllGenre();
        editGenre = genres;
        return genres;
    }

    public GenreEntity getGenreEntity() {
        return genreEntity;
    }

    public void setGenreEntity(GenreEntity genreEntity) {
        this.genreEntity = genreEntity;
    }

    public void saveGenre(GenreEntity genreEntity) {
        genreBean.insertGenre(genreEntity.getName());
        setGenreEntity(null);
    }

    public void deleteGenre(GenreEntity genreEntity) {


        try {
            genreBean.deleteGenre(genreEntity);
        } catch (javax.ejb.EJBTransactionRolledbackException e) {
            error = "Author unable to delete! Entity has book associations";
        }
    }

    public List<GenreEntity> getEditGenre() {
        return editGenre;
    }

    public void setEditGenre(List<GenreEntity> editGenre) {
        this.editGenre = editGenre;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
