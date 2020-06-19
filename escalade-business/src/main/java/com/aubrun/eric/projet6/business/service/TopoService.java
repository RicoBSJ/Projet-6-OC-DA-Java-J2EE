package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.TopoDAO;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.SearchFormTopo;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class TopoService {

    private TopoDAO        topoDAO        = new TopoDAO();
    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private Topo           topo           = new Topo();

    public List<Topo> findAll() {

        List<Topo> topo = topoDAO.recupererTopos();
        for ( Topo s : topo ) {
            System.out.println( s );
        }
        return topo;
    }

    public Topo findDetails( Integer id ) {

        return topoDAO.afficherDetails( id );
    }

    public List<Topo> findDetailsToposUser( Integer id ) {

        Utilisateur utilisateur = utilisateurDAO.afficherParId( id );
        return topoDAO.recupererToposDeLUtilisateur( utilisateur );
    }

    public List<Topo> findToposByAvailability( Boolean toposDisponibles ) {

        List<Topo> topos = topoDAO.recupererTopos();
        for ( Topo s : topos ) {
            if ( s.getDisponible() == true ) {
                topos = topoDAO.recupererToposDisponibles( toposDisponibles );
            }
        }
        return topos;
    }

    public void addTopo( Integer id, Topo createTopo ) {

        Topo topo = topoDAO.afficherDetails( id );
        topo.setNom( createTopo.getNom() );
        topo.setDescription( createTopo.getDescription() );
        topo.setLieu( createTopo.getLieu() );
        topo.setDateParution( createTopo.getDateParution() );
        topo.setDisponible( createTopo.getDisponible() );
        topoDAO.ajouterTopo( topo );
    }

    public void deleteTopo( Integer idTopo ) {

        topoDAO.supprimerTopo( idTopo );
    }

    public List<Topo> searchTopo( SearchFormTopo searchFormTopo ) {

        return topoDAO.recherche( searchFormTopo );
    }

    public void modifyTopo( Topo topoToModify ) {

        topoDAO.modifierTopo( topoToModify );
    }

    public void reserveTopo( Topo reservedTopo ) {

        topoDAO.reserverTopo( reservedTopo );
        topo.setDisponible( false );
    }
}
