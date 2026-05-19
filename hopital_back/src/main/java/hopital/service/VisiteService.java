package hopital.service;

import java.time.LocalDate;
import java.util.List;

import hopital.context.Singleton;
import hopital.dao.IDAOVisite;
import hopital.model.Visite;

public class VisiteService {

	static IDAOVisite daoVisite =  Singleton.getInstance().getDaoVisite();
	
	public List<Visite> getAll()
	{
		return daoVisite.findAll();
	}
	
	public Visite getById(Integer id) 
	{
		return daoVisite.findById(id);
	}
	
	public List<Visite> getByPatientId(Integer idPatient)
	{
		return daoVisite.findByPatientId(idPatient);
	}
	
	public List<Visite> getByMedecinIdAndPeriode(Integer idMedecin,LocalDate debut,LocalDate fin)
	{
		return daoVisite.findByMedecinIdAndDateVisiteBetween(idMedecin, debut, fin);
	}
	
	public void insert(Visite visite) 
	{
		daoVisite.save(visite);
	}
	
	public void update(Visite visite) 
	{
		daoVisite.save(visite);
	}

	
	public void delete(Visite visite) 
	{
		daoVisite.deleteById(visite.getNumero());
	}
	
	public void deleteById(Integer id) 
	{
		daoVisite.deleteById(id);
	}
}
