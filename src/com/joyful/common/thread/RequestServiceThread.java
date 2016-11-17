package com.joyful.common.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestServiceThread {
	public static BlockingQueue<RequestContentService> threads = new LinkedBlockingQueue<RequestContentService>();		//队列
	public static Thread t = null;		//线程
	public static void requstTreadStart(String postId){
		try {
			threads.put(new RequestContentService(postId));// 向盘子末尾放一个处理，如果盘子满了，当前线程阻塞  
			new RequestThread().start();//线程启动 异步调用启动
			System.out.println(Thread.activeCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
