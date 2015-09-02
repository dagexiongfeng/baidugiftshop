package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.UserOrder;

public interface UserOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);
    
    /**
     * 查询用户order表是否存在订单
     * @param orderid
     * @return
     */
    List<UserOrder> queryByOrderid(String orderid);
    
    
    List<String> queryOrderid(String userid);

	void insertPayTime(String pay_time, String orderid);
}