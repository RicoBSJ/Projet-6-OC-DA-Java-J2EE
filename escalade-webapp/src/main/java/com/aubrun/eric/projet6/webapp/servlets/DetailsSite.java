package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.CommentaireService;
import com.aubrun.eric.projet6.business.service.SiteService;

@WebServlet( "/DetailsSite" )
public class DetailsSite extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    /* Constantes */
    public static final String VUE                = "/WEB-INF/jsp/detailsSite.jsp";

    private SiteService        siteService        = new SiteService();
    private CommentaireService commentaireService = new CommentaireService();

    public DetailsSite() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter( "id" ) );
        request.setAttribute( "site", siteService.findDetails( id ) );
        request.getParameter( getServletName() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Integer idCommentaire = Integer.parseInt( request.getParameter( "idCommentaire" ) );
        request.setAttribute( "commentaire", commentaireService.findDetails( idCommentaire ) );
        request.getParameter( getServletName() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}