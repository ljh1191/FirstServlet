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
import com.address.model.ZipcodeDTO;

/**
 * Servlet implementation class ZipAction
 */
@WebServlet("/address/zip.do")
public class ZipAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.sendRedirect("zipCheck.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dong = request.getParameter("dong");
		AddressDAO dao = AddressDAO.getInstance();
		ArrayList<ZipcodeDTO> arr = dao.zipList(dong);
		JSONArray jarr = new JSONArray();
		for(ZipcodeDTO dto : arr) {
			JSONObject obj = new JSONObject();
			obj.put("zipcode", dto.getZipcode());
			obj.put("sido", dto.getSido());
			obj.put("gugun", dto.getGugun());
			obj.put("dong", dto.getDong());
			obj.put("bunji", dto.getBunji());
			jarr.add(obj);
		}//action������ �ٷ� ���డ���ؼ� �ݹ龵��� �ٷ� ����ϸ��.  out.println �� ����ϸ� ���� �������Ե�
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jarr.toString());
	}

}
