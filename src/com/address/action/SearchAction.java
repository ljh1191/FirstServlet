package com.address.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.address.model.AddressDAO;
import com.address.model.AddressDTO;

/**
 * Servlet implementation class SearchAction
 */
@WebServlet("/address/search.do")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String field = request.getParameter("field");
		String word = request.getParameter("word");
		AddressDAO dao = AddressDAO.getInstance();
		ArrayList<AddressDTO> arr = dao.addressSearch(field,word);
		int count = dao.addressSearchCount(field, word);
		request.setAttribute("arr", arr);
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
