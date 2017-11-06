package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.dibmp.vo.Warehouse;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestWarehouseService extends TestCase {
	@Resource
	private IWarehouseService whService;

	@Test
	public void test() {
		System.out.println("*********************");
	}
	
	
	@Test
	public void testWarehouseGetById() {
		System.err.println(this.whService.getById(1L));
	}
	@Test
	public void testWarehouseGetAll() {
		System.err.println(this.whService.getAll());
	}
	@Test
	public void testWarehouseGetByName() {
		System.err.println(this.whService.getByName("北京一号仓库"));
	}
	@Test
	public void testAdd() {
		Warehouse wh = new Warehouse();
		wh.setName("北京六号仓库");
		wh.setPid(1L);
		wh.setCid(2L);
		wh.setWiid(10L);
		wh.setAddress("北京朝阳区");
		wh.setArea(100.0);
		wh.setMaximum(250);
		wh.setPhoto("4868748678647");
		wh.setNote("我是备注");
		System.err.println(wh);
		TestCase.assertTrue(whService.add(wh));
	}
}
