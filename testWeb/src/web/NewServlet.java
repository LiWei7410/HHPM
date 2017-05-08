package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Utils;
import entity.News;
import service.NewsService;
import service.ServiceFactory;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private NewsService service = ServiceFactory.createNewsService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String op = req.getParameter("op");
		if(op == null)
			op = "";
		switch (op) {
		case "add":
			//执行添加操作
			add(req, resp);
			break;
		case "modify":
			modify(req, resp);
			break;
		case "del":
			delete(req, resp);
			break;
		case "edit":
			edit(req, resp);
			break;
		case "nb":
			req.getRequestDispatcher("/test").forward(req, resp);
			break;
		case "wb":
			resp.sendRedirect(req.getContextPath()+"/test");
			break;
		case "rd":
			resp.sendRedirect(req.getContextPath() + "/test?username=" + req.getParameter("username"));
			break;
		default:
			list(req, resp);
			break;
		}
		/*req.setCharacterEncoding("UTF-8");//解决参数的乱码
		resp.setCharacterEncoding("UTF-8");//解决输出内容的乱码
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		String bt =req.getParameter("bt");
		String zz=req.getParameter("zz");
		String nr=req.getParameter("nr");
		Date date= new Date();
		News ns=new News();
		ns.setBt(bt);
		ns.setZz(zz);
		ns.setNr(nr);
		ns.setTimes(date);
		NewsService nsi=ServiceFactory.createNewsService();
		nsi.save(ns);*/
		
	}
	private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id=Utils.toInt(req.getParameter("id"));
		News news = service.get(id);
		req.setAttribute("news", news);
		req.getRequestDispatcher("/news/edit.jsp").forward(req, resp);
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//显示所有已经添加的新闻记录
		//1.获取所有的新闻对象
		List<News> list = service.get();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/news/list.jsp").forward(req, resp);
	
	
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id = Utils.toInt(req.getParameter("id"));
	
		if(service.delete(id) == 1){
			RequestDispatcher rd=req.getRequestDispatcher("/success.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd=req.getRequestDispatcher("/failure.jsp");
			rd.forward(req, resp);
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		int id = Utils.toInt(req.getParameter("id"));
		Date times = Utils.toDate(req.getParameter("times"));
		String bt = req.getParameter("bt");
		String zz = req.getParameter("zz");
		String nr = req.getParameter("nr");
	
		//2.将数据转换为对象
		News news = new News();
		news.setId(id);
		news.setBt(bt);
		news.setNr(nr);
		news.setZz(zz);
		news.setTimes(times);
		//3.保存
		int result = ServiceFactory.createNewsService().update(news);
		//4.返回结果
		if(result == 1){
			RequestDispatcher rd=req.getRequestDispatcher("/success.jsp");
			rd.forward(req, resp);
			
		}else{
			RequestDispatcher rd=req.getRequestDispatcher("/failure.jsp");
			rd.forward(req, resp);
		}		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out = resp.getWriter();
		//OutputStream os = resp.getOutputStream();
		//1.取数据
		String bt =req.getParameter("bt");
		String zz=req.getParameter("zz");
		String nr=req.getParameter("nr");
		Date date= new Date();
		News ns=new News();
		ns.setBt(bt);
		ns.setZz(zz);
		ns.setNr(nr);
		ns.setTimes(date);
		
		//3.保存
		int result = ServiceFactory.createNewsService().save(ns);
		//4.返回结果
		if(result == 1){
			RequestDispatcher rd=req.getRequestDispatcher("/success.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd=req.getRequestDispatcher("/failure.jsp");
			rd.forward(req, resp);
		}
	}

}

