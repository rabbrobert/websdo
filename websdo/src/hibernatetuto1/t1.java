package hibernatetuto1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import oracle.spatial.geometry.JGeometry;

import oracle.sql.STRUCT;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

@XmlRootElement(name = "student")
public class t1 implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String  name;
// private int  mp_db_id ;  
// private oracle.spatial.geometry.JGeometry  shape;
 private int mp_id;
 private int X;
 private int Y;
 private int Z;
 public t1(){
	 
 }
//@XmlAttribute
//public String getName() {
//	return name;
//}
//public void setName(String inname) {
//	this.name = inname;
//}
//
//@XmlAttribute
//public int getMp_db_id() {
//	return mp_db_id;
//}
//public void setMp_db_id(int mp_db_id_in) {
//   this.mp_db_id = mp_db_id_in;
//}
//
@XmlAttribute
public int getMp_id() {
 return  this.mp_id;
}
public void setMp_id(int in_mp_id) {
	this.mp_id = in_mp_id;
}


@XmlAttribute
public int getX() {
 return  this.X;
}
public void setX(int inX) {
	this.X = inX;
}


@XmlAttribute
public int getY() {
 return  this.Y;
}
public void setY(int inY) {
	this.Y = inY;
}

@XmlAttribute
public int getZ() {
 return  this.Z;
}
public void setZ(int inZ) {
	this.Z = inZ;
}

@XmlAttribute
public int getMP_ID() {
 return  this.mp_id;
}
public void setMP_ID(int inMP_ID) {
	this.mp_id = inMP_ID;
}


//@XmlAttribute
//public  JGeometry getShape() {
//	return this.shape;
//}
//public void setShape(JGeometry geom) {
//	this.shape = geom;
//}


 
	
}
