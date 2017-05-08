package service.impl;

import Dao.DaoFactory;
import Dao.UserDao;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao = DaoFactory.createUserDao();
	@Override
	public User sel(String username) {
		
		return dao.findByName(username);
	}

}
