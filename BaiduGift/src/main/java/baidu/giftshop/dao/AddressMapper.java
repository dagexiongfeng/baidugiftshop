package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Address;

public interface AddressMapper {
	
	
    int deleteByPrimaryKey(Integer id);

    /*
     * 增加地址
     */
    int insert(Address record);

  //  int insertSelective(Address record);

  //  Address selectByPrimaryKey(Integer id);

  //  int updateByPrimaryKeySelective(Address record);

  //  int updateByPrimaryKey(Address record);
    
    /**
     * 查询用户所有地址
     * @param userid
     * @return
     */
    List<Address> queryAddressById(String userid);
    
    void updateAddressState(Integer id);

	Address QueryAddressById(Integer addressid);
}