package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.ICityService;
import cn.mldn.dibmp.vo.City;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestCityService extends TestCase {
	@Resource
	private ICityService cityService;

	@Test
	public void testCityGet() {
		System.err.println(cityService.list(6L));
	}

}
