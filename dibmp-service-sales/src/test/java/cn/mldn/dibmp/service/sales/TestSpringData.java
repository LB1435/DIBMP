package cn.mldn.dibmp.service.sales;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringData {
	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Test
	public void testSet() { 
		this.redisTemplate.opsForValue().set("dnlm", "23333");
	}

	@Test 
	public void testGet() {
		System.err.println(this.redisTemplate.opsForValue().get("dnlm"));
	}
}
