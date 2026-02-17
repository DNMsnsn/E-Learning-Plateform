package com.DAO;

import java.util.List;

public interface UserDAO {

	public User checkLogin(User user);
	public void signUP(User user);
	public boolean profileSet(User user);
	public void scoreUpdate(User user);
	public boolean avatarUpdate(User user);
	public boolean deleteAccount(User user);
	public void saveMessage(int id, String unm, String msg);
	public List<String> messages();
	public void saveCourse(int id, String unm, String title, String desc, String content);
	public List<Course> importeCourse();
	public List<Course> profileCourse(String unm);
	public void deleteCourse(String unm, String ttl);
}
