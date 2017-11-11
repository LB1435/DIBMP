package cn.mldn.dibmp.service.test;

import java.util.Map;

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
	public void testAAA() {
		System.out.println("*********************");
	}
	
	@Test
	public void testEdit() {
		Warehouse wh = new Warehouse() ; 
		wh.setName("你大爷");
		wh.setPid(20L);
		wh.setCid(20L);
		wh.setWiid(2L);
		wh.setAddress("地狱");
		wh.setArea(250.0);
		wh.setMaximum(250);
		wh.setPhoto("123456465");
		wh.setNote("我干");
		wh.setWid(10L); 
		
		System.err.println(this.whService.edit(wh));
	}
	
	@Test
	public void testEditBywid() {
		System.err.println(this.whService.EditByWid(10L, "mldndfjdkf"));
	}
	
	@Test
	public void testWarehouseGetDept() {
		System.err.println(this.whService.getAllDept());
	}
	
	@Test
	public void testWarehouseGetAllWitem() {
		System.err.println(this.whService.getAllWitem());
	}
	
	@Test
	public void testWarehouseGetById() {
		System.err.println(this.whService.getById(1L));
	}
	@Test
	public void testWarehouseGetAll() {
		Map<String,Object> map = whService.list(1L, 5, null, null);
		System.err.println(map);
	}
	@Test
	public void testWarehouseGetAllProvince() {
		System.err.println(this.whService.getAllProvice());
	}
	@Test
	public void testWarehouseGetByPid() {
		System.err.println(this.whService.getCityByPid(20L));
	}
	
	@Test
	public void testWarehouseGetByName() {
		System.err.println(this.whService.getByName("北京一号仓库"));
	}
	@Test
	public void testAdd() {
		Warehouse wh = new Warehouse();
		wh.setName("北京777号仓库");
		wh.setPid(1L);
		wh.setCid(2L);
		wh.setWiid(10L);
		wh.setAddress("北京朝阳区");
		wh.setArea(100.0);
		wh.setMaximum(250);
		wh.setCurrnum(100);
		wh.setPhoto("4868748678647");
		wh.setNote("我是备注");
		System.err.println(wh);
		TestCase.assertTrue(whService.add(wh));
	}
}
