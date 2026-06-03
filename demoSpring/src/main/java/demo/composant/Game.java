package demo.composant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Game {
	
	
	//@Autowired va consulter le context Spring à la recherche d'un bean :
		//S'il trouve un bean ayant le même type que l'attribut => l'inject
		//S'il ne trouve AUCUN bean => exception
		//S'il trouve plusieurs bean ayant le même type : 
			//=> il va regarder le nom de l'attribut et chercher un bean avec CET ID la :
				//On trouve un seul bean avec l'id => l'inject
				//On ne trouve aucun bean avec le bon id => IL FAUT PRECISER LE NOM
			
	@Autowired
	private IConfig audio;
	
	@Autowired
	@Qualifier("graphisme")
	private IConfig configGraphisme;
	
	private String nom;
	
	public Game() {}

	public IConfig getAudio() {
		return audio;
	}

	public void setAudio(IConfig audio) {
		this.audio = audio;
	}

	public IConfig getConfigGraphisme() {
		return configGraphisme;
	}

	public void setConfigGraphisme(IConfig configGraphisme) {
		this.configGraphisme = configGraphisme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Game [audio=" + audio + ", configGraphisme=" + configGraphisme + ", nom=" + nom + "]";
	}

	
	
	
	
}
