package baidu.giftshop.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import baidu.giftshop.bean.Base;
import baidu.giftshop.bean.PictureidBean;
import baidu.giftshop.dao.PicGroupDAO;
import baidu.giftshop.entity.GoodsDetailPicture;
import baidu.giftshop.frk.AddPicGroupDAO;
import baidu.giftshop.service.IPicGroupService;

public class PicGroupService implements IPicGroupService {

	AddPicGroupDAO addpicgroupdao = new AddPicGroupDAO();
	
	private String result;
	@Override
	public String upload(File pic, String picFileName, String groupId, String picGroupName) {
		return addpicgroupdao.upload(pic, picFileName, groupId,picGroupName);
	}
	
	@Override
	public Integer queryGroupId() {
		return addpicgroupdao.queryGroupId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String listGroupId() {
		 List<GoodsDetailPicture> list = addpicgroupdao.listGroupId();
		 List<PictureidBean> results=new ArrayList<PictureidBean>();
		 Map<String,String> idMap=new TreeMap<String, String>();
		 for(GoodsDetailPicture p:list){
			 String id=p.getGroupId();
			 String name=p.getPicGroupName();
			 if(idMap.containsKey(id)){
				 
			 }else{
				 idMap.put(id, name);
				 PictureidBean pd=new PictureidBean();
				 pd.setId(id);
				 pd.setPicGroupName(name);
				 results.add(pd);
			 }
		 }
		
		 @SuppressWarnings("rawtypes")
			Base base = new Base();
			base.setContent(results);
			
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{"goods"});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
			return result;
	}


	@Override
	public void deletegroup(String groupId) {
		PicGroupDAO picgroupdao = new PicGroupDAO();
		picgroupdao.deletegroup(groupId);
	}


	@SuppressWarnings({ "rawtypes" })
	@Override
	public List querythumbPathById(String groupId) {
		PicGroupDAO picgroupdao = new PicGroupDAO();
		return picgroupdao.querythumbPathById(groupId);
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String checkpicgroupId(String groupId) {
		Base base = new Base();
		if(addpicgroupdao.checkGoodsCode(groupId)>0){
			base.setContent(102);
		}else{
			base.setContent(101);
		}
		JsonConfig jsonConfig = new JsonConfig();
		JSONObject jsonObject = new JSONObject();
	    result = JSONObject.fromObject(base,jsonConfig).toString();
		return result;
	}

	public String checkpicId(String groupId) {
		Base base = new Base();
		if(addpicgroupdao.checkGoodsCode(groupId)==0){
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
