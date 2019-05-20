package service;

import java.util.List;

import entity.School;

public interface SchoolService {
	public List<School> findAll();
	
	public School findById(int sid);
	
	public boolean addSchool(School school);
	
	public boolean deleteSchoolById(int sid);
	
	public boolean updateSchool(School school);
	
	public School findBySname(String sname);
}
