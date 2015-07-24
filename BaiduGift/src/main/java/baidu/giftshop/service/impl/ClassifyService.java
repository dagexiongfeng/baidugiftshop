package baidu.giftshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baidu.giftshop.dao.ClassifyMapper;
import baidu.giftshop.model.Base;
import baidu.giftshop.model.Classify;
import baidu.giftshop.service.IClassifyService;
import baidu.giftshop.util.ClassifyBean;

@Service("classifyService")
public class ClassifyService implements IClassifyService{

	@Autowired
	private ClassifyMapper classifyDao;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Base getAllClassify(Integer subbranch_id) {
		Base base = new Base();
		ClassifyBean classifybean = new ClassifyBean();
		List<Classify> list = classifyDao.getAllClassify(subbranch_id);
		classifybean.setSubbranch_id(subbranch_id);
		classifybean.setClassifications(list);
		base.setContent(classifybean);
		base.setCode(101);
		base.setResult("OK");
		return base;
	}

}
