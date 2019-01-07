package com.address.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.model.AddressDAO;
import com.address.model.AddressDTO;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/address/insert.do")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String zipcode = request.getParameter("zipcode");
		String tell = request.getParameter("tell");
		AddressDTO ad = new AddressDTO();
		ad.setName(name);
		ad.setAddr(addr);
		ad.setZipcode(zipcode);
		ad.setTell(tell);
		
		request.setAttribute("ad", ad);
		AddressDAO dao = AddressDAO.getInstance();
		dao.addressInsert(ad);
		response.sendRedirect("list.do");//sendRedirect �� �̵��� ���� list.do�̿��� ��ü���Ⱑ ����Ǹ鼭 addressList.jsp �������� �Ѿ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
