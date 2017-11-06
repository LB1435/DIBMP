package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.ICsourceService;
import cn.mldn.dibmp.service.IMemberService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestCsourceService extends TestCase {
	@Resource
	private ICsourceService csourceService;

	@Test
	public void testScsourceGet() {
		System.out.println(csourceService.find());
	}

}
