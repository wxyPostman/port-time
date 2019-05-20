package service.impl;

import java.util.List;

import dao.PositionDAO;
import dao.impl.PositionDAOImpl;
import entity.Position;
import service.PositionService;

public class PositionServiceImpl implements PositionService {
	PositionDAO positionDAO = new PositionDAOImpl(); 
	@Override
	public List<Position> findAll() {
		List<Position> list = positionDAO.findAll();
		return list;
	}

	@Override
	public boolean deletePositionById(int pid) {
		int i = positionDAO.deletePositionById(pid);
		return i==1?true:false;
	}

	@Override
	public boolean updatePosition(Position position) {
		int i = positionDAO.updatePosition(position);
		return i==1?true:false;
	}

	@Override
	public boolean addPosition(Position position) {
		int i = positionDAO.addPosition(position);
		return i==1?true:false;
	}

	@Override
	public Position findPositionById(int pid) {
		Position position = positionDAO.findPositionById(pid);
		return position;
	}

	@Override
	public Position findPositionByName(String pname) {
		Position position = positionDAO.findPositionByName(pname);
		return position;
	}

}
