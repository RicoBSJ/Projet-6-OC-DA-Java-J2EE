package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.MessageDAO;
import com.aubrun.eric.projet6.consumer.DAO.TopoDAO;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.SearchFormMessage;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class MessageService {

    private MessageDAO     messageDAO     = new MessageDAO();
    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private TopoDAO        topoDAO        = new TopoDAO();

    public List<Message> findAll() {

        List<Message> message = messageDAO.recupererMessages();
        for ( Message s : message ) {
            System.out.println( s );
        }
        return message;
    }

    public Message findDetails( Integer id ) {

        return messageDAO.afficherDetails( id );
    }

    public List<Message> findDetailsMessagesUser( Integer id ) {

        Utilisateur utilisateur = utilisateurDAO.afficherParId( id );
        return messageDAO.recupererMessagesDeLUtilisateur( utilisateur );
    }

    public List<Message> findMessagesByAvailability() {

        return messageDAO.recupererMessagesDisponibles();
    }

    public void addMessage( Message createMessage ) {

        messageDAO.ajouterMessage( createMessage );
    }

    public void deleteMessage( Integer idMessage ) {

        messageDAO.supprimerMessage( idMessage );
    }

    public List<Message> searchMessage( SearchFormMessage searchFormMessage ) {

        return messageDAO.recherche( searchFormMessage );
    }

    public void modifyMessage( Message messageToModify ) {

        messageDAO.modifierMessage( messageToModify );
    }

    public void reserveMessage( Message reservedMessage ) {

        messageDAO.reservationMessage( reservedMessage );
    }
}