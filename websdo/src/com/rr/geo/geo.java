package com.rr.geo;

import java.util.List;
import java.util.Properties;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.Query;

import oracle.jdbc.driver.OracleConnection;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.STRUCT;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.svenson.converter.JSONConverter;


import hibernatetuto1.InsertT1;

/**
 * Servlet implementation class geo
 */
@WebServlet("/geo")
public class geo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static  String user = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public geo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		//ServletContext application=getServletConfig().getServletContext();
		System.out.println("iStream:"+getServletConfig().getServletContext().getResourceAsStream("WEB-INF/foo.properties"));
		props.load(getServletContext().getResourceAsStream("WEB-INF/foo.properties"));
		user = props.getProperty("user");
		System.out.println(user + "...............");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props = new Properties();
		//System.out.println("iStream:"+getServletConfig().getServletContext().getResourceAsStream("WEB-INF/foo.properties"));
		/////props.load(getServletContext().getResourceAsStream("WEB-INF/foo.properties"));
		/////user = props.getProperty("user");
		/////System.out.println(user + "...............");
    InsertT1 t1 =  null;
		String sid = request.getParameter("chnr");
		System.out.println(sid + " chnr...............");
		String sidr = request.getParameter("chnrr");
		System.out.println(sid + " chnrr...............");
		try {
			 t1 =  new InsertT1();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("Exception new InsertT1()  ->>");
			 e.printStackTrace();
		}
		JSONArray a= new JSONArray();
		JSONArray b= new JSONArray();
		try {
			a =t1.getSdo(Integer.parseInt(sid));
			//a =t1.getIntersec(Integer.parseInt(sid),Integer.parseInt(sidr));
			b = t1.getSdo(Integer.parseInt(sidr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("JSONException von getSdo");
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("s" +  a);
		 response.getWriter().print("[" + a + "," + b + "]");
		//response.getWriter().append("Post resp  " );
	}

}
