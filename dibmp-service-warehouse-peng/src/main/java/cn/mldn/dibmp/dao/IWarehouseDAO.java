package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dibmp.vo.City;
import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Member;
import cn.mldn.dibmp.vo.Province;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.dibmp.vo.Witem;

public interface IWarehouseDAO {
	
	//修改仓库信息
	public boolean doEdit(Warehouse wh);
	
	//通过仓库编号修改仓库管理人员
	public boolean doEditByWid(Map<String,Object> map);
	
	//根据pid 查询 Member信息
	public List<Member> findByDid(Long did) ; 
	
	//查询所有部门信息
	public List<Dept> findAllDept();
	
	
	//仓库增加
	public boolean doCreate(Warehouse wh);
	
	//通过仓库名称查找仓库信息
	public Warehouse findByName(String name);
	
	//通过id查找仓库信息
	public Warehouse findById(Long wid);
	
	//查询 全部
	//public Set<Warehouse> findAll(); 
	
	//查找所有身份信息
	public Set<Province> findAllProvice();
	
	//查找所有城市信息
	public List<City> findByPid(Long pid);
	
	//查找所有分类信息
	public Set<Witem> findAllWitem();
	
	//分页模糊查询
	public List<Warehouse> findSplit(Map<String,Object> map);
	
	//模糊统计查询
	public Long getSplitCount(Map<String,Object> map);
	
	
	
}
