package dao;

import java.util.List;

import entity.ReceiveOrders;

public interface ReceiveOrdersDAO {
	public int save(ReceiveOrders receiveOrders);
	
	public int deleteById(Integer id);
	
	public int update(ReceiveOrders receiveOrders);
	
	public int count();
	
	public List<ReceiveOrders> findAll();
	
	public ReceiveOrders findById(Integer id);
	
	public List<ReceiveOrders> findByUid(Integer uid);
	
	public int findByUOid(Integer uid ,Integer oid);
	
	public List<ReceiveOrders> findByOid(Integer oid);
	
	public int  updateByStatus(Integer status,Integer id);

	public int countByStatus(Integer status);
}
