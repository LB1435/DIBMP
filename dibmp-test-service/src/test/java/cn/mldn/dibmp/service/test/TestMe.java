package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.dibmp.vo.Warehouse;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestMe extends TestCase {
	@Resource
	private IWarehouseService warehouseService ; 
	
	@Test
	public void testAAA() {
		System.err.println("*************");
	}
	
}
