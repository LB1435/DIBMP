package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.Province;

public interface IProvinceService {
	/**
	 * 查询全部省份
	 * @return 省份结合
	 */
	public List<Province> find();
}
