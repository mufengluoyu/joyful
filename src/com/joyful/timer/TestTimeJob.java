package com.joyful.timer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务的测试
 * @author hechangzhi 2016年8月5日10:18:17
 *
 */
@Component
public class TestTimeJob {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	    
	    @Scheduled(cron = "0 * * * * ?")
	    public void run() {
	        logger.info("MyFirstSpringJob trigger...");
	        
	        /* 模拟此Job需耗时5秒 */
	        try {
	            TimeUnit.SECONDS.sleep(5);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
