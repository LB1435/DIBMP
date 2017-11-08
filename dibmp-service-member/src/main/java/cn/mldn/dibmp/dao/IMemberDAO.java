package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Level;
import cn.mldn.dibmp.vo.Member;

public interface IMemberDAO {
	public Member findById(String id);
	
	public List<Level> findAllLevel() ; 
	
	public List<Dept> findAllDept() ; 
}
