package controller;


import entities.GenreEntity;
import interfaces.IGenreBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean
public class GenreEditController {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    private GenreEntity genre = new GenreEntity();

    @EJB
    IGenreBean genreBean;

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public GenreEntity getGenreEntity(Integer genreId) {
        genre.setId(genreBean.findGenre(genreId).getId());
        genre.setName(genreBean.findGenre(genreId).getName());
        return genre;
    }

    public void updateGenre(GenreEntity genreEntity) {
        LOGGER.info(String.valueOf(genreEntity.getId()));
        LOGGER.info(String.valueOf(genreEntity.getName()));
        genreBean.updateGenre(genreEntity);
    }

    public void updateGenre(Integer genreId, String newName) {
        LOGGER.info("ID" + String.valueOf(genreId));

        GenreEntity genreEntity = getGenreEntity(genreId);
        genreEntity.setName(newName);
        genreBean.updateGenre(genreEntity);
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "Genre.xhtml");
    }
}
