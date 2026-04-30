package quest.dao;

import java.util.List;

public interface IDAO<T,K> {
	
	
	String urlBDD="jdbc:mysql://localhost:3306/projet_quest";
	String loginBDD = "root";
	String passwordBDD = "root";
	
	public T findById(K id);
	public List<T> findAll();
	public void insert(T obj);
	public void update(T obj);
	public void delete(K id);


}
