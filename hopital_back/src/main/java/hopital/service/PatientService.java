package hopital.service;

import java.util.List;

import hopital.context.Singleton;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.model.Patient;

public class PatientService {

	static IDAOPatient daoPatient =  Singleton.getInstance().getDaoPatient();
	static IDAOVisite daoVisite =  Singleton.getInstance().getDaoVisite();
	public List<Patient> getAll()
	{
		return daoPatient.findAll();
	}
	
	public Patient getById(Integer id) 
	{
		return daoPatient.findById(id);
	}
	
	public void insert(Patient patient) 
	{
		daoPatient.insert(patient);
	}
	
	public void update(Patient patient) 
	{
		daoPatient.update(patient);
	}

	public void delete(Integer id) 
	{
		daoVisite.setIdPatientNull(id);
		daoPatient.deleteById(id);
	}
}
