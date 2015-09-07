package baidu.giftshop.service.impl;

import java.util.List;

import baidu.giftshop.bean.NewOrderBean;
import baidu.giftshop.bean.OrderBean;
import baidu.giftshop.bean.PageBean;
import baidu.giftshop.dao.OrderDAO;
import baidu.giftshop.entity.UserOrder;
import baidu.giftshop.service.IOrderService;

public class OrderService implements IOrderService {

	@Override
	public List<NewOrderBean> listAllOrder(PageBean pageBean,Integer subbranch_id) {
		OrderDAO orderdao = new OrderDAO();
		List<NewOrderBean> list = orderdao.listAllOrder(subbranch_id);
		int totalSize = list.size();
		pageBean.setPerPage(10);
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = pageBean.getPerPage();
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;
		return orderdao.listAllOrder(firstResult,maxResult,subbranch_id);
	}
	
	

	@Override
	public void addlogistics(String userid, String orderid, String shipnum,
			String fedex) {
		
		OrderDAO orderdao = new OrderDAO();
		orderdao.addlogistics( orderid, shipnum, fedex,userid);
//		OrderDAO orderdao = new OrderDAO();
//		List<Object>  uo=	orderdao.findorder(orderid);
//		if(uo.size()>0){}
//		for (Object object : uo) {
//			System.out.println(object);
//		}
	}



	@Override
	public List<NewOrderBean> listPayOrders(PageBean pageBean,
			Integer subbranch_id) {
		OrderDAO orderdao = new OrderDAO();
		List<NewOrderBean> list = orderdao.listPayOrder(subbranch_id);
		int totalSize = list.size();
		pageBean.setPerPage(10);
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = pageBean.getPerPage();
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;
		return orderdao.listPayOrder(firstResult,maxResult,subbranch_id);
	}
}
