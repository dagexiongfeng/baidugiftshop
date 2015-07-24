package baidu.giftshop.service.impl;

import java.io.File;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import baidu.giftshop.bean.Base;
import baidu.giftshop.dao.PicGroupDAO;
import baidu.giftshop.frk.AddPicGroupDAO;
import baidu.giftshop.service.IPicGroupService;

public class PicGroupService implements IPicGroupService {

	AddPicGroupDAO addpicgroupdao = new AddPicGroupDAO();
	
	private String result;
	@Override
	public String upload(File pic, String picFileName, Integer groupId) {
		return addpicgroupdao.upload(pic, picFileName, groupId);
	}
	
	@Override
	public Integer queryGroupId() {
		return addpicgroupdao.queryGroupId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String listGroupId() {
		 List<Integer> list = addpicgroupdao.listGroupId();
		 @SuppressWarnings("rawtypes")
			Base base = new Base();
			base.setContent(list);
			
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.setIgnoreDefaultExcludes(false); 
			jsonConfig.setExcludes(new String[]{"goods"});
			@SuppressWarnings("unused")
			JSONObject jsonObject = new JSONObject();
			result = JSONObject.fromObject(base,jsonConfig).toString();
			return result;
	}


	@Override
	public void deletegroup(Integer groupId) {
		PicGroupDAO picgroupdao = new PicGroupDAO();
		picgroupdao.deletegroup(groupId);
	}


	@SuppressWarnings({ "rawtypes" })
	@Override
	public List querythumbPathById(Integer groupId) {
		PicGroupDAO picgroupdao = new PicGroupDAO();
		return picgroupdao.querythumbPathById(groupId);
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
