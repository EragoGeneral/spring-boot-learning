package com.ruiyang;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruiyang.task.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSpringBootApplicationTests {

	@Autowired
	private Task task;
	
//	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test() throws Exception{
		long start = System.currentTimeMillis();
		 
		Future<String> task1 = task.taskOne();
		Future<String> task2 = task.taskTwo();
		Future<String> task3 = task.taskThree();
 
		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				String result1 = task1.get();
				String result2 = task2.get();
				String result3 = task3.get();
				System.out.println("Result1: " + result1);
				System.out.println("Result2: " + result2);
				System.out.println("Result3: " + result3);
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
 
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

	}

}
