package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.MessageDAO;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class MessageService {

    private MessageDAO     messageDAO     = new MessageDAO();
    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private TopoService    topoService    = new TopoService();

    public List<Message> findAll() {

        List<Message> message = messageDAO.recupererMessages();
        return message;
    }

    public Message findDetails( Integer id ) {

        return messageDAO.afficherDetails( id );
    }

    public List<Message> findDetailsMessagesUser( Integer id ) {

        Utilisateur user = utilisateurDAO.afficherParId( id );
        return messageDAO.recupererMessagesUtilisateur( user );
    }

    public void addMessage( Message createMessage ) {

        messageDAO.ajouterMessage( createMessage );
    }

    public void deleteMessage( Integer idMessage ) {

        messageDAO.supprimerMessage( idMessage );
    }

    public void modifyMessage( Message messageToModify ) {

        messageDAO.modifierMessage( messageToModify );
    }

    public void reserveMessage( Message reservedMessage ) {

        messageDAO.reservationMessage( reservedMessage );
    }

    public void acceptRequest( Integer idTopo, Integer id ) {

        topoService.topoState( idTopo );
        Message acceptMessage = messageDAO.afficherDetails( id );
        acceptMessage.setStatut( true );
        messageDAO.accepterDemande( acceptMessage );
        messageDAO.supprimerMessage( id );
    }
    
    public void refuseRequest( Integer id ) {

        Message refuseMessage = messageDAO.afficherDetails( id );
        refuseMessage.setStatut(false);
        messageDAO.supprimerMessage( refuseMessage.getId() );
    }
}