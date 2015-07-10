package pl.tbns.dao;


import pl.tbns.api.dao.GenericDao;
import pl.tbns.model.UserRole;


public interface RoleDao extends GenericDao<UserRole> {
	
	public UserRole findByName(String role);

}
