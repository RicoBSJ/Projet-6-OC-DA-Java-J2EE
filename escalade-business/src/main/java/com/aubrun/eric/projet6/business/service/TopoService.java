package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.TopoDAO;
import com.aubrun.eric.projet6.model.bean.SearchFormTopo;
import com.aubrun.eric.projet6.model.bean.Topo;

public class TopoService {

    private TopoDAO topoDAO = new TopoDAO();

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

    public void addTopo( Topo createTopo ) {

        topoDAO.ajouterTopo( createTopo );
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

}
