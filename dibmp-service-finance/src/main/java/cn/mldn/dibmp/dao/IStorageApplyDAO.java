package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.StorageApply;

public interface IStorageApplyDAO {
	public List<StorageApply> findAllApp() ; 
	
	public StorageApply findById(Long said) ; 
	
	public boolean deleteStorageApply(Long said) ; 
}
