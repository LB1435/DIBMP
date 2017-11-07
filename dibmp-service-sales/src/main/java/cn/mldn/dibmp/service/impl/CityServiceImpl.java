package cn.mldn.dibmp.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ICitemDAO;
import cn.mldn.dibmp.dao.ICityDAO;
import cn.mldn.dibmp.dao.ICsourceDAO;
import cn.mldn.dibmp.service.ICitemService;
import cn.mldn.dibmp.service.ICityService;
import cn.mldn.dibmp.service.ICsourceService;
import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.City;
import cn.mldn.dibmp.vo.Csource;
@Service
public class CityServiceImpl implements ICityService{
@Resource 
private ICityDAO cityDAO;
	@Override
	public List<City> list(long pid) {
		return cityDAO.findCity(pid);
	}

}
