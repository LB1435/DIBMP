package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.StorageApplyDetails;

public interface IStorageApplyDetalisDAO {
	public List<StorageApplyDetails> findPrice() ; 
	
	public List<StorageApplyDetails> findBySaid(Long said) ; 
	
	public StorageApplyDetails findNumPrice(Long said) ; 
}
