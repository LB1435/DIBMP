package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.StorageRecord;

public interface IStorageRecordDAO {
	public boolean addStorage(Map<String,Object> map) ; 
	
	public List<StorageRecord> findAllRecord() ; 
}
