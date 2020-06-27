package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Patient;

import util.DatabaseUtil;

public class PatientDao {
	Connection con=null;
	ResultSet result=null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	public boolean addPatient(Patient pt, PreparedStatement ps) throws SQLException, ClassNotFoundException
	{
		//Login to insert the customer details to database using JDBC connection
		boolean flag=false;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("insert into Patient_details(patient_id,patient_name,patient_age,patient_doa,patient_typeofbed,patient_address,patient_state,patient_city) values((?,?,?,?,?,?,?,?)");
	ps.setInt(1, pt.getPatient_id());
	ps.setString(2, pt.getPatient_name());
	ps.setInt(3, pt.getPatient_age());
	ps.setDate(4, new java.sql.Date(pt.getPatient_doa()));
	ps.setString(5, pt.getPatient_typeofbed());
	ps.setString(6, pt.getPatient_address());
	ps.setString(7, pt.getPatient_state());
	ps.setString(8, pt.getPatient_city());
	
	int rowstatus=ps.executeUpdate();
	DatabaseUtil.closeConnection(con);
	DatabaseUtil.closeStatement(ps);
	if(rowstatus>0)
	{
		return true;
	}
	return flag;
	}
	
	public Patient searchPatientById(int patient_id, PreparedStatement ps) throws SQLException, ClassNotFoundException{
		Patient pt  = null;
		@SuppressWarnings("unused")
		boolean flag = false;
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select * from patient_details where patient_id= ? ");
		
		ps.setInt(1, patient_id);
		
		result = ps.executeQuery();
		
		while(result.next()) {
			pt = new Patient();
			pt.setPatient_id(result.getInt(1));
			pt.setPatient_name(result.getString(2));
			pt.setPatient_age(result.getDate(3));
			pt.setPatient_doa(result.getDate(4));
			pt.setPatient_typeofbed(result.getString(5));
			pt.setgetPatient_address(result.getString(6));
			pt.setgetPatient_state(result.getString(7));
			pt.setPatient_city(result.getString(8));
		}
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		
		
		return pt;
	}
	public boolean deletePatient(int patient_id, PreparedStatement ps) throws SQLException, ClassNotFoundException, SameValueException, NoCustomerException{
		@SuppressWarnings("unused")
		Patient  pt = null;
		@SuppressWarnings("unused")
		boolean flag = false;
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("delete from patient_details where patient_id= ? ");
		
		ps.setInt(1, patient_id);
		int count= ps.executeUpdate();
		
		
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		
		if(count>0)return true;
		else 
			throw new NoPatientException("Patient does not exist");
	}
	
public boolean updatePatient(int patient_id,String patient_name, int patient_age, Date patient_doa,String patient_typeofbed,String patient_address,String patient_state,String patient_city) throws SQLException, ClassNotFoundException, SameValueException{
		
		con = DatabaseUtil.getConnection();
		
		ps = con.prepareStatement("select patient_name,patient_age,patient_doa,patient_typeofbed,patient_address,patient_state,patient_city from patient_details where patient_id= ? ");
		
		ps.setInt(1, patient_id);
		
		result = ps.executeQuery();
		
		ps1 = con.prepareStatement("update patient_details set patient_name=?,patient_age=?,patient_doa=?,patient_typeofbed=?,patient_address=?,patient_state=?,patient_city=? where patient_id=?");
		ps1.setString(1, patient_name);
		ps1.setInt(2, patient_age);
		ps1.setDate(3, new java.sql.Date(patient_doa));
		ps1.setString(4, patient_typeofbed);
		ps1.setString(5, patient_address);
		ps1.setString(6, patient_state);
		ps1.setString(7, patient_city);
		ps1.setInt(8, patient_id);
		int count = ps1.executeUpdate();
		
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		DatabaseUtil.closeStatement(ps1);
		
		if(count>0)return true;
		return false;	
	}
}


		
		
			
		


