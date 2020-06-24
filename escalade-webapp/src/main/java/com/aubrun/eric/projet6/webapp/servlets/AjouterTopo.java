package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.business.service.TopoService;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/ajouterTopo" )
public class AjouterTopo extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/jsp/ajouterTopo.jsp";

    private TopoService        topoService      = new TopoService();
    private SiteService        siteService      = new SiteService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }
        request.setAttribute( "topos", topoService.findAll() );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        Topo topo = new Topo();
        topo.setNom( request.getParameter( "nom" ) );
        topo.setDescription( request.getParameter( "description" ) );
        topo.setLieu( request.getParameter( "lieu" ) );
        topo.setDateParution( new Date() );
        topo.setUtilisateur( connectedUser );
        topoService.addTopo( topo );
        request.setAttribute( "sites", siteService.findAll() );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}