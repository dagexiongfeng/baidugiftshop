package baidu.giftshop.service;

import baidu.giftshop.model.Base;

@SuppressWarnings("rawtypes")
public interface IEvaluationService {
	
	
	Base addEvaluation(String user_id,Integer goods_id,String evaluation);

	Base queryEvalutaion(Integer goods_id,Integer startIndex,Integer requestAmount);
}
