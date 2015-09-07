package baidu.giftshop.service;

import java.util.List;

import baidu.giftshop.bean.NewOrderBean;
import baidu.giftshop.bean.PageBean;

public interface IOrderService {
	
	public List<NewOrderBean> listAllOrder(PageBean pageBean,Integer subbranch_id);
	
	public void addlogistics(String userid,String orderid,String shipnum,String fedex);

	public List<NewOrderBean> listPayOrders(PageBean pageBean,
			Integer subbranch_id);

}
