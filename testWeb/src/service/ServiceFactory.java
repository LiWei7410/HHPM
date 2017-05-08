package service;

import service.impl.NewsServiceImpl;
import service.impl.UserServiceImpl;



public class ServiceFactory {
	public static NewsService createNewsService(){
		return new NewsServiceImpl();
	}
	public static UserService createUserService(){
		return new UserServiceImpl();
	}
}
