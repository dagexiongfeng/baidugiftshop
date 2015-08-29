package baidu.giftshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baidu.giftshop.dao.GoodsMapper;
import baidu.giftshop.dao.GoodsPictureMapper;
import baidu.giftshop.model.Base;
import baidu.giftshop.model.Goods;
import baidu.giftshop.model.GoodsPicture;
import baidu.giftshop.service.IBriefGoodsService;
import baidu.giftshop.util.BriefGoodsBean;
import baidu.giftshop.util.BriefGoodsBeanA;

@SuppressWarnings("rawtypes")
@Service("briefGoodsService")
public class BriefGoodsService implements IBriefGoodsService {
	
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private GoodsPictureMapper goodspictureDao;

	@SuppressWarnings("unchecked")
	@Override
	public Base getBriefGoods(Integer subbranch_id, Integer classify_id,
			Integer startIndex, Integer requestAmount) {
		List<Goods> list = goodsDao.selectByClassifyid(subbranch_id, classify_id,startIndex,requestAmount);
		List<BriefGoodsBean> prelist = new ArrayList<BriefGoodsBean>();
		for(int i = 0 ; i < list.size() ; i++){
			Goods goods = list.get(i);
			BriefGoodsBean briefgoodsbean = new BriefGoodsBean();
			briefgoodsbean.setClassify_id(goods.getClassifyId());
			briefgoodsbean.setId(goods.getId());
			briefgoodsbean.setUnit(goods.getUnit());
			briefgoodsbean.setName(goods.getName());
			
			List<GoodsPicture> piclist = goodspictureDao.selectByGoodsId(goods.getId());
			briefgoodsbean.setPictures(piclist);
			prelist.add(briefgoodsbean);
		}
		  BriefGoodsBeanA briefgoodsbeana = new BriefGoodsBeanA();
		    briefgoodsbeana.setGoodes(prelist);
		    briefgoodsbeana.setSubbranch_id(subbranch_id);
		    briefgoodsbeana.setRequestAmount(requestAmount);
		    briefgoodsbeana.setStartIndex(startIndex);
		  Base base = new Base();
		  base.setContent(briefgoodsbeana);
		  base.setResult("OK");
		  base.setCode(101);
		return base;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Base getBriefGoods(Integer subbranch_id, Integer startIndex,
			Integer requestAmount) {
		List<Goods> list = goodsDao.selectAllGoods(subbranch_id, startIndex, requestAmount);
		List<BriefGoodsBean> prelist = new ArrayList<BriefGoodsBean>();
		for(int i = 0 ; i < list.size() ; i++){
			Goods goods = list.get(i);
			BriefGoodsBean briefgoodsbean = new BriefGoodsBean();
			briefgoodsbean.setClassify_id(goods.getClassifyId());
			briefgoodsbean.setId(goods.getId());
			briefgoodsbean.setUnit(goods.getUnit());
			briefgoodsbean.setName(goods.getName());
			
			List<GoodsPicture> piclist = goodspictureDao.selectByGoodsId(goods.getId());
			briefgoodsbean.setPictures(piclist);
			prelist.add(briefgoodsbean);
		}
		  BriefGoodsBeanA briefgoodsbeana = new BriefGoodsBeanA();
		    briefgoodsbeana.setGoodes(prelist);
		    briefgoodsbeana.setSubbranch_id(subbranch_id);
		    briefgoodsbeana.setRequestAmount(requestAmount);
		    briefgoodsbeana.setStartIndex(startIndex);
		  Base base = new Base();
		  base.setContent(briefgoodsbeana);
		  base.setResult("OK");
		  base.setCode(101);
		return base;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Base queryBriefGoods(Integer subbranch_id, Integer startIndex,
			Integer requestAmount,String name) {
		if(name==null){
			name = "%%";
		}else{
			name = "%"+name+"%";
		}
		List<Goods> list = goodsDao.queryAllGoods(subbranch_id, startIndex,requestAmount, name);
		List<BriefGoodsBean> prelist = new ArrayList<BriefGoodsBean>();
		for(int i = 0 ; i < list.size() ; i++){
			Goods goods = list.get(i);
			BriefGoodsBean briefgoodsbean = new BriefGoodsBean();
			briefgoodsbean.setClassify_id(goods.getClassifyId());
			briefgoodsbean.setId(goods.getId());
			briefgoodsbean.setUnit(goods.getUnit());
			briefgoodsbean.setName(goods.getName());
			
			List<GoodsPicture> piclist = goodspictureDao.selectByGoodsId(goods.getId());
			briefgoodsbean.setPictures(piclist);
			prelist.add(briefgoodsbean);
		}
		  BriefGoodsBeanA briefgoodsbeana = new BriefGoodsBeanA();
		    briefgoodsbeana.setGoodes(prelist);
		    briefgoodsbeana.setSubbranch_id(subbranch_id);
		    briefgoodsbeana.setRequestAmount(requestAmount);
		    briefgoodsbeana.setStartIndex(startIndex);
		  Base base = new Base();
		  base.setContent(briefgoodsbeana);
		  base.setResult("OK");
		  base.setCode(101);
		return base;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Base queryBriefGoods(Integer subbranch_id, Integer classify_id,
			Integer startIndex,Integer requestAmount, String name) {
		if(name==null){
			name = "%%";
		}else{
			name = "%"+name+"%";
		}
		List<Goods> list = goodsDao.queryByClassifyId(subbranch_id, classify_id, startIndex, requestAmount, name);
		List<BriefGoodsBean> prelist = new ArrayList<BriefGoodsBean>();
		for(int i = 0 ; i < list.size() ; i++){
			Goods goods = list.get(i);
			BriefGoodsBean briefgoodsbean = new BriefGoodsBean();
			briefgoodsbean.setClassify_id(goods.getClassifyId());
			briefgoodsbean.setId(goods.getId());
			briefgoodsbean.setUnit(goods.getUnit());
			briefgoodsbean.setName(goods.getName());
			
			List<GoodsPicture> piclist = goodspictureDao.selectByGoodsId(goods.getId());
			briefgoodsbean.setPictures(piclist);
			prelist.add(briefgoodsbean);
		}
		  BriefGoodsBeanA briefgoodsbeana = new BriefGoodsBeanA();
		    briefgoodsbeana.setGoodes(prelist);
		    briefgoodsbeana.setSubbranch_id(subbranch_id);
		    briefgoodsbeana.setRequestAmount(requestAmount);
		    briefgoodsbeana.setStartIndex(startIndex);
		  Base base = new Base();
		  base.setContent(briefgoodsbeana);
		  base.setResult("OK");
		  base.setCode(101);
		return base;
	}
/*
 *热门商品查询 
 */
	@Override
	public Base getHotGoods(Integer subbranch_id, Integer startIndex,Integer requestAmount) {
		List<Goods> list = goodsDao.selectHotGoods(subbranch_id, startIndex, requestAmount);
		List<BriefGoodsBean> prelist = new ArrayList<BriefGoodsBean>();
		for(int i = 0 ; i < list.size() ; i++){
			Goods goods = list.get(i);
			BriefGoodsBean briefgoodsbean = new BriefGoodsBean();
			briefgoodsbean.setClassify_id(goods.getClassifyId());
			briefgoodsbean.setId(goods.getId());
			briefgoodsbean.setUnit(goods.getUnit());
			briefgoodsbean.setName(goods.getName());
			briefgoodsbean.setProductType(goods.getProductType());
			
			List<GoodsPicture> piclist = goodspictureDao.selectByGoodsId(goods.getId());
			briefgoodsbean.setPictures(piclist);
			prelist.add(briefgoodsbean);
		}
		  BriefGoodsBeanA briefgoodsbeana = new BriefGoodsBeanA();
		    briefgoodsbeana.setGoodes(prelist);
		    briefgoodsbeana.setSubbranch_id(subbranch_id);
		    briefgoodsbeana.setRequestAmount(requestAmount);
		    briefgoodsbeana.setStartIndex(startIndex);
		  Base base = new Base();
		  base.setContent(briefgoodsbeana);
		  base.setResult("OK");
		  base.setCode(101);
		return base;
	}

	@Override
	public Base getNewGoods(Integer subbranch_id, Integer startIndex,Integer requestAmount) {
		List<Goods> list = goodsDao.selectNewGoods(subbranch_id, startIndex, requestAmount);
		List<BriefGoodsBean> prelist = new ArrayList<BriefGoodsBean>();
		for(int i = 0 ; i < list.size() ; i++){
			Goods goods = list.get(i);
			BriefGoodsBean briefgoodsbean = new BriefGoodsBean();
			briefgoodsbean.setClassify_id(goods.getClassifyId());
			briefgoodsbean.setId(goods.getId());
			briefgoodsbean.setUnit(goods.getUnit());
			briefgoodsbean.setName(goods.getName());
			briefgoodsbean.setProductType(goods.getProductType());
			
			List<GoodsPicture> piclist = goodspictureDao.selectByGoodsId(goods.getId());
			briefgoodsbean.setPictures(piclist);
			prelist.add(briefgoodsbean);
		}
		  BriefGoodsBeanA briefgoodsbeana = new BriefGoodsBeanA();
		    briefgoodsbeana.setGoodes(prelist);
		    briefgoodsbeana.setSubbranch_id(subbranch_id);
		    briefgoodsbeana.setRequestAmount(requestAmount);
		    briefgoodsbeana.setStartIndex(startIndex);
		  Base base = new Base();
		  base.setContent(briefgoodsbeana);
		  base.setResult("OK");
		  base.setCode(101);
		return base;
	}
}
