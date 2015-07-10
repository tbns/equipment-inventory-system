package pl.tbns.dao.impl;

import org.springframework.stereotype.Repository;

import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.UserDao;
import pl.tbns.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDao<User> implements UserDao {

}
