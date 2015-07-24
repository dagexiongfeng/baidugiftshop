package baidu.giftshop.service;

import baidu.giftshop.model.Base;

public interface IBriefGoodsService {
	
	@SuppressWarnings("rawtypes")
	Base getBriefGoods(Integer subbranch_id,Integer classify_id,Integer startIndex,Integer requestAmount);

	@SuppressWarnings("rawtypes")
	Base getBriefGoods(Integer subbranch_id,Integer startIndex,Integer requestAmount);

	@SuppressWarnings("rawtypes")
	Base queryBriefGoods(Integer subbranch_id,Integer startIndex,
			Integer requestAmount,String name);
	
	@SuppressWarnings("rawtypes")
	Base queryBriefGoods(Integer subbranch_id,Integer classify_id,Integer startIndex,
			Integer requestAmount,String name);
}
