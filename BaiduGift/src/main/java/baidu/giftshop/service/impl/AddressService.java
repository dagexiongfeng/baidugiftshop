package baidu.giftshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import baidu.giftshop.dao.AddressMapper;
import baidu.giftshop.model.Address;
import baidu.giftshop.model.Base;
import baidu.giftshop.service.IAddressService;
import baidu.giftshop.util.A;
@Service("addressService")
public class AddressService implements IAddressService {
	
	@Autowired
	private AddressMapper addressDao;

	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Base addAddress(Integer userid, String addressee, String phone,
			String address, String zipCode) {
		Address add = new Address();
		Base base = new Base();
		add.setUserid(userid);
		add.setAddressee(addressee);
		add.setPhone(phone);
		add.setAddress(address);
		add.setZipCode(zipCode);
		addressDao.insert(add);
		base.setContent("Ok");
		base.setCode(101);
		base.setResult("OK");
		return base;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Base queryAllAddress(Integer userid) {
		List<Address> list = addressDao.queryAddressById(userid);
		A a = new A();
		Base base = new Base();
		a.setSubbranchs(list);
		base.setContent(a);
		base.setCode(101);
		base.setResult("OK");
		return base;
	}

	@Transactional
	@SuppressWarnings("rawtypes")
	@Override
	public Base deleteAddress(Integer addressid){
		
	    addressDao.updateAddressState(addressid);
		Base base = new Base();
		base.setCode(101);
		base.setResult("OK");
		return base;
	}
}
