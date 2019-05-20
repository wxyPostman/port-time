package service;

import java.util.List;

import entity.Position;

public interface PositionService {
	public List<Position> findAll();
	
	public boolean deletePositionById(int pid);
	
	public boolean updatePosition(Position position);
	
	public boolean addPosition(Position position);
	
	public Position findPositionById(int pid);
	
	public Position findPositionByName(String pname);
}
