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


import oracle.sql.ArrayDescriptor;
import oracle.sql.ARRAY;
import oracle.jdbc.OracleTypes;

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


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import javax.persistence.PersistenceException;
import javax.persistence.ParameterMode;
import javax.persistence.QueryTimeoutException;
import javax.persistence.StoredProcedureQuery;

//import org.json.simple.JSONArray;
import java.io.IOException;

public class InsertT1 implements Serializable{
   public InsertT1 (){
		try
    {
        // Create the SessionFactory from hibernate.cfg.xml
        System.out.println("  constructor");
    }
    catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }

	}

	public  JSONArray   getSdo(int mp_id) {
		// TODO Auto-generated method stub

	     List<Object[]> query;
	     JSONObject json = new JSONObject();
	     org.hibernate.Session s = null;
	     //Session s = null;
		String Table_Name = "TEST_LDR";
		Configuration cfg = new  Configuration();
		System.out.println("new  Configuration() InsertT1");
		/*
		 File pf = new File(System.getProperty("/WEB-INF/"), "foo.properties");
		 InputStream inStream=null;
		inStream = this.getClass().getClassLoader().getResourceAsStream("WEB-INF/foo.properties");
;//new FileInputStream(pf);
		System.out.println(inStream + "...............");
		Properties props = new Properties();
		try {
			props.load(inStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String user = props.getProperty("user");
		System.out.println(user + "...............");
		*/
		try {
			cfg.configure("Hibernate.cfg.xml");
			System.out.println("Hibernate.cfg.xml");
		}
		catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			 System.out.println("Exception InsertT1 cfg.configure  ->>");
	 			 e.printStackTrace();
	 	}
		//cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@192.168.0.130:1527:ZMPR");
		SessionFactory sf =  cfg.buildSessionFactory();
	  s =  sf.openSession();
		//try {
		org.hibernate.Transaction   tx = null;
		tx = s.beginTransaction();
                //} catch (IOException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		System.out.println("s.beginTransaction()");

