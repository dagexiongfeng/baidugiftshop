package baidu.giftshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import baidu.giftshop.dao.EvaluationMapper;
import baidu.giftshop.model.Base;
import baidu.giftshop.model.Evaluation;
import baidu.giftshop.service.IEvaluationService;
import baidu.giftshop.util.A;

@Service("evaluationService")
public class EvaluationService implements IEvaluationService {
	
	@Autowired
	private EvaluationMapper evaluationDao;

	@Transactional
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Base addEvaluation(String user_id, Integer goods_id,
			String evaluation) {
		List<Evaluation> list = evaluationDao.queryByUIdAndGId(user_id, goods_id);
		Base base = new Base();
		if(list.size()>0){
			base.setResult("Error");
			base.setCode(102);
		}else{
			 Evaluation eva = new Evaluation();
			 eva.setData(new Date());
			 eva.setUserId(user_id);
			 eva.setGoodsId(goods_id);
			 eva.setEvaluation(evaluation);
			 evaluationDao.insert(eva);
			 
			 base.setCode(101);
			 base.setResult("OK");
		}
		return base;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Base queryEvalutaion(Integer goods_id, Integer startIndex,
			Integer requestAmount) {
		
		List<Evaluation> list = evaluationDao.queryByGId(goods_id, startIndex, requestAmount);
		A a = new A();
	    Base base = new Base();
		if(list.size()>0){
			a.setSubbranchs(list);
			base.setContent(a);
		}else{
			base.setContent(a);
		}
		    base.setCode(101);
		    base.setResult("OK");
		return base;
	}

}
