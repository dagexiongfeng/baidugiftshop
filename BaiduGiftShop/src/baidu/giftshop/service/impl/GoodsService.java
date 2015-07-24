package baidu.giftshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import baidu.giftshop.bean.Base;
import baidu.giftshop.bean.SubbranchA;
import baidu.giftshop.dao.GoodsDAO;
import baidu.giftshop.entity.Classify;
import baidu.giftshop.entity.Subbranch;
import baidu.giftshop.service.IGoodsService;

public class GoodsService implements IGoodsService {
	GoodsDAO goodsdao = new GoodsDAO();
	
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String querySubbranch() {
		
		List<Subbranch> list = goodsdao.querySubbranch();
		List<SubbranchA> prelist = new ArrayList<SubbranchA>();
		for(Subbranch subbranch : list){
			SubbranchA subbrancha = new SubbranchA();
			subbrancha.setId(subbranch.getId());
			subbrancha.setName(subbranch.getName());
	        prelist.add(subbrancha);
		}
		@SuppressWarnings("rawtypes")
		Base base = new Base();
		base.setContent(prelist);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{"goods"});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}


	@SuppressWarnings("unchecked")
	@Override
	public String AllClassify() {
		List<Classify> list = goodsdao.listallBrief();
		List<Classify> prelist = new ArrayList<Classify>();
		for(Classify classify : list){
			Classify classifya = new Classify();
			classifya.setId(classify.getId());
			classifya.setCode(classify.getCode());
			classifya.setName(classify.getName());
	        prelist.add(classifya);
		}
		@SuppressWarnings("rawtypes")
		Base base = new Base();
		base.setContent(prelist);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{"goodses","classifySubbranchs"});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}
	
	@Override
	public Integer querysubbranch(String subbranch) {
		Integer id = goodsdao.querysubbranch(subbranch);
		return id;
	}

	@Override
	public String queryclassify() {
		String code = goodsdao.queryclassify();
		return code;
	}

	@Override
	public void addClassify(String code, String name) {
		goodsdao.addClassify(code, name);
	}

	@Override
	public List<Classify> listallBrief() {
		List<Classify> list = goodsdao.listallBrief();
		return list;
	}

	@Override
	public Classify findById(Integer id) {
		return goodsdao.findById(id);
	}

	@Override
	public Boolean Modify(Integer id,String code, String name) {
		return goodsdao.Modify(id,code, name);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public String Delete(Integer id) {
		    Base base = new Base();
		try {
			goodsdao.Delete(id);
			base.setCode(101);
		} catch (Exception e) {
			e.printStackTrace();
			base.setCode(102);
		}
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{""});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}

	@Override
	public void subBundlclassify(Integer subbranchId, Integer classifyId) {
		goodsdao.subBundlclassify(subbranchId, classifyId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String queryclassifyId(Integer subbranchId) {
		List list = goodsdao.queryclassifyId(subbranchId);
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

	@Override
	public void deleteSubCla(Integer subbranchId) {
		goodsdao.deleteSubCla(subbranchId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String querySubClas(Integer subbranchId) {
		List<Classify> list = goodsdao.querySubClas(subbranchId);
		List<Classify> prelist = new ArrayList<Classify>();
		for(Classify classify : list){
			Classify classifya = new Classify();
			classifya.setId(classify.getId());
			classifya.setCode(classify.getCode());
			classifya.setName(classify.getName());
	        prelist.add(classifya);
		}
		Base base = new Base();
		base.setContent(prelist);
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false); 
		jsonConfig.setExcludes(new String[]{"goodses","classifySubbranchs"});
		@SuppressWarnings("unused")
		JSONObject jsonObject = new JSONObject();
		result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}

}
