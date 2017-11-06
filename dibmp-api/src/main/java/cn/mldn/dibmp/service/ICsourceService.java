package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.Csource;

public interface ICsourceService {
	/**
	 * 查询全部客户来源
	 * @return 客户来源集合
	 */
	public List<Csource> find();
}
