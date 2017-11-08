package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IStorageApplyService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStorageApply extends TestCase{
	@Resource
	private IStorageApplyService storageApplyService ; 
	
	@Test
	public void testListApp() {
		System.err.println(this.storageApplyService.listApp());
	}
	@Test
	public void testRemove() {
		System.err.println(this.storageApplyService.RemoveStorageApply(1L));
	}
}
