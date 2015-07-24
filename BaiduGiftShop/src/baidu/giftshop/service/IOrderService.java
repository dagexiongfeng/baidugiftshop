package baidu.giftshop.service;

import java.util.List;

import baidu.giftshop.bean.OrderBean;
import baidu.giftshop.bean.PageBean;

public interface IOrderService {
	
	public List<OrderBean> listAllOrder(PageBean pageBean,Integer subbranch_id);
	
	public void addlogistics(Integer userid,Integer orderid,String shipnum,String fedex);

}
