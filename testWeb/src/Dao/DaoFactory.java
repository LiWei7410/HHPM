package Dao;

import Dao.impl.NewsDaoImpl;
import Dao.impl.UserDaoImpl;

public class DaoFactory {
	public static NewsDao createNewsDao(){
		return new NewsDaoImpl();
	}
	public static UserDao createUserDao(){
		return new UserDaoImpl();
	}


}
