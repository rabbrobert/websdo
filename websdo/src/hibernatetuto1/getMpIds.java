package hibernatetuto1;

import java.util.List;
import java.util.Properties;

//import org.hibernate.Session;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import oracle.sql.STRUCT;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class getMpIds implements Serializable{

	public  JSONArray   getMpid() {
		// TODO Auto-generated method stub

   	List<java.math.BigDecimal[]> query;
   	JSONObject json = new JSONObject();
   	org.hibernate.Session s = null;
	 	SessionFactory sf = null;
		Configuration cfg = null;
	   //Session s = null;
		String Table_Name = "TEST_LDR";
		try {
		   cfg = new  Configuration();
		}
		catch (Exception e) {
 			// TODO Auto-generated catch block
 			 System.out.println("Exception buildSessionFactory ->>");
 			e.printStackTrace();
 		}
		System.out.println("new  Configuration()");
		cfg.configure("Hibernate.cfg.xml");
		System.out.println("Hibernate.cfg.xml");
		//cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@192.168.0.130:1527:ZMPR");
		try {
		  sf =  cfg.buildSessionFactory();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("Exception buildSessionFactory ->>");
			 e.printStackTrace();
		}

		System.out.println("cfg.buildSessionFactory() is done");
    try {
			s =  sf.openSession();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println("Exception openSession ->>");
			 e.printStackTrace();
		}
		System.out.println("sf.openSession() is done->>");

		//try {
		org.hibernate.Transaction   tx = null;
		tx = s.beginTransaction();
                //} catch (IOException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		System.out.println("s.beginTransaction()");


		//String hql = "from t1 where  mp_db_id = " +mp_id;
		//Query hquery = s.createQuery(hql);


		query = s.createSQLQuery("select DISTINCT c.mp_id  FROM test_ldr c order by c.mp_id" ).list();

		t1 TT = new t1();
		//System.out.println(listCategories);
		System.out.println("Start iterate..");
		JSONArray jarray = new JSONArray();
	//	JSONObject item = new JSONObject();
		JSONObject  coords = new JSONObject();
		Integer c=0;
		JSONObject item = null;
		System.out.println("Start iterate.. query:" + query);


		 for (int i = 0; i < query.size(); i++) {

        		 jarray.put(query.get(i));
     		 }
		/*
		for (int i = 0; i < query.size(); i++) {
                    java.math.BigDecimal  mpid;
                    System.out.println("Start iterate.. query.get(i):" + query.get(i));
                    System.out.println("Start iterate.. query.get(i)[0]:" + query.get(i)[0]);
                    mpid =   (java.math.BigDecimal) query.get(i)[0];
		    System.out.println("Start iterate.. mpid:" + mpid);
                    System.out.println(" Object : " +  mpid);
		    java.math.BigDecimal id = (java.math.BigDecimal) mpid;
		    System.out.println("Start iterate.. id:" + id);

		    System.out.println("id: " + id);
		    try {
		    	  item = new JSONObject();
		    	 //JSONObject item = new JSONObject();
		    	  item.put ("MP_ID",id );
			 //item.append(key, value);
			  System.out.println("item: "  + item);
			  c++;
			  System.out.println("jarray: "  +jarray );
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				 System.out.println("JSONException  passiert!!!!");
				e.printStackTrace();
			}
		    jarray.put(item);
		}
		*/
		//jarray.put (item);
		System.out.println("End iterate..");

		s.close();
		sf.close();
		System.out.println("jarray: "  +jarray );
		return  jarray;
	}



}
