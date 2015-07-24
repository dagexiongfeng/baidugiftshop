package baidu.giftshop.service;

import java.util.List;

import baidu.giftshop.bean.PageBean;
import baidu.giftshop.entity.Account;

public interface IUserService {
	
	public void addUser(String account,String password,Integer subbranch,String email,String tel);
	
	public Account loginService(String account,String password);
	
	public void changPassword(Integer id,String password);
	
	public String valuationUsername(String account);
	
	public String valuationEmail(String email);
	
	public List<Account> getAllUser(PageBean pageBean);
	
	public void deleteUser(Integer id);
}
