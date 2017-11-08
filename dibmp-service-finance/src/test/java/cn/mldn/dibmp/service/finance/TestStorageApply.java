package cn.mldn.dibmp.service.finance;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IStorageApplyService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStorageApply {
	@Resource
	private IStorageApplyService storageApplyService ; 
	@Test
	public void testListApp() {
		TestCase.assertNotNull(storageApplyService.listApp());
	}
}
