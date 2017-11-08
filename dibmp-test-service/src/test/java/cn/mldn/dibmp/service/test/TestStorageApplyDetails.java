package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IStorageApplyDetailsService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStorageApplyDetails extends TestCase{
	@Resource
	private IStorageApplyDetailsService storageApplyDetailsService ; 
	
	@Test
	public void testListApp() {
		System.err.println(this.storageApplyDetailsService.getNumAndPrice());
	}
	@Test
	public void testGetApp() {
		System.err.println(this.storageApplyDetailsService.getBySaid(1L));
	}
}
