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
    public static final String VUE              = "/WEB-INF/jsp/messageDeReservation.jsp";

    private MessageService     messageService   = new MessageService();
    private TopoService        topoService      = new TopoService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Integer idTopo = Integer.parseInt( request.getParameter( "idDispo" ) );

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        request.setAttribute( "idDispo", idTopo );
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

        Integer idTopo = Integer.parseInt( request.getParameter( "idDispo" ) );
        Message reservedMessage = new Message();
        Topo topoDispo = topoService.findDetails( idTopo );
        reservedMessage.getDestinataire();
        reservedMessage.setTopo( topoDispo );
        reservedMessage.setMessage( request.getParameter( "message" ) );
        reservedMessage.setEmetteur( connectedUser );
        messageService.reserveMessage( reservedMessage );

        request.setAttribute( ATT_MESSAGE, reservedMessage );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}