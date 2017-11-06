package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.ICitemService;
import cn.mldn.dibmp.service.ICsourceService;
import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.service.IProvinceService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestProvinceService extends TestCase {
	@Resource
	private IProvinceService provinceService;

	@Test
	public void testProvinceGet() {
		System.out.println(provinceService.find());
	}

}
