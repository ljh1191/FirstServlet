package com.address.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
@WebServlet("/address/search2.do")
public class SearchAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction2() {
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
		JSONArray jarr = new JSONArray();
		for(AddressDTO dto : arr) {
			JSONObject obj = new JSONObject();
			obj.put("num", dto.getNum());
			obj.put("name", dto.getName());
			obj.put("addr", dto.getAddr());
			obj.put("zipcode", dto.getZipcode());
			obj.put("tell", dto.getTell());
			jarr.add(obj);
		}
		JSONObject obj = new JSONObject();
		obj.put("count", count);
		jarr.add(obj);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jarr.toString());
		
//		request.setAttribute("jarr", jarr);
//		
//		response.setContentType("text/html;charset=utf-8");
//		RequestDispatcher rd = request.getRequestDispatcher("addressList.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
