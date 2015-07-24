package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    List<Address> queryAddressById(Integer userid);
    void updateAddressState(Integer id);
}