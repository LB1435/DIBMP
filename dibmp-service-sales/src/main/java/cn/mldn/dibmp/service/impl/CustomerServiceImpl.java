package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ICitemDAO;
import cn.mldn.dibmp.dao.ICustomerDAO;
import cn.mldn.dibmp.service.ICustomerService;
import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.Customer;
import cn.mldn.util.service.abs.AbstractService;

@Service
public class CustomerServiceImpl extends AbstractService implements ICustomerService {
	@Resource
	private ICustomerDAO customerDAO;

	@Resource
	private ICitemDAO citemDAO;

	@Override
	public boolean add(Customer customer) {
		return customerDAO.doCreate(customer);
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("allcustomer", customerDAO.findSplit(super.paramToMap(currentPage, lineSize, column, keyWord)));
		map.put("allRecorders", customerDAO.getCount(super.paramToMap(currentPage, lineSize, column, keyWord)));

		List<Citem> citems = this.citemDAO.findCitem();
		Map<Long, String> citemsMap = new HashMap<>();
		Iterator<Citem> iterator = citems.iterator();
		while (iterator.hasNext()) {
			Citem vo = iterator.next();
			citemsMap.put(vo.getCiid(), vo.getTitle());
		}
		map.put("citems", citemsMap);
		return map;
	}

	@Override
	public Customer findSingal(long cuid) {
		return customerDAO.findByID(cuid);
	}
}
