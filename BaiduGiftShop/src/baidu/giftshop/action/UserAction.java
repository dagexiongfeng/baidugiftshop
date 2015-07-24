package baidu.giftshop.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import baidu.giftshop.bean.PageBean;
import baidu.giftshop.entity.Account;
import baidu.giftshop.frk.AESDAO;
import baidu.giftshop.service.IGoodsService;
import baidu.giftshop.service.IUserService;
import baidu.giftshop.service.impl.GoodsService;
import baidu.giftshop.service.impl.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer aid;
	private String  account;
	private String  password;
	private String  subbranch;
	private String result;
	private String email;
	private String tel;
	private Integer page = 1;
	private PageBean pageBean = new PageBean();
	
	IUserService userService = new UserService();
	public String register() throws Exception{
		if(account.equals("") || password.equals("") || email.equals("") || subbranch.equals("0")){
		   return ERROR;
		}else{
		   IGoodsService goodsService = new GoodsService();
		   Integer subbranchid = goodsService.querysubbranch(subbranch);
		   userService.addUser(account, password,subbranchid,email,tel);
		   return SUCCESS;
		}
	}
	/**
	 * 用户登陆
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		   HttpServletRequest request = ServletActionContext.getRequest();
		   HttpSession session = request.getSession();
		   if(session.getAttribute("user")!=null){
			   Account ac = (Account) session.getAttribute("user");
			   if(ac.getSubbranchId()==null)
				   return SUCCESS;
			   else
				   return "subbranch";
		   }else{
		      Account acc = userService.loginService(account, password);
		   if(acc!=null&&acc.getSubbranchId()==null){
		      session.setAttribute("user", acc);
		      return SUCCESS;
		   }else if(acc!=null&&acc.getSubbranchId()!=null){
			  session.setAttribute("user", acc);
		      return "subbranch";
		   }else{
			  return ERROR;
		   }
		   }
	}

	public void logout() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.sendRedirect("./login.jsp");
	}
	/**
	 * 改密码
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public String changPassword() throws Exception{
		AESDAO AesDao = new AESDAO();
		Integer uid = Integer.parseInt(AesDao.desCrytStr(id));
		userService.changPassword(uid, password);
		return SUCCESS;
	}
	
	public void deleteUser() throws Exception{
		userService.deleteUser(aid);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("./getAllUser.action");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getAllUser() throws Exception{
		pageBean.setCurrentPage(page);
		List<Account> list = userService.getAllUser(pageBean);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("pageBean", pageBean);
		return SUCCESS;
	}
	
	public String valuationUsername() throws Exception{
		result = userService.valuationUsername(account);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		            out.print(result);  
		            out.flush();
		return null;
	}
	
	public String valuationEmail() throws Exception{
		result = userService.valuationEmail(email);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubbranch() {
		return subbranch;
	}

	public void setSubbranch(String subbranch) {
		this.subbranch = subbranch;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
}
