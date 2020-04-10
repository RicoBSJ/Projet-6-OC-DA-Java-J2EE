package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.UtilisateurService;

/**
 * Servlet implementation class UtilisateurParId
 */
@WebServlet( "/UtilisateurParId" )
public class UtilisateurParId extends HttpServlet {

    private static final long               serialVersionUID   = 1L;

    public static final String              VUE                = "/WEB-INF/jsp/utilisateurParId.jsp";

    private static final UtilisateurService utilisateurService = new UtilisateurService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( "utilisateurs", utilisateurService.findById( null ) );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
