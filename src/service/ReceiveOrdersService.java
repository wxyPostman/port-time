package service;

import java.util.List;

import entity.ReceiveOrders;

public interface ReceiveOrdersService {
	
	public boolean save(ReceiveOrders receiveOrders);
	
	public boolean deleteById(Integer id);
	
	public boolean update(ReceiveOrders receiveOrders);
	
	public int count();
	
	public List<ReceiveOrders> findAll();
	
	public ReceiveOrders findById(Integer id);
	
	public List<ReceiveOrders> findByUid(Integer uid);
	
	public boolean findByUOid(Integer uid, Integer oid);
	
	public  List<ReceiveOrders> findByOid(Integer oid);
	
	public boolean updateByStatus(Integer status,Integer id);

	public int countByStatus(Integer status);
}
