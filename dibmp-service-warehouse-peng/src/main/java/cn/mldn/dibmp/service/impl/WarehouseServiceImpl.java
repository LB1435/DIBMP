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
import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Member;
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
	public Map<String, Object> list(Long currentPage,Integer lineSize,String column,String keyWord) {
		Map<String,Object> map = new HashMap<>();
		Map<String,Object> mapa = new HashMap<>() ; 
		mapa.put("column", column) ; 
		mapa.put("keyWord", "%"+"keyWord"+"%") ; 
		mapa.put("start", (currentPage - 1) * lineSize) ; 
		mapa.put("lineSize", lineSize) ; 
			map.put("AllWarehouse", whDAO.findSplit(mapa));
			map.put("allRecorders", whDAO.getSplitCount(mapa));
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

	@Override
	public List<Dept> getAllDept() {
		return this.whDAO.findAllDept();
	}

	@Override
	public List<Member> getMemberByDid(Long did) {
		return this.whDAO.findByDid(did);
	}

	@Override
	public boolean EditByWid(long wid,String admin) {
		Map<String,Object> map = new HashMap<>() ;
		map.put("wid", wid) ; 
		map.put("admin", admin) ; 
		return this.whDAO.doEditByWid(map) ; 
	}

	@Override
	public boolean edit(Warehouse wh) {
		return this.whDAO.doEdit(wh);
	}
}
