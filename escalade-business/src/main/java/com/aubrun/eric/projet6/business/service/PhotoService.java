package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.PhotoDAO;
import com.aubrun.eric.projet6.model.bean.Photo;

public class PhotoService {

    private PhotoDAO photoDAO = new PhotoDAO();

    public List<Photo> findAll() {

        List<Photo> photo = photoDAO.recupererPhotos();
        return photo;
    }

    public Photo findDetails( Integer id ) {

        Photo photo = photoDAO.afficherDetails( id );
        return photo;
    }

    public void addPhoto( Photo addPhoto ) {

        photoDAO.ajouterPhoto( addPhoto );
    }

    public Photo deletePhoto( Integer id ) {

        Photo photo = photoDAO.supprimerPhoto( id );
        return photo;
    }
}