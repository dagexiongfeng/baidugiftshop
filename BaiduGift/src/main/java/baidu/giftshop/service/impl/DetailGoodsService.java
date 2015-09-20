package baidu.giftshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baidu.giftshop.dao.GoodsDetailMapper;
import baidu.giftshop.dao.GoodsDetailPictureMapper;
import baidu.giftshop.dao.GoodsDetailSubbranchMapper;
import baidu.giftshop.model.Base;
import baidu.giftshop.model.GoodsDetailPicture;
import baidu.giftshop.service.IDetailGoodsService;
import baidu.giftshop.util.GoodsDetailA;
import baidu.giftshop.util.GoodsDetailB;
import baidu.giftshop.util.GoodsDetailC;

@Service("detailGoodsService")
public class DetailGoodsService implements IDetailGoodsService{
	
	@Autowired
	private GoodsDetailMapper goodsdetailDao;
	@Autowired
	private GoodsDetailPictureMapper goodsdetailpictureDao;
	@Autowired
	private GoodsDetailSubbranchMapper goodsdetailsubbranchDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Base getDetailGoods(Integer subbranch_id, Integer classify_id,
			Integer goods_id) {
		Integer picId = goodsdetailDao.selectGroupId(goods_id);
		
		
		System.out.println("ssss");
		List Type1 = goodsdetailDao.Type1(goods_id);
		List Type2 = goodsdetailDao.Type2(goods_id);
		List Type3 = goodsdetailDao.Type3(goods_id);
		List Type4 = goodsdetailDao.Type4(goods_id);
		List<GoodsDetailPicture> list = goodsdetailpictureDao.getPicGroup(picId);
		GoodsDetailA goodsdetaila = new GoodsDetailA();
		goodsdetaila.setId(picId);
		goodsdetaila.setPictures(list);
		List<GoodsDetailA> lista = new ArrayList<GoodsDetailA>();
		lista.add(goodsdetaila);
		List<GoodsDetailB> listb = goodsdetailDao.selectBySubIdAndGoodsId(subbranch_id, goods_id);
		GoodsDetailC goodsdetailc = new GoodsDetailC();
		goodsdetailc.setClassify_id(classify_id);
		goodsdetailc.setDetailGoods(listb);
		goodsdetailc.setGoods_id(goods_id);
		goodsdetailc.setGroupPictures(lista);
		goodsdetailc.setSubbranch_id(subbranch_id);
		goodsdetailc.setType1(Type1);
		goodsdetailc.setType2(Type2);
		goodsdetailc.setType3(Type3);
		goodsdetailc.setType4(Type4);
	
		Base base = new Base();
		base.setContent(goodsdetailc);
		base.setCode(101);
		base.setResult("OK");
		return base;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public Base queryAmount(Integer goods_detail_id, Integer subbranch_id) {
		Integer amount = goodsdetailsubbranchDao.queryAmount(goods_detail_id, subbranch_id);
		Base base = new Base();
		if(amount!=null){
		    base.setContent(amount);
		    base.setResult("OK");
		    base.setCode(101);
		}else{
			base.setContent(amount);
			base.setResult("Error");
			base.setCode(102);
		}
		return base;
	}
}
