package com.rr.inter;

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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class inter
 */
@WebServlet("/inter")
public class inter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static  String user = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inter() {
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
		
		String sid = request.getParameter("chnr");
		System.out.println(sid + " chnr...............");
		String sidr = request.getParameter("chnrr");
		System.out.println(sid + " chnrr...............");
		InsertT1 t1 =  new InsertT1();
		JSONArray a= new JSONArray();
		JSONArray b= new JSONArray();
		JSONArray c= new JSONArray();
		int geoType = 0;
		try {
			a =t1.getSdo(Integer.parseInt(sid));
			b = t1.getSdo(Integer.parseInt(sidr));
			c =t1.getIntersec(Integer.parseInt(sid),Integer.parseInt(sidr));
			geoType = t1.getGeoType(Integer.parseInt(sid),Integer.parseInt(sidr));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("JSONException von getSdo");
			e.printStackTrace();
		}

		cp();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("c=>" +  c);
		System.out.println("Inter->" + "[" + a + "," + b + "," + c +"]");
		System.out.println("geoType=>" + geoType);
		response.getWriter().print("[" + a + "," + b + "," + c +"]");
		//response.getWriter().append("Post resp  " );
	}
	
	protected void cp(){
				Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			 ///final BasicDataSource ds = new BasicDataSource();			
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
			
			
			con = ds.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select mp_id  from test_ldr");
			
			System.out.println("java:/comp/env/jdbc/MyLocalDB");
            
            
		}catch(NamingException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				////rs.close();
				stmt.close();
				con.close();
				ctx.close();
			} catch (SQLException e) {
				System.out.println("Exception in closing DB resources");
			} catch (NamingException e) {
				System.out.println("Exception in closing Context");
			}
			
		}

	}

}
