package com.github.mrs;

import com.github.mrs.service.MainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("junit5测试")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"pro"})//激活环境配置
class MrsMulitiThreadApplicationTests {

	@Autowired
	Student student;

	@Autowired
	MainService mainService;

	@DisplayName("简单测试断言")
	@Test
	void testAssert() {

		System.out.println(student.goClass());

		int call = call(1, 2);
		//判断两个对象或两个原始类型是否相等
		assertEquals(2, call, "业务逻辑计算失败");

		Object obj1 = new Object();
		Object obj2 = new Object();
		assertSame(obj1, obj2, "两个对象不一样");


	}

	int call (int x, int y) {
		return x + y;
	}

	@Test
	void testMulitiThread() {
		mainService.test1();
	}

	@Test
	void testMulitiThread2() {
		mainService.test2();
	}



}
