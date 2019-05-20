package dao; 

import java.util.List;

import entity.ReleaseOrders;


public interface ReleaseOrdersDAO {
	public int save(ReleaseOrders releaseOrders);
	
	public int update(ReleaseOrders releaseOrders);
	
	public List<ReleaseOrders> findAll();
	
	public int deleteById(Integer id);
	
	public int deleteByUid(Integer uid);
	
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
	public List<ReleaseOrders> findByPidPage(Integer pid,Integer currentPage,Integer pageSize);
	
	public List<ReleaseOrders> findBySidPage(Integer sid,Integer currentPage,Integer pageSize);
	
	public List<ReleaseOrders>  findBySidAndPidPage(Integer sid,Integer pid,Integer currentPage,Integer pageSize);
	
	public List<ReleaseOrders>  findAllByPage(Integer currentPage,Integer pageSize);
	
	public List<ReleaseOrders> findByPiTiPage(Integer pid,String title,Integer currentPage,Integer pageSize);
	
	public List<ReleaseOrders> findBySiTiPage(Integer sid,String title,Integer currentPage,Integer pageSize);
	
	public List<ReleaseOrders>  findBySiPiTiPage(Integer sid,Integer pid,String title,Integer currentPage,Integer pageSize);
	
	
	public List<ReleaseOrders>  findTitleByPage(String title,Integer currentPage,Integer pageSize);
	public int count();
	
	public int countByUid(Integer uid);
	
	//查找最近的三个职位
	public List<ReleaseOrders>  findThree(Integer uid);
	
	public List<ReleaseOrders>  findByUid(Integer uid);
	
	
}
