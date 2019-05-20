package service.impl;

import java.util.List;

import dao.SchoolDAO;
import dao.impl.SchoolDAOImpl;
import entity.School;
import service.SchoolService;

public class SchoolServiceImpl implements SchoolService {
	SchoolDAO schoolDAO = new SchoolDAOImpl();
	@Override
	public List<School> findAll() {
		List<School> list = schoolDAO.findAll();
		return list;
	}

	@Override
	public School findById(int sid) {
		School school = schoolDAO.findById(sid);
		return school;
	}

	@Override
	public boolean addSchool(School school) {
		int i = schoolDAO.addSchool(school);
		return i==1?true:false;
	}

	@Override
	public boolean deleteSchoolById(int sid) {
		int i = schoolDAO.deleteSchoolById(sid);
		return i==1?true:false;
	}

	@Override
	public boolean updateSchool(School school) {
		int i = schoolDAO.updateSchool(school);
		return i==1?true:false;
	}

	@Override
	public School findBySname(String sname) {
		School school = schoolDAO.findBySname(sname);
		return school;
	}

}
