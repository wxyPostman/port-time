package service.impl;

import java.util.List;

import dao.ReceiveOrdersDAO;
import dao.impl.ReceiveOrdersDAOImpl;
import entity.ReceiveOrders;
import service.ReceiveOrdersService;
import service.ReleaseOrdersService;

public class ReceiveOrdersServiceImpl implements ReceiveOrdersService{
	ReceiveOrdersDAO receiveOrdersDAO =new ReceiveOrdersDAOImpl();

	@Override
	public boolean save(ReceiveOrders receiveOrders) {
		int i = receiveOrdersDAO.save(receiveOrders);
		return i==1?true:false;
	}

	@Override
	public boolean deleteById(Integer id) {
		int i = receiveOrdersDAO.deleteById(id);
		return i==1?true:false;
	}

	@Override
	public boolean update(ReceiveOrders receiveOrders) {
		int i = receiveOrdersDAO.update(receiveOrders);
		return i==1?true:false;
	}

	@Override
	public int count() {
		int i = receiveOrdersDAO.count();
		return i;
	}

	@Override
	public List<ReceiveOrders> findAll() {
		List<ReceiveOrders> list = receiveOrdersDAO.findAll();
		return list;
	}

	@Override
	public ReceiveOrders findById(Integer id) {
		ReceiveOrders orders = receiveOrdersDAO.findById(id);
		return orders;
	}

	@Override
	public List<ReceiveOrders> findByUid(Integer uid) {
		List<ReceiveOrders> list= receiveOrdersDAO.findByUid(uid);
		return list;
	}

	@Override
	public boolean findByUOid(Integer uid, Integer oid) {
		int i = receiveOrdersDAO.findByUOid(uid, oid);
		return i==1?true:false;
	}

	@Override
	public List<ReceiveOrders> findByOid(Integer oid) {
		List<ReceiveOrders> list= receiveOrdersDAO.findByOid(oid);
		return list;
	}

	@Override
	public boolean updateByStatus(Integer status, Integer id) {
		int i = receiveOrdersDAO.updateByStatus(status, id);
		return i==1?true:false;
	}

	@Override
	public int countByStatus(Integer status) {
		int count = receiveOrdersDAO.countByStatus(status);
		return count;
	}
	
}
