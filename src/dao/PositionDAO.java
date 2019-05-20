package dao;


import java.util.List;

import entity.Position;



public interface PositionDAO {
	public List<Position> findAll();
	
	public int deletePositionById(int pid);
	
	public int updatePosition(Position position);
	
	public int addPosition(Position position);
	
	public Position findPositionById(int pid);
	
	public Position findPositionByName(String pname);
}
