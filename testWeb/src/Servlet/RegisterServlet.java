package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		
		String username=req.getParameter("username");
		String userpwd=req.getParameter("userpwd");
		String sex=req.getParameter("sex");
		String xl=req.getParameter("xl");
		String[] ahs=req.getParameterValues("ah");
		String jl=req.getParameter("jl");
		try(Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","scott","accp");
				PreparedStatement ps= conn.prepareStatement("insert into  user_u values(?,?,?,?,?,?)")) {
		
				ps.setString(1, username);
				ps.setString(2, userpwd);
				ps.setString(3, sex);
				ps.setString(4, xl);
				ps.setString(5, Utils.join(ahs, ","));
				ps.setString(6, jl);
				int re= ps.executeUpdate();
				if(re==1){
					System.out.println("³É¹¦");
				}else{
					System.out.println("Ê§°Ü");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}


}
