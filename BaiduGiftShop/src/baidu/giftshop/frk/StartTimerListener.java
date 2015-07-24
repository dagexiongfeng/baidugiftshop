package baidu.giftshop.frk;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartTimerListener implements ServletContextListener {
	
	ChangeState changestate = null;
	TranslateTimer translatetimer = null;
	
	/** 
     * 创建一个初始化监听器对象，一般由容器调用 
     */  
    public StartTimerListener() {  
        super();  
    } 

	@Override
	public void contextDestroyed(ServletContextEvent e) {
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		 System.out.println("-------------StartTimerListener.init-------------"); 
		 translatetimer = new TranslateTimer();
		 translatetimer.executeTranslateTimer();
//		 changestate = new ChangeState(); // 启动数据定时器  
//		 changestate.translateGo(); 
//		 changestate.automaticpay();
	}
}
