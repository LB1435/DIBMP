package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.StorageApplyDetails;

public interface IStorageApplyDetailsService {
	public List<StorageApplyDetails> findAllDetails() ; 
	
	public List<StorageApplyDetails> getBySaid(Long said) ; 
	
	public List<StorageApplyDetails> getNumAndPrice() ; 
	
	public StorageApplyDetails getNumAndPriceBySaid(long said) ; 
}
