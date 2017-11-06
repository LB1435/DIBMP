package cn.mldn.dibmp.dao;

import java.util.Set;

import cn.mldn.dibmp.vo.Warehouse;

public interface IWarehouseDAO {
	//仓库增加
	public boolean doCreate(Warehouse wh);
	
	//通过仓库名称查找仓库信息
	public Warehouse findByName(String name);
	
	//通过id查找仓库信息
	public Warehouse findById(Long wid);
	
	//分页模糊统计查询
	public Set<Warehouse> findAll(); 
	
	
}
