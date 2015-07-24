package baidu.giftshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import baidu.giftshop.model.Base;
import baidu.giftshop.service.IAddressService;
import baidu.giftshop.service.IUserService;

@Controller
public class AddressController {
	
	@Autowired
	@Qualifier("addressService")
	private IAddressService addressService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 增加地址信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/AddAddress")
	public void AddAddress(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		Integer userid = userService.getUid(request.getParameter("userid"));
		String addressee = request.getParameter("addressee");
		addressee = new String(addressee.getBytes("iso8859-1"),"utf-8");
		
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		address = new String(address.getBytes("iso8859-1"),"utf-8");
		String zipCode = request.getParameter("zipCode");
		
		Base base = new Base();
		base = addressService.addAddress(userid, addressee, phone, address, zipCode);
	   
		response.setContentType("text/javascript;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
	}
	
	/**
	 * 查询用户的所有地址信息
	 * @param userid
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/QueryAddress")
	public void QueryAddress(@RequestParam(value="userid",required=false) String userid,
			HttpServletResponse response){
	    Base base = new Base();
	    Integer uid = userService.getUid(userid);
		base = addressService.queryAllAddress(uid);
		response.setContentType("text/javascript;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		 }catch (IOException e) {
			e.printStackTrace();
	   }
	}
	
	/**
	 * 用户删除某个地址信息
	 * @param addressid
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/DeleteAddress")
	public void DeleteAddress(@RequestParam(value="addressid",required=false) Integer addressid,
			HttpServletResponse response) throws Exception{
		Base base = new Base();
		base = addressService.deleteAddress(addressid);
		response.setContentType("text/javascript;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		 }catch (IOException e) {
			e.printStackTrace();
	     }
	}
	
}
