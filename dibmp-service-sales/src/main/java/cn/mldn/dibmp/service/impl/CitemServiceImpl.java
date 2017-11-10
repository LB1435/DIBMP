package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ICitemDAO;
import cn.mldn.dibmp.dao.ICritemDAO;
import cn.mldn.dibmp.service.ICitemService;
import cn.mldn.dibmp.service.ICritemService;
import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.Critem;

@Service
public class CitemServiceImpl implements ICitemService {
	@Resource
	private ICitemDAO citemDAO;


	@Override
	public List<Citem> find() {
		return citemDAO.findCitem();
	}

}
