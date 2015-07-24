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
    
	List<Orders> checkByOrderid(Integer orderid);
	List<OrderListB> queryOrder(Integer userid,Integer Orderid);
}