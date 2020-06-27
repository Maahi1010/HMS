package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.bean.Patient;
import com.dao.PatientDao;

public class PtService {
	PatientDao pDao = new PatientDao();
	public boolean addPatient(Patient pt) throws SQLException, ClassNotFoundException{
		return pDao.addPatient(pt, null);
	}
	public ArrayList<Patient> searchPatientById(int patient_id) throws SQLException, ClassNotFoundException{
		return pDao.searchPatientById(patient_id);
	}
	public boolean deletePatientDetails(int patient_id) throws SQLException, ClassNotFoundException{
		return pDao.deletePatientDetails(patient_id);
	}
	public boolean updatePatientDetails(int patient_id,String patient_name,int patient_age,Date patient_doa,String patient_address,String patient_state,String patient_city) throws SQLException, ClassNotFoundException{
		return pDao.updatePatientDetails(patient_id,patient_name,patient_age,patient_doa,patient_address,patient_state,patient_city);
	}
}

