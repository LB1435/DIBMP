package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IWarehouseDAO;
import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.dibmp.vo.City;
import cn.mldn.dibmp.vo.Province;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.dibmp.vo.Witem;
@Service
public class WarehouseServiceImpl implements IWarehouseService {
	
	@Resource
	private IWarehouseDAO whDAO ;
	
	@Override
	public Warehouse getById(Long wid) {
		return this.whDAO.findById(wid);
	}
	
	@Override
	public Warehouse getByName(String name) {
		return this.whDAO.findByName(name);
	}
	
	@Override
	public boolean add(Warehouse wh) {
		if (wh.getName() == null || this.whDAO.findByName(wh.getName())!= null) {
			return false;
		}
		return this.whDAO.doCreate(wh);
	}
	
	@Override
	public Map<String, Set<Warehouse>> getAll() {
		Map<String,Set<Warehouse>> map = new HashMap<>();
		map.put("AllWarehouse", this.whDAO.findAll());
		System.err.println(map);
		return map;
	}

	@Override
	public Map<String, Set<Province>> getAllProvice() {
		Map<String, Set<Province>> map = new HashMap<>();
		map.put("AllProvice", this.whDAO.findAllProvice());
		return map;
	}


	@Override
	public Map<String, Set<Witem>> getAllWitem() {
		Map<String, Set<Witem>> map = new HashMap<>();
		map.put("AllWitem", this.whDAO.findAllWitem());
		return map;
	}

	@Override
	public List<City> getCityByPid(Long pid) {
		return this.whDAO.findByPid(pid);
	}


	
}
