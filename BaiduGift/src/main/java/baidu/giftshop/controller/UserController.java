package baidu.giftshop.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import baidu.giftshop.model.Base;
import baidu.giftshop.model.User;
import baidu.giftshop.service.IUserService;
import baidu.giftshop.util.MD5Util;

@Controller
public class UserController {
	
	
	@Autowired
	private IUserService userService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping("/login")
	public Object login(@RequestParam(value="username") String username,@RequestParam(value="type") String type, @RequestParam(value="token") String token, HttpServletResponse response) throws Exception{
	
		if(MD5Util.MD5(username+type+"shabi").equals(token)){
		 Base base=new Base();
		 base.setCode(101);
	     base.setResult("OK");
		 User user=  userService.getUser(username);
		 if(user==null){
			 User user1 =new User();
			 String userid=UUID.randomUUID().toString().replace("-", "");
			 System.out.println(userid);
			 user1.setUserId(userid);
			 user1.setUsername(username);
			 user1.setType(type);
		     userService.saveUser(user1);
		     base.setContent(user1);
		     return base;
		 }else{
			 base.setContent(user);
			 return base;
		 }
		}
		return null;
	}
}
