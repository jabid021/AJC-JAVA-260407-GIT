package hopital.dao;

import java.time.LocalDate;
import java.util.List;

import hopital.model.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer> {
	
	public void setIdPatientNull(Integer idPatient);
	public List<Visite> findByPatientId(Integer idPatient);
	public List<Visite> findByMedecinIdAndDateVisiteBetween(Integer idMedecin,LocalDate debut, LocalDate fin);

}
