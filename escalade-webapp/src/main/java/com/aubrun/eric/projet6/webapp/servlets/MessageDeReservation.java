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
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/messageDeReservation" )
public class MessageDeReservation extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_MESSAGE      = "message";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_MESSAGE      = "/WEB-INF/jsp/messageDeReservation.jsp";
    public static final String VUE_DISPO        = "/WEB-INF/jsp/afficherToposDisponibles.jsp";

    private MessageService     messageService   = new MessageService();
    private TopoService        topoService      = new TopoService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        Integer idTopo = Integer.parseInt( request.getParameter( "idDispo" ) );
        Topo topoDispo = topoService.findDetails( idTopo );
        request.setAttribute( "topo", topoDispo );
        this.getServletContext().getRequestDispatcher( VUE_MESSAGE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }
        Integer idTopo = Integer.parseInt( request.getParameter( "idDispo" ) );
        Topo topoDispo = topoService.findDetails( idTopo );
        Message reservedMessage = new Message();
        reservedMessage.setEmetteur( connectedUser );
        reservedMessage.setMessage( request.getParameter( "message" ) );
        reservedMessage.setDestinataire( topoDispo.getUtilisateur() );
        reservedMessage.setTopo( topoDispo );
        messageService.reserveMessage( reservedMessage );

        request.setAttribute( "topos", topoService.findToposByAvailability() );

        this.getServletContext().getRequestDispatcher( VUE_DISPO ).forward( request, response );
    }
}