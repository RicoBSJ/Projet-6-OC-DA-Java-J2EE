package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.MessageService;
import com.aubrun.eric.projet6.business.service.TopoService;
import com.aubrun.eric.projet6.consumer.DAO.TopoDAO;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/accepterDemandeReservation" )
public class AccepterDemandeReservation extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_MESSAGE      = "message";
    public static final String VUE              = "/WEB-INF/jsp/afficherToposDisponibles.jsp";

    private TopoDAO            topoDAO          = new TopoDAO();
    private UtilisateurDAO     utilisateurDAO   = new UtilisateurDAO();
    private MessageService     messageService   = new MessageService();
    private TopoService        topoService      = new TopoService();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        Integer idTopo = Integer.parseInt( request.getParameter( "idDispo" ) );
        Integer id = Integer.parseInt( request.getParameter( "idUser" ) );
        Topo topo = topoDAO.afficherDetails( idTopo );
        Utilisateur user = utilisateurDAO.afficherParId( id );
        topo.setUtilisateur( user );
        messageService.acceptRequest( id, idTopo );

        request.setAttribute( "topos", topoService.findToposByAvailability() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}