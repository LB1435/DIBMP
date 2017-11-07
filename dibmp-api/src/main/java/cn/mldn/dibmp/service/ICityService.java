package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.City;

public interface ICityService {
	/**
	 * 根据pid查询全部城市
	 * @return 城市集合
	 */
	public List<City> list(long pid);
}
