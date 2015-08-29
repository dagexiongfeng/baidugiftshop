package baidu.giftshop.service;

import java.io.File;
import java.util.List;

public interface IPicGroupService {
	
	public String upload(File pic,String picFileName,Integer groupId ,String picGroupName);
	public Integer queryGroupId();
	public String listGroupId();
	public void deletegroup(Integer groupId);
	@SuppressWarnings("rawtypes")
	public List querythumbPathById(Integer groupId);
}
