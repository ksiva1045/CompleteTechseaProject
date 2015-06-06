package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Emp;
import com.support.EmpArray;
import com.support.ProductArray;
import com.support.ProductBean;
import com.support.SessionClass;

public class EmpOperationClass {

	Emp emp;
	EmpArray empArray;
public	EmpOperationClass(Emp emp,EmpArray empArray){
	
	this.emp=emp;
	this.empArray=empArray;
}

public EmpArray insertEmp(Emp emp){
	Session session = SessionClass.getSession();
	session.beginTransaction();
	EmpArray eArray = new EmpArray();
	session.getNamedQuery("insertemp").
    
    setString("empname", emp.getEname()).
    setString("empskill", emp.getEskill()).
    setString("empprodesc", emp.getEpdesc()).
    setString("hiredate", emp.getHiredate()).
    setString("managername", emp.getMname()).
    setString("deptno", emp.getDno()).
    setString("userid", emp.getUid()).
    setString("pswd", emp.getPswd()).
    setString("createduserid", emp.getCuid()).executeUpdate();
	

	try{
		session.getTransaction().commit();
		eArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return eArray;
}

public EmpArray updateEmp(Emp emp){
	Session session = SessionClass.getSession();
	session.beginTransaction();
	EmpArray eArray = new EmpArray();
	 session.getNamedQuery("updateemp").
     setString("empno", emp.getEno()).
     setString("empname", emp.getEname()).
     setString("empskill", emp.getEskill()).
     setString("empprodesc", emp.getEpdesc()).
     setString("hiredate", emp.getHiredate()).
     setString("managername", emp.getMname()).
     setString("deptno", emp.getDno()).
     setString("userid", emp.getUid()).
     setString("pswd", emp.getPswd()).
     setString("lastmodifieduserid", emp.getLmuid()).executeUpdate();
	try{
		session.getTransaction().commit();
		eArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return eArray;

}

public EmpArray deleteEmp(Emp emp){
	Session session = SessionClass.getSession();
	session.beginTransaction();
	EmpArray eArray = new EmpArray();
	
	session.beginTransaction();
    session.getNamedQuery("deleteemp").
    setString("empno", emp.getEno()).executeUpdate();
	try{
		session.getTransaction().commit();
		eArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return eArray;

}

public Object selectEmp(Emp emp){
	Session session = SessionClass.getSession();
	session.beginTransaction();
	
	
	

	Object obj=null ;
	try{
    ArrayList list = (ArrayList) session.getNamedQuery("empselectbyid").setString("eno", emp.getEno()).list();
	java.util.Iterator i = list.iterator();
	int sizeOfList = list.size();
	while(i.hasNext()){		
		emp = (Emp) i.next();	
	}
   
	if(sizeOfList>0) 
		obj=emp;
	else 
		obj=new String("failure");

}
catch(Exception e){
	e.printStackTrace();
	obj=new String("failure");
}
return obj;

}



public  EmpArray selectAllEmp(){
	
	Session session = SessionClass.getSession();
	session.beginTransaction();
	ArrayList list= (ArrayList) session.getNamedQuery("selectemp").list();
	Iterator it = list.iterator();
	System.out.println(list);
	
	Emp[] emp = new Emp[list.size()];
	int i=0;
while(it.hasNext()){
		
		emp[i]=(Emp) it.next();
		System.out.println(emp[i].getCuid());
		
		i++;
	}
	EmpArray empArray = new EmpArray();
	empArray.setEmp(emp);
	
	return empArray;
	
}




}
