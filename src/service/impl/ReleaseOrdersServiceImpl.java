package service.impl;

import java.util.List;

import dao.ReleaseOrdersDAO;
import dao.impl.ReleaseOrdersDAOImpl;
import entity.ReleaseOrders;
import service.ReleaseOrdersService;
import utils.PageBean;

public class ReleaseOrdersServiceImpl implements ReleaseOrdersService {
	ReleaseOrdersDAO releaseOrdersDAO = new ReleaseOrdersDAOImpl();
	@Override
	public boolean save(ReleaseOrders releaseOrders) {
		int i = releaseOrdersDAO.save(releaseOrders);
		return i==1?true:false;
	}

	@Override
	public boolean update(ReleaseOrders releaseOrders) {
		int i = releaseOrdersDAO.update(releaseOrders);
		return i==1?true:false;
	}

	@Override
	public List<ReleaseOrders> findAll() {
		List<ReleaseOrders> list = releaseOrdersDAO.findAll();
		return list;
	}

	@Override
	public boolean deleteById(Integer id) {
		int i = releaseOrdersDAO.deleteById(id);
		return i==1?true:false;
	}

	@Override
	public ReleaseOrders findById(Integer id) {
		ReleaseOrders orders = releaseOrdersDAO.findById(id);
		return orders;
	}

	@Override
	public List<ReleaseOrders> findByTitle(String title) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByTitle(title);
		return list;
	}

	@Override
	public List<ReleaseOrders> findByPid(Integer pid) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByPid(pid);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySid(Integer sid) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySid(sid);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySidAndPid(Integer sid, Integer pid) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySidAndPid(sid, pid);
		return list;
	}
	
	@Override
	public List<ReleaseOrders> findByPiTi(Integer pid, String title) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByPiTi(pid,title);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySiTi(Integer sid, String title) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByPiTi(sid,title);
		return list;
	}

	@Override
	public List<ReleaseOrders> findBySiPiTi(Integer sid, Integer pid, String title) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySiPiTi(sid,pid,title);
		return list;
	}


//	@Override
//	public List<ReleaseOrders> findByPage(int currentPage, int pageSize) {
//		List<ReleaseOrders> list = releaseOrdersDAO.findByPage(currentPage, pageSize);
//		return list;
//	}

	@Override
	public int count() {
		int i = releaseOrdersDAO.count();
		return i;
	}

	@Override
	public PageBean<ReleaseOrders> findByPageBean(Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findAll();
		int totalRecord = list.size();
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findAllByPage(currentPage, pageSize));
		return pbBean;
	}



	@Override
	public PageBean<ReleaseOrders> findByPidPageBean(Integer pid, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByPid(pid);
		int totalRecord = list.size();
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findByPidPage(pid, currentPage, pageSize));
		return pbBean;
	}

	@Override
	public PageBean<ReleaseOrders> findBySidPageBean(Integer sid, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySid(sid);
		int totalRecord = list.size();
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findBySidPage(sid, currentPage, pageSize));
		return pbBean;
	}

	@Override
	public PageBean<ReleaseOrders> findBySidAndPidPageBean(Integer sid, Integer pid, Integer currentPage,
			Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySidAndPid(sid, pid);
		int totalRecord = list.size();	
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findBySidAndPidPage(sid, pid, currentPage, pageSize));
		return pbBean;
	}

	@Override
	public PageBean<ReleaseOrders> findByPiTiPageBean(Integer pid, String title, Integer currentPage,
			Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByPiTi(pid,title);
		int totalRecord = list.size();
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findByPiTiPage(pid,title, currentPage, pageSize));
		return pbBean;
	}

	@Override
	public PageBean<ReleaseOrders> findBySiTiPageBean(Integer sid, String title, Integer currentPage,
			Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySiTi(sid,title);
		int totalRecord = list.size();
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		
		
		pbBean.setList(releaseOrdersDAO.findBySiTiPage(sid,title, currentPage, pageSize));
		return pbBean;
	}

	@Override
	public PageBean<ReleaseOrders> findBySiPiTiPageBean(Integer sid, Integer pid, String title, Integer currentPage,
			Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findBySiPiTi(sid, pid,title);
		int totalRecord = list.size();	
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findBySiPiTiPage(sid, pid, title,currentPage, pageSize));
		return pbBean;
	}

	






	@Override
	public PageBean<ReleaseOrders> findByTitlePageBean(String title, Integer currentPage, Integer pageSize) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByTitle(title);
		int totalRecord = list.size();
		PageBean<ReleaseOrders> pbBean = new PageBean<ReleaseOrders>(currentPage, pageSize, totalRecord);
		pbBean.setList(releaseOrdersDAO.findTitleByPage(title, currentPage, pageSize));
		return pbBean;
	}

	@Override
	public int countByUid(Integer uid) {
		int i = releaseOrdersDAO.countByUid(uid);
		return i;
	}

	@Override
	public List<ReleaseOrders> findThree(Integer uid) {
		List<ReleaseOrders> list = releaseOrdersDAO.findThree(uid);
		return list;
	}

	@Override
	public List<ReleaseOrders> findByUid(Integer uid) {
		List<ReleaseOrders> list = releaseOrdersDAO.findByUid(uid);
		return list;
	}

	@Override
	public boolean deleteByUid(Integer uid) {
		int i = releaseOrdersDAO.deleteByUid(uid);
		return i==1?true:false;
	}



	


}
