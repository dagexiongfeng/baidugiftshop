package baidu.giftshop.service;

import java.io.File;
import java.util.List;

public interface IPicGroupService {
	
	public String upload(File pic,String picFileName,String groupId ,String picGroupName);
	public Integer queryGroupId();
	public String listGroupId();
	public void deletegroup(String groupId);
	@SuppressWarnings("rawtypes")
	public List querythumbPathById(String groupId);
	public String checkpicgroupId(String groupId);
	public String checkpicId(String groupId);
}
