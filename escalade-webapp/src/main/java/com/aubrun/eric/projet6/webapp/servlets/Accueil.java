package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.CommentaireService;
import com.aubrun.eric.projet6.business.service.SiteService;

@WebServlet( "/accueil" )
public class Accueil extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    /* Constantes */
    public static final String VUE                = "/WEB-INF/jsp/accueil.jsp";

    private SiteService        siteService        = new SiteService();
    private CommentaireService commentaireService = new CommentaireService();

    public Accueil() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( "sites", siteService.findAll() );
        request.setAttribute( "commentaires", commentaireService.findAll() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }
}