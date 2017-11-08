package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDAO;
import cn.mldn.dibmp.service.IStorageApplyService;
import cn.mldn.dibmp.vo.StorageApply;

@Service
public class StorageApplyServiceImpl implements IStorageApplyService {
	@Resource
	private IStorageApplyDAO storageApplyDAO ; 
	@Override
	public List<StorageApply> listApp() {
		return this.storageApplyDAO.findAllApp() ; 
	}
	@Override
	public Map<String, Object> findToMap(long said) {
		Map<String,Object> map = new HashMap<String,Object>() ; 
		map.put("storApp", this.storageApplyDAO.findById(said)) ; 
		return map;
	}
	@Override
	public boolean RemoveStorageApply(long said) {
		return this.storageApplyDAO.deleteStorageApply(said);
	}
	@Override
	public StorageApply findBySaid(long said) {
		return this.storageApplyDAO.findById(said);
	}

}
