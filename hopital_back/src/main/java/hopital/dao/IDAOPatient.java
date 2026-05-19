package hopital.dao;

import hopital.model.Patient;

public interface IDAOPatient extends IDAO<Patient,Integer> {

	
	public Patient findByIdWithVisites(Integer idPatient);
	
	
}
