package com.shweta.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shweta.hibernate.util.HibernateUtil;
import com.shweta.hibernate.util.HibernateUtil2;
import com.shweta.model.EProduct;
import com.shweta.model.Items;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/item-details")
public class ItemDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetails() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Print writer
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// open session
		try {
		SessionFactory sFactory = HibernateUtil2.buildSessionFactory();
		Session session = sFactory.openSession();
		session.beginTransaction();
		
		List<Items>  items = session.createQuery("from Items").list();
		
		out.println("<h1>Product details are :</h1>");
		for(Items i : items) {
			out.print("Id :-> "+i.getItemId()+" Name :-> "+i.getItemName()+" Price :-> "+i.getTotalPrice()+ " Quantity :-> "+i.getQuantity());
			
			out.print("<br>-------------------------------------------------------------------------------------<br>");
		}
		session.close();
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
