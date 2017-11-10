package cn.mldn.dibmp.service;

import java.util.Map;

import cn.mldn.dibmp.vo.CustomerRecord;

public interface ICustomerRecordService {
	public boolean add(CustomerRecord customerRecord);

	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize);
}
