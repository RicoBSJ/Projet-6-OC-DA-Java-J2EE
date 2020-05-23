package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.CommentaireDAO;
import com.aubrun.eric.projet6.model.bean.Commentaire;
import com.aubrun.eric.projet6.model.bean.SearchFormCom;

public class CommentaireService {

    private CommentaireDAO commentaireDAO = new CommentaireDAO();

    public List<Commentaire> findAll() {

        List<Commentaire> commentaire = commentaireDAO.recupererCommentaires();
        for ( Commentaire c : commentaire ) {
            System.out.println( c );
        }
        return commentaire;
    }

    public Commentaire findDetails( Integer idCommentaire ) {

        return commentaireDAO.afficherDetails( idCommentaire );
    }

    public void addCommentaire( Commentaire createCommentaire ) {

        commentaireDAO.ajouterCommentaire( createCommentaire );
    }

    public void deleteCommentaire( Integer idCommentaire ) {

        commentaireDAO.supprimerCommentaire( idCommentaire );
    }

    public List<Commentaire> searchCommentaire( SearchFormCom searchFormCom ) {

        return commentaireDAO.recherche( searchFormCom );
    }

    public void modifyComment( Commentaire commentToModidy ) {

        commentaireDAO.modifierCommentaire( commentToModidy );
    }

}