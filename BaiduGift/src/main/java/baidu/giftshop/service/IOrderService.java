package baidu.giftshop.service;

import baidu.giftshop.model.Base;
@SuppressWarnings("rawtypes")
public interface IOrderService {
	
	
	Base addOrder(String user_id,String subbranch_id,String goods_detail_id,String num,String state,Integer addressid,String totalMoney);

	Base queryOrder(String user_id,Integer startIndex,Integer requestAmount);

	Base cancelOrder(String orderid);

	Base queryState(String orderid);
	
	void changeOrderStatus(String order_no, String pay_time);

	String queryStatus(String order_no);
}
