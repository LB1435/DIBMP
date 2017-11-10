package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ICustomerRecordDAO;
import cn.mldn.dibmp.service.ICustomerRecordService;
import cn.mldn.dibmp.vo.CustomerRecord;
import cn.mldn.util.service.abs.AbstractService;

@Service
public class CustomerRecordServiceImpl extends AbstractService implements ICustomerRecordService {
	@Resource
	private ICustomerRecordDAO customerRecordDAO;
	@Override
	public boolean add(CustomerRecord customerRecord) {
		return customerRecordDAO.doCreate(customerRecord);
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String, Object> map = new HashMap<>();
//		map.put("allcustomer", customerDAO.findSplit(super.paramToMap(currentPage, lineSize, column, keyWord)));
//		map.put("allRecorders", customerDAO.getCount(super.paramToMap(currentPage, lineSize, column, keyWord)));
//		List<Citem> citems = this.citemDAO.findCitem();
//		Map<Long, String> citemsMap = new HashMap<>();
//		Iterator<Citem> iterator = citems.iterator();
//		while (iterator.hasNext()) {
//			Citem vo = iterator.next();
//			citemsMap.put(vo.getCiid(), vo.getTitle());
//		}
//		map.put("citems", citemsMap);
		return map;
	}

}
