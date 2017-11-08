package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.vo.StorageApplyDetails;
import cn.mldn.dibmp.vo.StorageRecord;

public interface IStorageRecordService {
	public boolean addToStorage(StorageApply voa,StorageApplyDetails vob,String inmid) ;
	
	public List<StorageRecord> getAllStorageRecord() ; 
}	
