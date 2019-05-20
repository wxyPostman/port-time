package service;

import java.util.List;

import entity.ReleaseOrders;
import utils.PageBean;

public interface ReleaseOrdersService {
	public boolean save(ReleaseOrders releaseOrders);
	
	public boolean update(ReleaseOrders releaseOrders);
	
	public List<ReleaseOrders> findAll();
	
	public boolean deleteById(Integer id);
	
	public ReleaseOrders findById(Integer id);
	
	public List<ReleaseOrders> findByTitle(String title);
	
	public List<ReleaseOrders> findByPid(Integer pid);
	
	public List<ReleaseOrders> findBySid(Integer sid);
	
	public List<ReleaseOrders>  findBySidAndPid(Integer sid,Integer pid);
	
	public List<ReleaseOrders> findByPiTi(Integer pid,String title);
	
	public List<ReleaseOrders> findBySiTi(Integer sid,String title);
	
	public List<ReleaseOrders>  findBySiPiTi(Integer sid,Integer pid,String title);
	
	
	/**
	 * 分页查询
	 * @param pid
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	//public List<ReleaseOrders> findByPage(int currentPage, int pageSize);
	public PageBean<ReleaseOrders> findByPidPageBean(Integer pid,Integer currentPage, Integer pageSize);
	
	public PageBean<ReleaseOrders> findBySidPageBean(Integer sid,Integer currentPage, Integer pageSize);
	
	public PageBean<ReleaseOrders>  findBySidAndPidPageBean(Integer sid,Integer pid,Integer currentPage, Integer pageSize);
	
	public PageBean<ReleaseOrders> findByPiTiPageBean(Integer pid,String title,Integer currentPage, Integer pageSize);
	
	public PageBean<ReleaseOrders> findBySiTiPageBean(Integer sid,String title,Integer currentPage, Integer pageSize);
	
	public PageBean<ReleaseOrders>  findBySiPiTiPageBean(Integer sid,Integer pid,String title,Integer currentPage, Integer pageSize);

	
	
	
	public PageBean<ReleaseOrders> findByPageBean(Integer currentPage, Integer pageSize);
	
	public PageBean<ReleaseOrders> findByTitlePageBean(String title,Integer currentPage, Integer pageSize);
	
	public	 int count();
	
	public int countByUid(Integer uid);
	
	public List<ReleaseOrders> findThree(Integer uid);

	public List<ReleaseOrders> findByUid(Integer uid);
	
	public boolean deleteByUid(Integer uid);
}
