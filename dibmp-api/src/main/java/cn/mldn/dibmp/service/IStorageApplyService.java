package cn.mldn.dibmp.service;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.StorageApply;

public interface IStorageApplyService {
	public List<StorageApply> listApp() ; 
	
	public Map<String,Object> findToMap(long said) ; 
	
	public boolean RemoveStorageApply(long said) ; 
	
	public StorageApply findBySaid(long said) ; 
	
}
