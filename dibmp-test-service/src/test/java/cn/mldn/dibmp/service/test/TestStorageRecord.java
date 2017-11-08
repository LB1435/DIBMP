package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IStorageRecordService;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.vo.StorageApplyDetails;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStorageRecord extends TestCase{
	@Resource
	private IStorageRecordService storageRecordService; 
	
	@Test
	public void testListApp() {
		StorageApply voa = new StorageApply() ; 
		voa.setSaid(1L);
		voa.setTitle("戏子");
		voa.setWid(1L);
		voa.setAppmid("mldn");
		StorageApplyDetails vob = new StorageApplyDetails() ; 
		vob.setNum(11);
		vob.setPrice(33.2);
		vob.setWeight(33.4);
		String inmid = "www" ; 
		System.err.println(this.storageRecordService.addToStorage(voa, vob, inmid));
	}
	@Test
	public void testAllStorage() {
		System.err.println(this.storageRecordService.getAllStorageRecord());
	}
}
