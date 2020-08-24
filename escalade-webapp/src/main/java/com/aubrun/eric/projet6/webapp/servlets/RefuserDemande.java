package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.MessageService;
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

/**
 * Servlet implementation class RefuserDemande
 */
@WebServlet( "/refuserDemande" )
public class RefuserDemande extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String VUE_MESSAGE      = "/WEB-INF/jsp/afficherMessagesUtilisateur.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    private MessageService     messageService   = new MessageService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();

        }

        Integer idMessage = Integer.parseInt( request.getParameter( "id" ) );
        Message refuseMessage = messageService.findDetails( idMessage );
        messageService.refuseRequest( refuseMessage.getId() );
        
        request.setAttribute( "message", messageService.findDetails( idMessage ) );
        request.setAttribute( "message", messageService.findDetailsMessagesUser( connectedUser.getId() ) );

        this.getServletContext().getRequestDispatcher( VUE_MESSAGE ).forward( request, response );
    }
}