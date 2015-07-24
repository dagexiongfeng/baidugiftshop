package baidu.giftshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baidu.giftshop.dao.SubbranchMapper;
import baidu.giftshop.model.Base;
import baidu.giftshop.model.Subbranch;
import baidu.giftshop.service.ISubbranchService;
import baidu.giftshop.util.A;

@Service("subbranchService")
public class SubbranchService implements ISubbranchService{
	
	@Autowired
	private SubbranchMapper subbranchDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Base getAllSubbranch() {
		List<Subbranch> list = subbranchDao.getAllSubbranch();
		A a = new A();
		a.setSubbranchs(list);
		Base base = new Base();
		base.setContent(a);
		base.setResult("OK");
		base.setCode(101);
		return base;
	}
}
