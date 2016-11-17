package com.joyful.common.thread;

import com.joyful.common.util.SpringContextUtil;

public class RequestContentService {

	private boolean flag = false;	//是否屏蔽
	private String postId;	//帖子id

	public RequestContentService(String postId){
		this.postId = postId;
	}
	
	//用户必须实现这个抽象方法，告诉子线程要做什么
	public void doSomeThing() {
		// TODO Auto-generated method stub
		SpringContextUtil.getBean("");
		try {
			Thread.sleep(6000);	//查询屏蔽字的方法
			System.out.println("执行方法flag："+postId);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//执行成功的动作。用户可以覆盖此方法
	public synchronized  void onSuccess(){
		System.out.println("===================================成功实现该方法"+this.postId);	//修改评论的字段
	}
	//执行失败的动作。用户可以覆盖此方法
	public void onFailure(){ //执行失败的动作。用户可以覆盖此方法
		 System.out.println("屏蔽字调查寻结果失败用失败");
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

}
