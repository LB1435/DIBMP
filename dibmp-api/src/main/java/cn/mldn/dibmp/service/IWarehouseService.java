package cn.mldn.dibmp.service ;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dibmp.vo.City;
import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Member;
import cn.mldn.dibmp.vo.Province;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.dibmp.vo.Witem;


public interface IWarehouseService {
	/**
	 * 修改仓库管理员
	 * @return 失败返回false
	 */
	public boolean EditByWid(long wid,String admin);
	
	/**
	 * 获取部门信息，用户部门下拉框显示
	 * @return
	 */
	public List<Dept> getAllDept();
	
	/**
	 * 根据仓库WID获得一个仓库的完整对象信息
	 * @param mid 要查询的仓库的WID
	 * @return 仓库对象，如果仓库不存在返回null
	 */
	public Warehouse getById(Long wid) ;
	
	/**
	 * 根据仓库名字，获得一个仓库的完整对象信息
	 * @param name 要查询的仓库名字
	 * @return 仓库对象，如果仓库不存在放回 null
	 */
	public Warehouse getByName(String name);
	
	
	/**
	 * 增加仓库信息
	 * @param wh 需要增加的信息
	 * @return 增加成功返回true 失败返回false
	 */
	public boolean add(Warehouse wh);
	
	
	/**
	 * 查询所有的省份信息
	 * @return 省份信息
	 */
	public Map<String,Set<Province>> getAllProvice();
	/**
	 * 通过pid 查询城市信息
	 * @param pid 省份id
	 * @return pid对应的城市信息
	 */
	public List<City> getCityByPid(Long pid);
	
	/**
	 * 查询所有的分类信息
	 * @return 分类信息
	 */
	public Map<String,Set<Witem>> getAllWitem();
	/**
	 * 商品清单分页模糊显示
	 * @param currentPage 当前页
	 * @param lineSize 每页的行数
	 * @param column 模糊查询的列
	 * @param keyWord 模糊查询的关键字
	 * @return 以map集合的形式返回
	 * 1、key = "allWarehouse", value表示所有的商品
	 * 2、key = "allRecorders", value表示所有的记录数
	 */
	public Map<String,Object> list(Long currentPage,Integer lineSize,String column,String keyWord) ;

	public List<Member> getMemberByDid(Long did) ; 
}
