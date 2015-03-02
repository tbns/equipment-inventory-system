package pl.tbns.api.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Maciej Skowyra
 * @date Mar 2, 2015 10:32:16 PM
 * @param <T>
 */
public interface GenericDao<T extends Object> {
	
	void create(T t);
	T get(Serializable id);
	T load(Serializable id);
	List<T> getAll();
	void update(T t);
	void delete(T t);
	void deleteById(Serializable id);
	void deleteAll();
	long count();
	boolean exists(Serializable id);	

}

