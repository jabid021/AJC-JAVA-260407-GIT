package demo.model.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("sec")
public class Secretaire extends Compte {

	
	public Secretaire() {}

	public Secretaire(String login, String password) {
		super(login, password);
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
