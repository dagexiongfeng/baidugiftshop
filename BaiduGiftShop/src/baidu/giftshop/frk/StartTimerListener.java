package baidu.giftshop.frk;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartTimerListener implements ServletContextListener {
	
	ChangeState changestate = null;
	TranslateTimer translatetimer = null;
	
	/** 
     * ����һ����ʼ������������һ������������ 
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
//		 changestate = new ChangeState(); // �������ݶ�ʱ��  
//		 changestate.translateGo(); 
//		 changestate.automaticpay();
	}
}
