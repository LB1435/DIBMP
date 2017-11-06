package cn.mldn.dibmp.service;

import cn.mldn.dibmp.vo.Customer;

public interface ICustomerService {
	/**
	 * 实现客户添加
	 * @param customer 添加的客户信息
	 * @return 添加是否成功
	 */
	public boolean add(Customer customer);
}
