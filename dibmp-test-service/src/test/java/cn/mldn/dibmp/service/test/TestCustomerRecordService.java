package cn.mldn.dibmp.service.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.ICustomerRecordService;
import cn.mldn.dibmp.vo.CustomerRecord;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestCustomerRecordService extends TestCase {
	@Resource
	private ICustomerRecordService customerRecordService;

	@Test
	public void testCustomerRecordGet() {
		CustomerRecord vo = new CustomerRecord();
		vo.setCdate(new Date());
		vo.setCmid("2333");
		vo.setCrid(6L);
		vo.setCriid(7L);
		vo.setNote("非凡~~~");
		customerRecordService.add(vo);
	}

}
