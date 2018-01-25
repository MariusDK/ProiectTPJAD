package controller;


import entities.GenreEntity;
import interfaces.IGenreBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean
public class GenreController {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private GenreEntity genreEntity = new GenreEntity();
    private List<GenreEntity> editGenre = new ArrayList<GenreEntity>();

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
        genreBean.deleteGenre(genreEntity);
    }

    public List<GenreEntity> getEditGenre() {
        return editGenre;
    }

    public void setEditGenre(List<GenreEntity> editGenre) {
        this.editGenre = editGenre;
    }
}
