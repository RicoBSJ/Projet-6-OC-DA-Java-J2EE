package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.TopoService;

@WebServlet( "/AfficherTopo" )
public class AfficherTopo extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String VUE              = "/WEB-INF/jsp/afficherTopo.jsp";

    private TopoService        topoService      = new TopoService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        Integer id = Integer.parseInt( request.getParameter( "id" ) );
        request.setAttribute( "topo", topoService.findDetails( id ) );
        request.getParameter( getServletName() );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}