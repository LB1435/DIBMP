package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.CustomerRecord;

public interface ICustomerRecordDAO {
	public boolean doCreate(CustomerRecord vo);

	public List<CustomerRecord> findSplit(Map<String, Object> map);

	public Long getCount(Map<String, Object> map);
}
