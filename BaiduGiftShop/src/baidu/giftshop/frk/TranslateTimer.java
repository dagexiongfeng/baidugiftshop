package baidu.giftshop.frk;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TranslateTimer {

	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);  
  
	ChangeState changeState = new ChangeState(); //操作实现类，我这里为翻译类  
    public void executeTranslateTimer() {  
  
        Runnable task = new Runnable() {  
            public void run() {  
            	try {
					changeState.translateGo(); //调用操作实现方法  
					System.out.println("==============");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            	
				try {
					changeState.automaticpay();
					System.out.println("ooooooo");
				} catch (Exception e) {
					e.printStackTrace();
				}
            }  
        };
        if (scheduler.isShutdown()) {  
        	scheduler = Executors.newScheduledThreadPool(1);  
            scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.HOURS);  
        } else {  
            scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.HOURS); // 延迟10秒，每隔10分钟翻译一次  
        }  
    }  
  
	 //停止任务，不再提交新任务，已提交任务会继续执行以致完成  
	  public void stop() {  
	        scheduler.shutdown();  
	  }  
	  public static void main(String[] args) {
		  TranslateTimer s=new TranslateTimer();
		  s.executeTranslateTimer();	
	  }
}
