package cn.mldn.dibmp.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageRecordDAO;
import cn.mldn.dibmp.service.IStorageRecordService;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.vo.StorageApplyDetails;
import cn.mldn.dibmp.vo.StorageRecord;

@Service
public class StorageRecordServiceImpl implements IStorageRecordService {
	@Resource
	private IStorageRecordDAO storageRecordDAO ; 
	@Override
	public boolean addToStorage(StorageApply voa, StorageApplyDetails vob,String inmid) {
		Map<String,Object> map = new HashMap<String,Object>() ; 
		map.put("said", voa.getSaid()) ; 
		map.put("wid", voa.getWid()) ;
		map.put("title", voa.getTitle()) ; 
		map.put("appmid", voa.getAppmid()) ; 
		map.put("num", vob.getNum()) ;
		map.put("price", vob.getPrice()) ; 
		map.put("weight", vob.getWeight()) ; 
		map.put("inmid", inmid) ; 
		map.put("redate", new Date()) ; 
		return this.storageRecordDAO.addStorage(map);
	}
	@Override
	public List<StorageRecord> getAllStorageRecord() {
		return this.storageRecordDAO.findAllRecord();
	}

}
