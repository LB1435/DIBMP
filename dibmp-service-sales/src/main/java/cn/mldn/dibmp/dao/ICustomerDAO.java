package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Customer;

public interface ICustomerDAO {
	public boolean doCreate(Customer customer);

	// String column, String keyWord, Long currentPage, Integer lineSize
	// 判断该上面的是否有值,然后通过动态SQL来区别执行
	/**
	 * 1.实现分页显示。2.实现模糊查询分页显示
	 * @param map Map中有String column, String keyWord, Long currentPage, Integer lineSize四个值,判断其中几个值是否为空实现两个功能的实现
	 * @return 查询结果
	 */
	public List<Customer> findSplit(Map<String, Object> map);
	
	/**
	 * 计数分页使用
	 * @param map keyword 和 column 用户模糊查询分页
	 * @return 长度
	 */
	public Long getCount(Map<String, Object> map);
	
	/**
	 * 根据ID查询用户
	 * @param cuid 用户iD
	 * @return 目标用户信息
	 */
	public Customer findByID(Long cuid);
}
