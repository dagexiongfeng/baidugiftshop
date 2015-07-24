package baidu.giftshop.service;

import baidu.giftshop.model.Base;
@SuppressWarnings("rawtypes")
public interface IAddressService {

	Base addAddress(Integer userid,String addressee,String phone,String address,String zipCode);
	
	Base queryAllAddress(Integer userid);
	
	Base deleteAddress(Integer addressid);
}
