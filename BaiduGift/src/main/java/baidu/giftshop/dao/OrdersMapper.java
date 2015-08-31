package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Orders;
import baidu.giftshop.util.OrderListB;
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
	List<Orders> checkByOrderid(String orderid);
	List<OrderListB> queryOrder(String userid,String Orderid);

	int updateOrderType(String state, String orderid);

	String queryState(String orderid);
}