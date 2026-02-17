package com.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDAO {
	
	
	public Connection getConnection() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3307/elearn";
		String username = "root";
		String pass = "msnsn";
		
		return DriverManager.getConnection(url, username, pass);
	}

	@Override
	public User checkLogin(User user) {
		
		String query = "SELECT * FROM users WHERE unm = ? AND psw = ?";
		
		try (Connection conn = getConnection();
			     PreparedStatement pst = conn.prepareStatement(query)) {
			    
			    pst.setString(1, user.getUname());
			    pst.setString(2, user.getPassword());

			    try (ResultSet rs = pst.executeQuery()) {
			        if(rs.next()) {
			        	User u = new User();
			        	u.setId(rs.getInt("id"));
			        	u.setFname(rs.getString("fnm"));
			        	u.setSname(rs.getString("snm"));
			        	u.setUname(rs.getString("unm"));
			        	u.setFunc(rs.getString("func"));
			        	u.setCity(rs.getString("city"));
			        	u.setEmail(rs.getString("mail"));
			        	u.setPassword(rs.getString("psw"));
			        	u.setAvatar_src(rs.getString("avatar"));
			        	u.setScore(rs.getInt("score"));
			        	
			        	return u;
			        }
			    }

		} catch (SQLException e) {
			    e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public void signUP(User user) {
		
		String query = "INSERT INTO users(fnm,snm,unm,func,city,mail,psw,avatar,score) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try (Connection conn = getConnection();
			     PreparedStatement pst = conn.prepareStatement(query)) {
			    
			    pst.setString(1, user.getFname());
			    pst.setString(2, user.getSname());
			    pst.setString(3, user.getUname());
			    pst.setString(4, user.getFunc());
			    pst.setString(5, user.getCity());
			    pst.setString(6, user.getEmail());
			    pst.setString(7, user.getPassword());
			    pst.setString(8, user.getAvatar_src());
			    pst.setInt(9, user.getScore());
			    
			    pst.executeUpdate();
			    
			    pst.close();
			    
		} catch (SQLException e) {
			    e.printStackTrace();
		}
		
	}

	@Override
	public boolean profileSet(User user) {
		
		String query = "UPDATE users SET fnm = ?, snm = ?, unm = ?, func = ?, city = ?, mail = ?, psw = ? WHERE id = ?";
		
		Integer id = user.getId();
		if(!user.getFname().isBlank() && !user.getSname().isBlank() && !user.getUname().isBlank() &&
				!user.getFunc().isBlank() && !user.getCity().isBlank() && !user.getEmail().isBlank() &&
				!user.getPassword().isBlank() && id != null) {
			try (Connection conn = getConnection();
				     PreparedStatement pst = conn.prepareStatement(query)) {
				    
				    pst.setString(1, user.getFname());
				    pst.setString(2, user.getSname());
				    pst.setString(3, user.getUname());
				    pst.setString(4, user.getFunc());
				    pst.setString(5, user.getCity());
				    pst.setString(6, user.getEmail());
				    pst.setString(7, user.getPassword());
				    pst.setInt(8, user.getId());
				    
				    pst.executeUpdate();
				    
				    pst.close();
				    
			} catch (SQLException e) {
				    e.printStackTrace();
			}
			
			return true;
			
		} else {
			return false;
		}
		
	}

	@Override
	public void scoreUpdate(User user) {
		String query = "UPDATE users SET score = ? WHERE id = ?";
		
		try (Connection conn = getConnection();
			     PreparedStatement pst = conn.prepareStatement(query)) {
			    
			    pst.setInt(1, user.getScore());
			    pst.setInt(2, user.getId());
			    
			    pst.executeUpdate();
			    
			    pst.close();
			    
		} catch (SQLException e) {
			    e.printStackTrace();
		}
		
	}

	@Override
	public boolean avatarUpdate(User user) {
		
		if(user.getAvatar_src() != null) {
			
			String query = "UPDATE users SET avatar = ? WHERE id = ?";
			
			try (Connection conn = getConnection();
				     PreparedStatement pst = conn.prepareStatement(query)) {
				    
				    pst.setString(1, user.getAvatar_src());
				    pst.setInt(2, user.getId());
				    
				    pst.executeUpdate();
				    
				    pst.close();
				    
			} catch (SQLException e) {
				    e.printStackTrace();
			}
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteAccount(User user) {
		
		String query = "DELETE FROM users WHERE id = ?";
		try (Connection conn = getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {
			pst.setInt(1, user.getId());
			
			pst.executeUpdate();
			
			pst.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
		
	}

	@Override
	public void saveMessage(int id, String unm, String msg) {
		
		String query = "INSERT INTO chatroom(id,unm,msg) VALUES (?,?,?);";
		
		try(Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(query);){
			
			pst.setInt(1, id);
			pst.setString(2, unm);
			pst.setString(3, msg);
			
			pst.executeUpdate();
			
			pst.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<String> messages() {
		
		List<String> msg = new ArrayList<String>();
		
		String query = "SELECT * FROM chatroom;";
		
		try(Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(query);){
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String msgList = rs.getString("unm") + " : " + rs.getString("msg") + "<br><br>";
				msg.add(msgList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public void saveCourse(int id, String unm, String title, String desc, String content) {
		
		String query = "INSERT INTO courses(id, unm, title, description, content) VALUES(?,?,?,?,?);";
		
		try(Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(query);){
			
			pst.setInt(1, id);
			pst.setString(2, unm);
			pst.setString(3, title);
			pst.setString(4, desc);
			pst.setString(5, content);
			
			pst.executeUpdate();
			
			pst.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Course> importeCourse() {
		
		List<Course> courses = new ArrayList<>();
		
		String query = "SELECT id, unm, title, description, content FROM courses;";
		
		try(Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(query);){
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setUname(rs.getString("unm"));
				course.setTitle(rs.getString("title"));
				course.setDescription(rs.getString("description"));
				course.setContent(rs.getString("content"));
				
				courses.add(course);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		Collections.reverse(courses);
		
		return courses;
	}
	
	@Override
	public List<Course> profileCourse(String unm){
		
		List<Course> courses = new ArrayList<>();
		
		String query = "SELECT id, unm, title, description, content FROM courses WHERE unm=?;";
		
		try(Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(query);){
			
			pst.setString(1, unm);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setUname(rs.getString("unm"));
				course.setTitle(rs.getString("title"));
				course.setDescription(rs.getString("description"));
				course.setContent(rs.getString("content"));
				
				courses.add(course);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		Collections.reverse(courses);	
		return courses;
	}

	@Override
	public void deleteCourse(String unm, String ttl) {
		
		String query = "DELETE FROM courses WHERE unm = ? AND title = ?;";
		try (Connection conn = getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {
			pst.setString(1, unm);
			pst.setString(2, ttl);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

}
