package baidu.giftshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import baidu.giftshop.model.Base;
import baidu.giftshop.service.ISubbranchService;
@Controller
public class SubbranchController {
	@Autowired
	@Qualifier("subbranchService")
	private ISubbranchService subbranchServcie;
	
	/**
	 * 分店信息列表
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/SubbranchList")
	public void SubbranchList(HttpServletRequest request,HttpServletResponse response){
		Base base = subbranchServcie.getAllSubbranch();
		
	   response.setContentType("text/javascript;charset=UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   try {
		response.getWriter().print(JSON.toJSONString(base));
	} catch (IOException e) {
		e.printStackTrace();
	    }
	}

}
