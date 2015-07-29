package baidu.giftshop.service;

import baidu.giftshop.model.Base;
@SuppressWarnings("rawtypes")
public interface IAddressService {

	/**
	 * 增加地址
	 * @param userid
	 * @param addressee
	 * @param phone
	 * @param address
	 * @param zipCode
	 * @return
	 */
	Base addAddress(String userid,String addressee,String phone,String address,String zipCode);
	/**
	 * 查询用户所有地址
	 * @param userid
	 * @return
	 */
	Base queryAllAddress(String userid);
	
	Base deleteAddress(Integer addressid);
	
	Base QueryAddressById(Integer addressid);
}
