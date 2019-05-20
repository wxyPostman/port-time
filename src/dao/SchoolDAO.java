package dao;


import java.util.List;

import entity.School;


public interface SchoolDAO {
	public List<School> findAll();
	
	public School findById(int sid);
	
	public int addSchool(School school);
	
	public int deleteSchoolById(int sid);
	
	public int updateSchool(School school);
	
	public School findBySname(String sname);
}
