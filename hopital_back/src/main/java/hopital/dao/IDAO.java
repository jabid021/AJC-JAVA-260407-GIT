package hopital.dao;

import java.util.List;

public interface IDAO<T,K> {
	String urlBDD = "jdbc:mysql://localhost:3306/hopital";
	String loginBDD = "root";
	String passwordBDD = "root";
	
	
	public T findById(K id);
	public List<T> findAll();
	public void insert(T obj);
	public void update(T obj);
	public void deleteById(K id);	
}
