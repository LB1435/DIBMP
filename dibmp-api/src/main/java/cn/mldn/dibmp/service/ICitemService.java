package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.Citem;

public interface ICitemService {
	/**
	 * 查询客户重要性
	 * @return 客户重要性结合
	 */
	public List<Citem> find();
}
