package baidu.giftshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import baidu.giftshop.bean.Base;
import baidu.giftshop.bean.PageBean;
import baidu.giftshop.dao.DetailGoodsDAO;
import baidu.giftshop.entity.Goods;
import baidu.giftshop.entity.GoodsDetai;
import baidu.giftshop.service.IDetailGoodsService;
import baidu.giftshop.util.HibernateSessionFactory;

public class DetailGoodsService implements IDetailGoodsService {
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	DetailGoodsDAO detailgoodsdao = new DetailGoodsDAO();
	@Override
	public void saveDetailGoods(GoodsDetai goodsDetai) {
		detailgoodsdao.addDetailGoods(goodsDetai);
	}
	@Override
	public Goods queryGoods(String classifyId, String goodsId) {
		return detailgoodsdao.queryGoods(classifyId, goodsId);
	}
	@Override
	public GoodsDetai queryDetaiGoods(String barCode, Integer goodsDetailId) {
		return detailgoodsdao.queryDetaiGoods(barCode, goodsDetailId);
	}
	@Override
	public GoodsDetai queryDetaiGoods(String barCode) {
		return detailgoodsdao.queryDetaiGoods(barCode);
	}
	@Override
	public List<GoodsDetai> listallDetailGoods(PageBean pageBean) {
		List<GoodsDetai> list = detailgoodsdao.listallDetailGoods();
		int totalSize = list.size();
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = 5;
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;
		return detailgoodsdao.listallDetailGoods(firstResult,maxResult);
	}
	@SuppressWarnings({ "rawtypes" })
	@Override
	public String deleteDetail(Integer goodsDetailId) {
		
		Base base = detailgoodsdao.deleteDetail(goodsDetailId);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{"classifySubbranchs","goods"});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String listDetailByGid(Integer goodsId,Integer subbranch_id,PageBean pageBean) {
		List<GoodsDetai> glist = detailgoodsdao.listDetailByGid(goodsId);
		int totalSize = glist.size();
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = 5;
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;
		List<GoodsDetai> list = detailgoodsdao.listDetailByGid(goodsId,firstResult,maxResult);
		List<GoodsDetai> prelist = new ArrayList<GoodsDetai>();
		for(GoodsDetai goodsdetai : list){
			GoodsDetai goodsdetail = new GoodsDetai();
			Integer amount = this.queryAmount(goodsdetai.getId(), subbranch_id);
	      if(amount!=null){
	      }else{
	    	 amount = 0;
	      }
			goodsdetail.setId(goodsdetai.getId());
			goodsdetail.setName(goodsdetai.getName());
			goodsdetail.setGoodsCode(goodsdetai.getGoodsCode());
			goodsdetail.setShopCode(goodsdetai.getShopCode());
			goodsdetail.setBarCode(goodsdetai.getBarCode());
			goodsdetail.setType1(goodsdetai.getType1());
			goodsdetail.setType2(goodsdetai.getType2());
			goodsdetail.setType3(goodsdetai.getType3());
			goodsdetail.setType4(goodsdetai.getType4());
			goodsdetail.setStockPrice(goodsdetai.getStockPrice());
			goodsdetail.setBaiduPrice(goodsdetai.getBaiduPrice());
			goodsdetail.setRetailPrice(goodsdetai.getRetailPrice());
			goodsdetail.setCostPrice(goodsdetail.getCostPrice());
			goodsdetail.setPicGroupId(amount);
			prelist.add(goodsdetail);
		}
		Base base = new Base();
		base.setContent(prelist);
		base.setList(pageBean);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{"classifySubbranchs","goods"});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}
	
	public Integer queryAmount(Integer goods_detail_id,Integer subbranch_id){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gds.amount from GoodsDetailSubbranch gds where gds.subbranch.id=? and gds.goodsDetai.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, subbranch_id);
		q.setParameter(1, goods_detail_id);
		//System.out.println(subbranch_id+"-----"+goods_detail_id);
		if(q.list().size()>0){
		Integer amount = (Integer) q.list().get(0);
		tr.commit();
		session.close();
	        return amount;
		}else{
			return null;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String subDetailGoods(Integer goods_detail_id, Integer subbranch_id,
			Integer amount) {
		if(detailgoodsdao.subDetailGoods(goods_detail_id, subbranch_id, amount)){
			Base base = new Base();
			base.setContent(101);
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{"classifySubbranchs","goods"});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
		}else{
			Base base = new Base();
			base.setContent(102);
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{"classifySubbranchs","goods"});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
		}
		return result;
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public String querySubDetail(Integer subbranchId) {
		List list = detailgoodsdao.querySubDetail(subbranchId);
		Base base = new Base();
		base.setContent(list);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(new String[]{""});
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public String deleteSubDetGoods(Integer goods_detail_id, Integer subbranch_id) {
           detailgoodsdao.deleteSubDetGoods(goods_detail_id, subbranch_id);
           Base base = new Base();
           base.setContent(101);
           JsonConfig jsonConfig = new JsonConfig();
   		   jsonConfig.setIgnoreDefaultExcludes(false);
   		   jsonConfig.setExcludes(new String[]{""});
   		   JSONObject jsonObject = new JSONObject();
   		   result = JSONObject.fromObject(base,jsonConfig).toString();
   		   return result;
	}
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	public String checkGoodsCode(String goodsCode) {
		Base base = new Base();
		if(detailgoodsdao.checkGoodsCode(goodsCode)>0){
			base.setContent(102);
		}else{
			base.setContent(101);
		}
		JsonConfig jsonConfig = new JsonConfig();
		JSONObject jsonObject = new JSONObject();
	    result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}
}
