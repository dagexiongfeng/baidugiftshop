package baidu.giftshop.service;

import baidu.giftshop.model.Base;
@SuppressWarnings("rawtypes")
public interface IOrderService {
	
	
	Base addOrder(Integer user_id,String subbranch_id,String goods_detail_id,String num,String state,Integer addressid);

	Base queryOrder(Integer user_id,Integer startIndex,Integer requestAmount);
}
