package cn.mldn.dibmp.dao;

import java.util.Map;

import cn.mldn.dibmp.vo.Member;

public interface IMemberDAO {
	public Member findById(String id);
	
	/**
	 * 锁定当前登录的员工,一个员工一次只能服务一个客户
	 * @param id 员工ID
	 * @return 更新是否成功
	 */
	public boolean lockMember(Map<String, Object> map);
}
