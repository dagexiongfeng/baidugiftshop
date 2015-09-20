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
	private Integer subbranchId;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Integer getSubbranchId() {
		return subbranchId;
	}

	public void setSubbranchId(Integer subbranchId) {
		this.subbranchId = subbranchId;
	}

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
	
	/*
	 *显示已支付待发货的订单 
	 */
	public String listPayOrders() throws Exception{
		
		pageBean.setCurrentPage(page);
		IOrderService orderservice = new OrderService();
		List<NewOrderBean> list = orderservice.listPayOrders(pageBean,subbranch_id);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("pageBean",pageBean);
		return SUCCESS;
	}
	
	/**
	 * 超级管理员更具不同分店查看的订单信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String listAllOrderbysubbranch() throws Exception{
	
		if(subbranchId == 11 || subbranchId ==null){
			return "all";
		}
		pageBean.setCurrentPage(page);
		IOrderService orderservice = new OrderService();
		List<NewOrderBean> list = orderservice.listAllOrder(pageBean,subbranchId);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("subbranchId", subbranchId);
//		Map session=(Map)ActionContext.getContext().getSession();
//		session.put("pageBean", pageBean);
		request.put("pageBean",pageBean);
		return SUCCESS;
	}
	/**
	 * 显示所有分店的订单
	 * @return
	 * @throws Exception
	 */
	public String ListAllOrder() throws Exception{
		if(subbranchId != null){
			pageBean.setCurrentPage(page);
			IOrderService orderservice = new OrderService();
			List<NewOrderBean> list = orderservice.ListAllOrder(pageBean);
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("pageBean",pageBean);
		}else{
			pageBean.setCurrentPage(page);
			IOrderService orderservice = new OrderService();
			List<NewOrderBean> list = orderservice.ListAllOrder(pageBean);
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("pageBean",pageBean);
		}
		
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
