package cn.mldn.dibmp.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ICsourceDAO;
import cn.mldn.dibmp.service.ICsourceService;
import cn.mldn.dibmp.vo.Csource;
@Service
public class CsourceServiceImpl implements ICsourceService{
@Resource 
private ICsourceDAO csourcedao;
	@Override
	public List<Csource> find() {
		return csourcedao.findCsource();
	}

}