/*		SQLQuery query = s.createSQLQuery("select  personid, FirstName, LastName,Address, City from test.t1");
		List<t1 []> rows = query.list();
		for(Object[] row : rows){
			t1 T =new t1();
			T.setPersonid(Integer.valueOf( row[0].toString()) );
			T.setFirstName(row[1].toString());
			T.setLastName(row[2].toString());
			T.setAddress(row[3].toString());
			T.setCity(row[4].toString());

			System.out.println(T.getPersonid() + " " + T.getFirstName() + " "
					+ T.getLastName() + " " + T.getAddress() + " " + T.getCity());
		}
	*/
		int id =mp_id;
		///////String hql = "from t1 where  mp_db_id = " +mp_id;
		//////Query hquery = s.createQuery(hql);

		JSONArray jarray = new JSONArray();
		query =( List<Object[]> ) s.createSQLQuery("select /*c.mp_id,*/ t.X,t.Y,t.Z  FROM test_ldr  c, TABLE(SDO_UTIL.GETVERTICES(c.shape)) t"+
		" where c.mp_id = " + id ).list();

	//	List<t1> listCategories = (List<t1>) query.list();
		//////////t1 TT = new t1();
		//System.out.println(listCategories);
		System.out.println("Start iterate..");

	//	JSONObject item = new JSONObject();
		JSONObject  coords = new JSONObject();
		Integer c=0;
		JSONObject item = null;
		for(Object[] person : query) {
		//	java.math.BigDecimal id1 = (java.math.BigDecimal) person[0];
			///java.math.BigDecimal id1 = (java.math.BigDecimal) person[0];
			java.math.BigDecimal x1 = (java.math.BigDecimal) person[0];
			java.math.BigDecimal y1 = (java.math.BigDecimal) person[1];
		    System.out.println("X: " + x1 + "Y: " + y1);
		    try {
		    	 item = new JSONObject();
		    	//JSONObject item = new JSONObject();
		    	 	item.put ("X",x1 );
				 item.append ("Y", y1);
				//item.append(key, value);
				System.out.println("item: "  + item);

				c++;
				////System.out.println("jarray: "  +jarray );
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				 System.out.println("JSONException  passiert!!!!");
				e.printStackTrace();
			}
		    jarray.put(item);
		}
		//jarray.put (item);

		//System.out.printf("json array: %s \n", jarray.toString());
		/*for (t1 aCategory : listCategories) {
			System.out.println("Iteraret...");
			TT.setX(aCategory.getX());
			TT.setY(aCategory.getY());
			TT.setZ(aCategory.getZ());
//			TT.setShape(aCategory.getShape());
			//System.out.println(TT);
		    System.out.println(" "+aCategory.getX()+ " " +aCategory.getY()  );
		}*/
		System.out.println("End iterate..");

		//Transaction tx = s.beginTransaction();
	/*	t1 T1 =  new t1();
		T1.setPersonid(2);
		T1.setFirstName("Fred");
		T1.setLastName("Astair");
		T1.setAddress("Grillparzerstrasse 21");
		T1.setCity("Darmstadt");
		try {
			s.save(T1);
			s.flush();
			tx.commit();
		}catch (ConstraintViolationException e) {
		    System.out.println("Insert Error; "+e);
		    tx.rollback();
		}
		*/

		s.close();
		sf.close();
		 System.out.println("jarray: "  +jarray );
		return  jarray;
	}


	public  JSONArray   getIntersec(int mp_id1, int mp_id2 ) {
		// TODO Auto-generated method stub

	     List<Object[]> query;
	     JSONObject json = new JSONObject();
	     org.hibernate.Session s = null;
	     //Session s = null;
		String Table_Name = "TEST_LDR";
		Configuration cfg = new  Configuration();
		System.out.println("new  Configuration()");

		cfg.configure("Hibernate.cfg.xml");
		System.out.println("Hibernate.cfg.xml");
		//cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@192.168.0.130:1527:ZMPR");
		SessionFactory sf =  cfg.buildSessionFactory();
	        s =  sf.openSession();
		//try {
		org.hibernate.Transaction   tx = null;
		tx = s.beginTransaction();
                //} catch (IOException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		System.out.println("s.beginTransaction()");

		int id1 =mp_id1;

		int id2 =mp_id2;



		///query = s.createSQLQuery("SELECT X, Y, Z FROM (TABLE(SDO_UTIL.GETVERTICES(  (  SELECT SDO_GEOM.SDO_INTERSECTION(  (select a.shape from test_ldr a where mp_id=13)     ,(select b.shape from test_ldr b  where mp_id=12),  0.05)  FROM DUAL ) )  ) ) " + id1 ).list();


		JSONArray jarray = new JSONArray();

		query = (List<Object[]>) s.createSQLQuery(" SELECT X, Y, Z FROM (TABLE(SDO_UTIL.GETVERTICES(  (  SELECT SDO_GEOM.SDO_INTERSECTION(  (select a.shape from test_ldr a where mp_id="+id1+")     ,(select b.shape from test_ldr b  where mp_id="+id2+"),  0.00000000000000000005)  FROM DUAL ) )  ) ) ").list();

		//System.out.println(listCategories);
		System.out.println("Start iterate..");
		////JSONArray jarray = new JSONArray();


		Integer c=0;
		JSONObject item = null;

		for(Object[] person : query) {

		   java.math.BigDecimal x1 = (java.math.BigDecimal) person[0];
		   java.math.BigDecimal y1 = (java.math.BigDecimal) person[1];
		    System.out.println("X: " + x1 + "Y: " + y1);
		    try {
		   	 	 item = new JSONObject();

		   	 	 item.put ("X",x1 );
				 item.put	 ("Y", y1);
				//item.append(key, value);
				System.out.println("item: "  + item);
				c++;
				/////System.out.println("jarray: "  +jarray );
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				 System.out.println("JSONException  passiert!!!!");
				e.printStackTrace();
			}
		    jarray.put(item);
		}



		//System.out.printf("json array: %s \n", jarray.toString());
		System.out.println("End iterate..");


		s.close();
		sf.close();
		System.out.println("jarray: "  +jarray );
		return  jarray;
	}

    private static  EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "JPADemo";

/*
   static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
*/

    // This Method Is Used To Retrieve The 'EntityManager' Object
    public static EntityManager getEntityManager() {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emFactoryObj.createEntityManager();
    }

	public  int   getGeoType(int mp_id1, int mp_id2 ) {

	     EntityManager entityMgr = emFactoryObj.createEntityManager();/// getEntityManager();
	     List<Object[]> query;

	     org.hibernate.Session s = null;

		Configuration cfg = new  Configuration();
		System.out.println("new  Configuration()");

		cfg.configure("Hibernate.cfg.xml");
		System.out.println("Hibernate.cfg.xml");

		SessionFactory sf =  cfg.buildSessionFactory();
	        s =  sf.openSession();
		//try {
		org.hibernate.Transaction   tx = null;
		tx = s.beginTransaction();

		System.out.println("s.beginTransaction()");
		Double id1 =Double.valueOf(mp_id1);
		Double id2 =Double.valueOf(mp_id2);

		 StoredProcedureQuery storedProcedure = entityMgr.createStoredProcedureQuery("RR_TEST.getgtype");
		// set parameters
		storedProcedure.registerStoredProcedureParameter("id1", Double.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("id2", Double.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("GT", Double.class, ParameterMode.OUT);
		storedProcedure.setParameter("id1", 11);
		storedProcedure.setParameter("id2", 12);
		// execute SP
		storedProcedure.execute();
		// get result
		Double  gt = (Double)storedProcedure.getOutputParameterValue("GT");
		System.out.println("GR=" +  (int) Math.round(gt) );

		entityMgr.clear();

		//System.out.printf("json array: %s \n", jarray.toString());
		System.out.println("End iterate..");


		s.close();
		sf.close();

		return  (int) Math.round(gt);
	}




}
