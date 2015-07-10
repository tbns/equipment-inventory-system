package pl.tbns.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.RoleDao;
import pl.tbns.model.UserRole;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractGenericDao<UserRole> implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public UserRole findByName(String role) {
		return (UserRole) sessionFactory.getCurrentSession()
				.createQuery("from Roles r " +
				"where r.roles = :name")
				.setParameter("name", role)
				.uniqueResult();
	}

}
