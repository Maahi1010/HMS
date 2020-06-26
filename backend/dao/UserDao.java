package com.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import com.bean.UserBean;

	public class UserDao {
		
		public boolean validateLogin(String username,String password)
		{
			Connection con=null;
			boolean isValid=false;	
		try
		{
			con=DBConnectionUtil.openConnection();
			String query="select 1 from user_login where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setNString(1, username);
			ps.setNString(2, password);;
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				isValid=true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DBConnectionUtil.closeConnection(con);
		}
		return isValid;
		}
		
		}
		
		
			
		


