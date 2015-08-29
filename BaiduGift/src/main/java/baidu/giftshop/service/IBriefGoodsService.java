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

	/**
	 * 热门商品接口
	 * @param subbranch_id
	 * @param startIndex
	 * @param requestAmount
	 * @return
	 */
	Base getHotGoods(Integer subbranch_id, Integer startIndex,
			Integer requestAmount);

	/**
	 * 新品商品接口
	 * @param subbranch_id
	 * @param startIndex
	 * @param requestAmount
	 * @return
	 */
	Base getNewGoods(Integer subbranch_id, Integer startIndex,
			Integer requestAmount);
}
