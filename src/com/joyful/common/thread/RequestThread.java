package com.joyful.common.thread;

public class RequestThread {
	
	private RequestContentService rc;//请求主体
	
	public RequestThread(){
	}
	protected void start(){ //开始请求
		if(RequestServiceThread.t == null){
			RequestServiceThread.t=new Thread(new Runnable(){
				public void run(){
					while(true){
						 try {  System.out.println("threads长度:"+RequestServiceThread.threads.size());
							 	rc = RequestServiceThread.threads.take();		// 从盘子开始取一个，如果盘子空了，当前线程阻塞  
								try{
								    rc.doSomeThing();//响应请求
								}catch (Exception e) {
								    e.printStackTrace();
								    rc.onFailure(); //如果执行失败
								}
								rc.onSuccess();//如果执行成功
								
					        } catch (InterruptedException e) {  
					            e.printStackTrace();  
					            break;
					        }  
						} 
					}
				}
			 );
			RequestServiceThread.t.start();
		}
	}
	public RequestContentService getRc() {
		return rc;
	}
	public void setRc(RequestContentService rc) {
		this.rc = rc;
	}
	
}
