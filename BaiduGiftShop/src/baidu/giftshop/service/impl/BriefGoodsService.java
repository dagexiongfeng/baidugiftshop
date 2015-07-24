package baidu.giftshop.service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import baidu.giftshop.bean.Base;
import baidu.giftshop.bean.PageBean;
import baidu.giftshop.dao.BriefGoodsDAO;
import baidu.giftshop.dao.GoodsDAO;
import baidu.giftshop.entity.Classify;
import baidu.giftshop.entity.GoodsPicture;
import baidu.giftshop.service.IBriefGoodsService;

public class BriefGoodsService implements IBriefGoodsService {
	
	public BriefGoodsDAO briefGoodsDAO = new BriefGoodsDAO();
	
	public String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public Boolean savegoods(Integer classifyId, String unit, String name) {
		  String unit_cp = unit.replace(" ", "");
		  String name_cp = name.replace(" ", "");
          return briefGoodsDAO.savegoods(classifyId, unit_cp, name_cp);
	}

	@Override
	public Integer findGoodsId(Integer classifyId, String unit, String name) {
		return briefGoodsDAO.findGoodsId(classifyId, unit, name);
	}

	@Override
	public List<GoodsPicture> queryAllBrief(PageBean pageBean){
		List<GoodsPicture> list = briefGoodsDAO.queryAllBrief();
		int totalSize = list.size();
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = pageBean.getPerPage();//ÿҳ�̶�����������
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;//�����ݿ��п�ʼȡ������
		return briefGoodsDAO.queryAllBrief(firstResult,maxResult);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String DeleteBrief(Integer goods_id){
		 Base base = new Base();
		 if(briefGoodsDAO.deleteBrief(goods_id)){
			 base.setContent(101);
		 }else{
			 base.setContent(102);
		 }
		    JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{""});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
			return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String querygoodsById(Integer Id,PageBean pageBean){
		
		List<Object[]> list = briefGoodsDAO.querygoodsById(Id);
		int totalSize = list.size();
		
		pageBean = pageBean.init(pageBean, totalSize);
		int maxResult = pageBean.getPerPage();//ÿҳ�̶�����������
		int firstResult = (pageBean.getCurrentPage()-1)*maxResult;//�����ݿ��п�ʼȡ������
		List<Object[]> prelist = briefGoodsDAO.querygoodsById(Id,firstResult,maxResult);
		Base base = new Base();
		base.setContent(prelist);
		base.setList(pageBean);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{"goods"});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}

	@Override
	public List<Classify> ListClassify(){
		GoodsDAO goodsdao = new GoodsDAO();
		return goodsdao.listallBrief();
	}

	@Override
	public void deleteBriefById(Integer goodsId,Integer subbranchId){
		briefGoodsDAO.deleteBriefById(goodsId,subbranchId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String subBundlbrief(Integer goodsId, Integer subbranchId){
		Base base = new Base();
		if(briefGoodsDAO.subBundlbrief(goodsId, subbranchId)){
		    base.setContent(101);
		}else{
			base.setContent(102);
		}
		    JsonConfig jsonConfig = new JsonConfig();  
		    jsonConfig.setIgnoreDefaultExcludes(false); 
		    jsonConfig.setExcludes(new String[]{""});
		    @SuppressWarnings("unused")
		    JSONObject jsonObject = new JSONObject();
		    result = JSONObject.fromObject(base,jsonConfig).toString();
		 
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String querySubBrief(Integer subbranchId) {
		List list = briefGoodsDAO.querySubBrief(subbranchId);
		Base base = new Base();
		base.setContent(list);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{""});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String deletesubBriefGoods(Integer goodsId, Integer subbranchId) {
		briefGoodsDAO.deletesubBriefGoods(goodsId, subbranchId);
		Base base = new Base();
		base.setContent(101);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{""});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String querySubgoods(Integer Id, Integer subbranchId) {
		List list = briefGoodsDAO.querySubgoods(Id, subbranchId);
		Base base = new Base();
		base.setContent(list);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{""});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}
}
