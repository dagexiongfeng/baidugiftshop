package baidu.giftshop.controller;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
/**
 * 统计下载APP下载次数
 * @author tongwenli
 *
 */
@Controller
public class CountUploadController {
	@RequestMapping("/count")
	public ModelAndView count(HttpServletRequest request,	HttpServletResponse response) throws Exception{
		
		
	      InetAddress addr= 	InetAddress.getLocalHost();
	        String host=  addr.getHostAddress();
		ModelAndView mv = new ModelAndView();
		
		RedirectView view = new RedirectView("http://"+host+":8080/BaiduSdk/BaiduGiftMobile.apk");
		
		mv.setView(view);
		int count=0;
		System.err.println(count++);
		return mv;
	}
}
