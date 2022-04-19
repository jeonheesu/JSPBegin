package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {

	
	
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public  UserDAO() {
		
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/jspProject");
			conn = dataFactory.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void dbClose() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void userInsert(String user_id, String user_pw) {
		
		String sql = "INSERT INTO userTBL (userID, userPW) VALUES(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
		   pstmt.executeUpdate();
		   
		   System.out.println("userInsert() 작동 완료");
		   dbClose();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	
	 public int login(String user_id, String user_pw) {
		 
		 
		  String sql = "SELECT * from userTBL where userID = ? and userPW = ?";
		  try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
		   rs =  pstmt.executeQuery();
		   
		   if(rs.next()) {
			   return 1;
		   }else {
			   return 0;
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		 
		 
		 
	
		
	 }
	
	
		
		
		
	
	
	public String idCheck(String user_id) {
	
		 String sql = "SELECT * from userTBL where userID = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return "Duplicate";
				}else {
					return "Available";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		return null;
		
		
		
	}
	
	
}
	
