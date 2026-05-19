package demo.model.single;

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
