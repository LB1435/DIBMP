package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IWarehouseDAO;
import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.dibmp.vo.Warehouse;
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
		return map;
	}

	
}
