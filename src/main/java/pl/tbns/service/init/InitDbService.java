package pl.tbns.service.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
import pl.tbns.dao.RoleDao;
import pl.tbns.dao.UserDao;
import pl.tbns.model.User;
import pl.tbns.model.UserRole;
**/
@Service
@Transactional
public class InitDbService {
/**
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void init(){
		UserRole roleUser = new UserRole();
		roleUser.setRole("ROLE_USER");
		roleDao.create(roleUser);
		
		UserRole roleAdmin = new UserRole();
		roleAdmin.setRole("ROLE_ADMIN");
		roleDao.create(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setLogin("admin");
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setUserRole(roles);
		userDao.create(userAdmin);
	}
	**/
}
