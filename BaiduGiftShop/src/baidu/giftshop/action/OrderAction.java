package baidu.giftshop.action;

import java.util.List;
import java.util.Map;

import baidu.giftshop.bean.NewOrderBean;
import baidu.giftshop.bean.PageBean;
import baidu.giftshop.service.IOrderService;
import baidu.giftshop.service.impl.OrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	
	private Integer page = 1;
	private Integer subbranch_id;
	private PageBean pageBean = new PageBean();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String listAllOrder() throws Exception{
		
		pageBean.setCurrentPage(page);
		IOrderService orderservice = new OrderService();
		List<NewOrderBean> list = orderservice.listAllOrder(pageBean,subbranch_id);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
//		Map session=(Map)ActionContext.getContext().getSession();
//		session.put("pageBean", pageBean);
		request.put("pageBean",pageBean);
		return SUCCESS;
	}
	
	public String Setlogistics() throws Exception{
		IOrderService orderservice = new OrderService();
		orderservice.addlogistics(userid, orderid, shipnum, fedex);
		return SUCCESS;
	}
	
	private String userid;
	
	private String orderid;
	
	private String shipnum;
	
    private String fedex;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getShipnum() {
		return shipnum;
	}

	public void setShipnum(String shipnum) {
		this.shipnum = shipnum;
	}

	public String getFedex() {
		return fedex;
	}

	public void setFedex(String fedex) {
		this.fedex = fedex;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public PageBean getPagebean() {
		return pageBean;
	}

	public void setPagebean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Integer getSubbranch_id() {
		return subbranch_id;
	}

	public void setSubbranch_id(Integer subbranch_id) {
		this.subbranch_id = subbranch_id;
	}
}
