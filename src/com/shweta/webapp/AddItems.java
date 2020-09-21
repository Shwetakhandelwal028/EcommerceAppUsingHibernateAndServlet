package com.shweta.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shweta.hibernate.util.HibernateUtil;
import com.shweta.model.EProduct;
import com.shweta.model.Items;

/**
 * Servlet implementation class AddItems
 */
@WebServlet("/add-item")
public class AddItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItems() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("add-items.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("pname");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		try {
			SessionFactory sFactory = HibernateUtil.buildSessionFactory();
			Session session = sFactory.openSession();
			Transaction trans = session.beginTransaction();
			
			Items item = new Items();
			item.setItemName(name);
			item.setTotalPrice(Double.valueOf(price));
			item.setQuantity(Integer.valueOf(quantity));
			session.save(item);
			
			trans.commit();
			
			
			session.close();
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
