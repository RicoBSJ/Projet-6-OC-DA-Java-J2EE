package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.TopoDAO;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class TopoService {

    private TopoDAO        topoDAO        = new TopoDAO();
    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public List<Topo> findAll() {

        List<Topo> topo = topoDAO.recupererTopos();
        return topo;
    }

    public Topo findDetails( Integer id ) {

        return topoDAO.afficherDetails( id );
    }

    public List<Topo> findDetailsToposUser( Integer id ) {

        Utilisateur utilisateur = utilisateurDAO.afficherParId( id );
        return topoDAO.recupererToposUtilisateur( utilisateur );
    }

    public List<Topo> findToposByAvailability( Integer id ) {

        Utilisateur connectedUser = utilisateurDAO.afficherParId( id );
        return topoDAO.recupererToposDisponibles( connectedUser );
    }

    public void addTopo( Topo createTopo ) {

        createTopo.setDisponible( true );
        topoDAO.ajouterTopo( createTopo );
    }

    public void deleteTopo( Integer idTopo ) {

        topoDAO.supprimerTopo( idTopo );
    }

    public void modifyTopo( Topo topoToModify ) {

        topoDAO.modifierTopo( topoToModify );
    }

    public void topoState( Integer idTopo ) {

        Topo topo = topoDAO.afficherDetails( idTopo );
        if ( topo.getDisponible() == true ) {
            topo.setDisponible( false );
        } else {
            topo.setDisponible( true );
        }
        topoDAO.modifierTopo( topo );
    }
}
