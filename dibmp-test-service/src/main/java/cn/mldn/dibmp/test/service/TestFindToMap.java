package cn.mldn.dibmp.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.service.IStorageApplyService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestFindToMap extends TestCase {
	@Resource
	private IStorageApplyService storageApplyService ; 

	@Test
	public void testMembetGet() {
		System.err.println(this.storageApplyService.findToMap(1L));
	}
}
