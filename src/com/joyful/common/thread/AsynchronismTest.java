package com.joyful.common.thread;

public class AsynchronismTest {

	public static void main(String args[]){
		long startTime = System.currentTimeMillis();
		RequestServiceThread.requstTreadStart("1");
		RequestServiceThread.requstTreadStart("2");
		RequestServiceThread.requstTreadStart("3");
		RequestServiceThread.requstTreadStart("4");
		long endTime2 = System.currentTimeMillis();
		System.out.println("执行方法："+(endTime2-startTime));
	}

}
