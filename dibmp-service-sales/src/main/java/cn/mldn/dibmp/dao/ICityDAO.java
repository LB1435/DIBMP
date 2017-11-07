package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.City;

public interface ICityDAO {
	public List<City> findCity(Long pid);
}
