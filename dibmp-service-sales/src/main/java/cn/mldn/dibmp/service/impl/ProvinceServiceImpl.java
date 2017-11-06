package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IProvinceDAO;
import cn.mldn.dibmp.service.IProvinceService;
import cn.mldn.dibmp.vo.Province;

@Service
public class ProvinceServiceImpl implements IProvinceService {
	@Resource
	private IProvinceDAO provinceDAO;

	@Override
	public List<Province> find() {
		return provinceDAO.findProvince();
	}

}
