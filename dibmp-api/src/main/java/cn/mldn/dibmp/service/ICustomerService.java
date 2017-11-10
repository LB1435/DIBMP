package cn.mldn.dibmp.service;

import java.util.Map;

import cn.mldn.dibmp.vo.Customer;

public interface ICustomerService {
	/**
	 * 实现客户添加
	 * 
	 * @param customer
	 *            添加的客户信息
	 * @return 添加是否成功
	 */
	public boolean add(Customer customer);

	/**
	 * 查询顾客表
	 * 
	 * @return 返回整个顾客表的集合
	 */
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize);
	
	/**
	 * 查询单个
	 * @param cuid 目标ID
	 * @return VO
	 */
	public Customer findSingal(long cuid);
}
