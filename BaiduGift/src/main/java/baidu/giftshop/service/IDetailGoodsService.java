package baidu.giftshop.service;

import baidu.giftshop.model.Base;

public interface IDetailGoodsService {
	
	@SuppressWarnings("rawtypes")
	Base getDetailGoods(Integer subbranch_id,Integer classify_id,Integer goods_id);

	@SuppressWarnings("rawtypes")
	Base queryAmount(Integer goods_detail_id,Integer subbranch_id);
}
