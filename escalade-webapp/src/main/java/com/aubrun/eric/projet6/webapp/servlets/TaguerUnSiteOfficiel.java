package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/TaguerUnSiteOfficiel" )
public class TaguerUnSiteOfficiel extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    /* Constantes */
    public static final String VUE              = "/WEB-INF/jsp/detailsSite.jsp";

    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    private SiteService        siteService      = new SiteService();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();

        }

        Integer idSite = Integer.parseInt( request.getParameter( "idSite" ) );
        siteService.tagOfficialSite( idSite );

        request.setAttribute( "site", siteService.findDetails( idSite ) );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}