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
    
    List<UserOrder> queryByOrderid(Integer orderid);
    List<Integer> queryOrderid(Integer userid);
}