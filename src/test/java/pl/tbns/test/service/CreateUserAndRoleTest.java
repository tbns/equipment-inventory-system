package pl.tbns.test.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.RoleDao;
import pl.tbns.dao.UserDao;
import pl.tbns.model.User;
import pl.tbns.model.UserRole;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-context-test.xml", "/spring/hibernate-context-test.xml" })
public class CreateUserAndRoleTest extends TestCase{

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;

	@Test
	@Transactional
//	@Rollback(false)
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
}
