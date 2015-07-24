package baidu.giftshop.service.impl;

import java.util.List;

import baidu.giftshop.bean.OrderBean;
import baidu.giftshop.bean.PageBean;
import baidu.giftshop.dao.OrderDAO;
import baidu.giftshop.service.IOrderService;

public class OrderService implements IOrderService {

	@Override
	public List<OrderBean> listAllOrder(PageBean pageBean,Integer subbranch_id) {
		OrderDAO orderdao = new OrderDAO();
		List<OrderBean> list = orderdao.listAllOrder(subbranch_id);
		int totalSize = list.size();
		pageBean.setPerPage(8);
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = pageBean.getPerPage();
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;
		return orderdao.listAllOrder(firstResult,maxResult,subbranch_id);
	}

	@Override
	public void addlogistics(Integer userid, Integer orderid, String shipnum,
			String fedex) {
		OrderDAO orderdao = new OrderDAO();
		orderdao.addlogistics(userid, orderid, shipnum, fedex);
	}
}
