package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.UtilisateurService;

@WebServlet( "/listeUtilisateurs" )
public class ListeUtilisateurs extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    public static final String VUE                = "/WEB-INF/jsp/listeUtilisateurs.jsp";

    private UtilisateurService utilisateurService = new UtilisateurService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /*
         * À la réception d'une requête GET, affichage de la liste des clients
         */
        request.setAttribute( "utilisateurs", utilisateurService.findAll() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }
}