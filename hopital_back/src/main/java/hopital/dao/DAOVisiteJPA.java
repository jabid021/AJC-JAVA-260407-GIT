package hopital.dao;

import java.time.LocalDate;
import java.util.List;

import hopital.model.Visite;

public class DAOVisiteJPA implements IDAOVisite {

	@Override
	public Visite findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Visite obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Visite obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIdPatientNull(Integer idPatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Visite> findByPatientId(Integer idPatient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visite> findByMedecinIdAndDateVisiteBetween(Integer idMedecin, LocalDate debut, LocalDate fin) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
