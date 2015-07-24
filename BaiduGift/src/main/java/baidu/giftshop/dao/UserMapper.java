package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByUname(String username);    
    int selectByUid(Integer user_id);
}