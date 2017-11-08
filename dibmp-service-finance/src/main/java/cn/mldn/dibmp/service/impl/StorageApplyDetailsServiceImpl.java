package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDetalisDAO;
import cn.mldn.dibmp.service.IStorageApplyDetailsService;
import cn.mldn.dibmp.vo.StorageApplyDetails;

@Service
public class StorageApplyDetailsServiceImpl implements IStorageApplyDetailsService {
	
	@Resource
	private IStorageApplyDetalisDAO storageApplyDetalisDAO ; 
	
	@Override
	public List<StorageApplyDetails> findAllDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StorageApplyDetails> getBySaid(Long said) {
		return this.storageApplyDetalisDAO.findBySaid(said);
	}

	@Override
	public List<StorageApplyDetails> getNumAndPrice() {
		return this.storageApplyDetalisDAO.findPrice();
	}

	@Override
	public StorageApplyDetails getNumAndPriceBySaid(long said) {
		return this.storageApplyDetalisDAO.findNumPrice(said);
	}

}
