package baidu.giftshop.service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import baidu.giftshop.bean.Base;
import baidu.giftshop.bean.PageBean;
import baidu.giftshop.dao.UserDAO;
import baidu.giftshop.entity.Account;
import baidu.giftshop.service.IUserService;

public class UserService implements IUserService {
	private String result;

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private UserDAO userDAO;
	@Override
	public void addUser(String account, String password,Integer subbranch,String email,String tel) {
		userDAO = new UserDAO();
		userDAO.addUser(account,password,subbranch,email,tel);
		
	}
	@Override
	public Account loginService(String account, String password) {
		userDAO = new UserDAO();
		Account acc = userDAO.login(account, password);
		return acc;
	}
	@Override
	public void changPassword(Integer id, String password) {
		userDAO = new UserDAO();
		userDAO.changPwd(id, password);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String valuationUsername(String account) {
		userDAO = new UserDAO();
		if(userDAO.valuationUsername(account)>0){
		Base base = new Base();
		base.setContent(true);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{""});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		}else{
			Base base = new Base();
			base.setContent(false);
			
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{""});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
		}
		return result;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String valuationEmail(String email) {
		userDAO = new UserDAO();
		if(userDAO.valuationEmail(email)>0){
			Base base = new Base();
			base.setContent(true);
			
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{""});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
			}else{
				Base base = new Base();
				base.setContent(false);
				
				JsonConfig jsonConfig = new JsonConfig();  
				jsonConfig.setIgnoreDefaultExcludes(false); 
				jsonConfig.setExcludes(new String[]{""});
				@SuppressWarnings("unused")
				JSONObject jsonObject = new JSONObject();
				result = JSONObject.fromObject(base,jsonConfig).toString();
			}
		return result;
	}
	@Override
	public List<Account> getAllUser(PageBean pageBean) {
		userDAO = new UserDAO();
		List<Account> list = userDAO.getAllUser();
		int totalSize = list.size();
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = 5;
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;
		return userDAO.getAllUser(maxResult,firstResult);
	}

	@Override
	public void deleteUser(Integer id) {
		userDAO = new UserDAO();
		
		userDAO.deleteUser(id);
	}
}
