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
import com.shweta.model.EProduct;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Print writer
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// open session
		try {
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		session.beginTransaction();
		
		List<EProduct>  products = session.createQuery("from EProduct").list();
		
		out.println("<h1>Product details are :</h1>");
		for(EProduct p : products) {
			out.print("Id :-> "+p.getpId()+" Name :-> "+p.getName()+" Price :-> "+p.getPrice()+ 
					" Creation Date :-> "+p.getCreationDate()+" Expire Date :-> "+p.getExpireDate());
			
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
