package cn.mldn.dibmp.service ;

import java.util.Map;
import java.util.Set;

import cn.mldn.dibmp.vo.Warehouse;


public interface IWarehouseService {
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
	 * 查询仓库所有信息，作为列表显示
	 * @return 仓库信息
	 */
	public Map<String,Set<Warehouse>> getAll() ;
}
