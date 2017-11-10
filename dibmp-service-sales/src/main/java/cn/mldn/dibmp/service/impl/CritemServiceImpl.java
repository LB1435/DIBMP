package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ICritemDAO;
import cn.mldn.dibmp.service.ICritemService;
import cn.mldn.dibmp.vo.Critem;

@Service
public class CritemServiceImpl implements ICritemService {
	@Resource
	private ICritemDAO critemDAO;

	@Override
	public List<Critem> list() {
		return critemDAO.findAll();
	}

}
