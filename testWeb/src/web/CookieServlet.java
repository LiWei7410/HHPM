package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String op=req.getParameter("op");
		if(op==""){
			op="set";
		}
		switch (op) {
			case "set":
				set(req,resp);
				break;
			case "get":
				get(req,resp);
				break;
			case "del":
				del(req,resp);
				break;
			default:
				break;
		}
	}

	private void del(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cooks=req.getCookies();
		if(cooks!=null){
			for(Cookie coo:cooks){
				if("username".equals(coo.getName())){
					coo.setMaxAge(0);
					resp.addCookie(coo);
				}
			}
		}
	}

	private void get(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Cookie[] cooks=req.getCookies();
		PrintWriter out=resp.getWriter();
		if(cooks!=null){
			for(Cookie cook:cooks){
				out.print(cook.getName()+"="+cook.getValue());
			}
		}
		
	}

	private void set(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cook=new Cookie("username", "zhangsan");
		cook.setMaxAge(60*60*24);
		resp.addCookie(cook);
		
	}
}
