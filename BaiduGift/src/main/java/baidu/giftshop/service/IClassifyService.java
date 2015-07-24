package baidu.giftshop.service;

import baidu.giftshop.model.Base;

public interface IClassifyService {
	
	@SuppressWarnings("rawtypes")
	Base getAllClassify(Integer subbranch_id);

}
