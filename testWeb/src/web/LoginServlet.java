package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ConstantValues;
import entity.User;
import service.ServiceFactory;
import service.UserService;

public class LoginServlet extends HttpServlet {
	private UserService service = ServiceFactory.createUserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		User user=service.sel(username);
		if(user!=null){
			if(user.getU_password().equals(pwd)){
				HttpSession session= req.getSession();
				session.setAttribute(ConstantValues.SESSION_USER, user);
				resp.sendRedirect(req.getContextPath() + "/new");
			}else{
				req.setAttribute("msg", "密码错误");
				req.setAttribute("url", req.getContextPath() + "/login");
				req.getRequestDispatcher("/msg.jsp").forward(req, resp);
				return;
			}
		}else{
			req.setAttribute("msg", "用户名不存在");
			req.setAttribute("url", req.getContextPath() + "/login");
			req.getRequestDispatcher("/msg.jsp").forward(req, resp);
			return;
		}
	}
}
