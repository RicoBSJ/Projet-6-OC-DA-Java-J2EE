package com.aubrun.eric.projet6.business.service;

import java.util.Date;
import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.CommentaireDAO;
import com.aubrun.eric.projet6.model.bean.Commentaire;

public class CommentaireService {

    private CommentaireDAO commentaireDAO = new CommentaireDAO();

    public List<Commentaire> findAll() {

        List<Commentaire> commentaire = commentaireDAO.recupererCommentaires();
        return commentaire;
    }

    public Commentaire findDetails( Integer idCommentaire ) {

        return commentaireDAO.afficherDetails( idCommentaire );
    }

    public void addCommentaire( Commentaire createCommentaire ) {

        commentaireDAO.ajouterCommentaire( createCommentaire );
    }

    public void deleteCommentaire( Integer idCommentaire ) {

        Commentaire comment = commentaireDAO.afficherDetails( idCommentaire );
        commentaireDAO.supprimerCommentaire( comment );
    }

    public void modifyComment( Integer id, Commentaire commentToModify ) {
        Commentaire commentaire = commentaireDAO.afficherDetails( id );
        commentaire.setTitre( commentToModify.getTitre() );
        commentaire.setContenu( commentToModify.getContenu() );
        commentaire.setDate( new Date() );
        commentaireDAO.modifierCommentaire( commentaire );
    }
}