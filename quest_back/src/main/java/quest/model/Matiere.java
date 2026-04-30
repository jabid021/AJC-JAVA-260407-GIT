package quest.model;

public class Matiere {
	private Integer id;
	private String libelle;


	public Matiere(Integer id, String libelle) 
	{
		this.id=id;
		this.libelle=libelle;
	}	

	public void setLibelle(String libelle)
	{
		this.libelle=libelle;
	}

	public String getLibelle()
	{
		return libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}
}
