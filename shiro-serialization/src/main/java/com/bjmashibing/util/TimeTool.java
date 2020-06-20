package com.bjmashibing.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>计算方法执行时间工具类-粗略测试批量导入导出考勤报表用</p>
 *
 * @author sunzhiqiang23
 * @date 2019/12/25 11:22
 */
@Slf4j
public class TimeTool {
	private static final SimpleDateFormat FMT = new SimpleDateFormat("HH::mm:ss.SSS");
	
	public interface Task {
		void execute();
	}
	
	public static void check(String title, Task task) {
		if (task == null) {
			return;
		}
		title = (title == null) ? "" : ("【" + title + "】");
		System.out.println(title);
		
		long begin = System.currentTimeMillis();
		task.execute();
		long end = System.currentTimeMillis();
		
		
		System.out.println("结束：" + FMT.format(new Date()));
		double delta = (end - begin) / 1000.0;
		System.out.println("耗时：" + delta + "秒");
		System.out.println("-------------------------");
		
	}
	
	
}
