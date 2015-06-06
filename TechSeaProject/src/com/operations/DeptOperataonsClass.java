package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Dept;
import com.support.DeptArray;
import com.support.SessionClass;

public class DeptOperataonsClass {
	Dept d=null;
	DeptArray dArray = null;
	public DeptOperataonsClass(Dept d,DeptArray dArray){
		
		this.d = d;
		this.dArray=dArray;
		
	}

//insertDept is a method to insert data into department table
	
	
public DeptArray insertDept(Dept dept){
	DeptArray deptArray = new DeptArray();
Session session = SessionClass.getSession();
session.beginTransaction();

session.getNamedQuery("insertdept").
setString("deptname", dept.getDeptName()).
setString("location", dept.getLocation()).
setString("creteduserid", dept.getCreatedUserId()).executeUpdate();
session.getTransaction().commit();
deptArray.setResult("success");
	return deptArray;
}

//delete dept is a method to delete a specific records in department table
public DeptArray deleteDept(Dept dept){
	DeptArray deptArray = new DeptArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
    session.getNamedQuery("deletedept").
    setString("deptno", dept.getDeptNo()).executeUpdate();
	try{
	session.getTransaction().commit();
	deptArray.setResult("success");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return deptArray;
}

//updateDept is a method to Update specific the records from department table
public DeptArray updateDept(Dept dept){
DeptArray deptArray = new DeptArray();
Session session = SessionClass.getSession();
session.beginTransaction();
session.getNamedQuery("updatedept").
setString("deptno", dept.getDeptNo()).
setString("deptname", dept.getDeptName()).
setString("location", dept.getLocation()).
setString("lastmodifieduserid", dept.getLastModifiedUserId()).executeUpdate();
try{
session.getTransaction().commit();
deptArray.setResult("success");
}
catch(Exception e){
	e.printStackTrace();
}
return deptArray;

}


//Selectdept is a method to get the record on id base
public Object selectDept(Dept dept){
Session session = SessionClass.getSession();

Object obj=null ;
try{
ArrayList list = (ArrayList) session.getNamedQuery("deptselectbyid").setString("dno", dept.getDeptNo()).list();
java.util.Iterator i = list.iterator();
int sizeOfList = list.size();
while(i.hasNext()){		
	dept = (Dept) i.next();	
}

if(sizeOfList>0) 
	obj=dept;
else 
	obj=new String("failure");


}
catch(Exception e){
	e.printStackTrace();
	obj=new String("failure");
}
return obj;
}	

//SelectAll is a method to get all the records from department table

public DeptArray selectAll(){
	
	Session session = SessionClass.getSession();
	Object object=null;
	
		ArrayList list= (ArrayList) session.getNamedQuery("deptSel").list();
		Iterator it = list.iterator();
		System.out.println(list);
		
		Dept[] dept = new Dept[list.size()];
		int i=0;
while(it.hasNext()){
			
			dept[i]=(Dept) it.next();
			//System.out.println(dept[i].getCreatedUserId());
			
			i++;
		}
		DeptArray deptArray = new DeptArray();
		deptArray.setDept(dept);
		object = deptArray;
		
	
	return (DeptArray) object;
}


public Object selectDeptDataByName(Dept dept){
	
	Session session = SessionClass.getSession();

	Object obj=null ;
	try{
    ArrayList list = (ArrayList) session.getNamedQuery("deptselectbyname").setString("dname", dept.getDeptName()).list();
	java.util.Iterator i = list.iterator();
	int sizeOfList = list.size();
	while(i.hasNext()){		
		dept = (Dept) i.next();	
	}
   
	if(sizeOfList>0) 
		obj=dept;
	else 
		obj=new String("failure");

	
	}
	catch(Exception e){
		e.printStackTrace();
		obj=new String("failure");
	}
	return obj;
}	
}
