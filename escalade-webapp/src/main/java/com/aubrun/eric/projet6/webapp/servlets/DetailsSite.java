package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.SiteService;

@WebServlet("/detailsSite")
public class DetailsSite extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/* Constantes */
	public static final String VUE = "/WEB-INF/jsp/detailsSite.jsp";

	private SiteService siteService = new SiteService();

	public DetailsSite() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("sites", siteService.findDetails());

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}