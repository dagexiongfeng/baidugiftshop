package baidu.giftshop.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import baidu.giftshop.dao.PicGroupDAO;
import baidu.giftshop.service.impl.PicGroupService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PictureGroupAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9045276007746183128L;
	PicGroupService picgroupservice = new PicGroupService();
	PicGroupDAO picgroupdao = new PicGroupDAO();
	private List<File> myFile = new ArrayList<File>();//�ļ�
	private List<String> myFileFileName = new ArrayList<String>();;//�ļ���ʵ����
	private String result;
	private Integer groupId;
	private String picGroupName;
	
	
	public String getPicGroupName() {
		return picGroupName;
	}

	public void setPicGroupName(String picGroupName) {
		this.picGroupName = picGroupName;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String AddPicGroup() throws Exception{
		int i = 0 ;
		int j = 0;
		for (File file:myFile){
			String fileName =this.myFileFileName.get(i++);
			String s = picgroupservice.upload(file, fileName, groupId,picGroupName);
			if(s.equals("success")){
				j=j+1;
			}
		}
		if(myFile.size()==j){
			return SUCCESS;
		}else{
			picgroupdao.deletegroup(groupId);
			return ERROR;
		}
	}
	
	public String listgroupId() throws IOException{
		result = picgroupservice.listGroupId();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	
	/**
	 * 跳转到增加图片组页
	 * @return
	 */
	public String addPic(){
		 groupId= picgroupservice.queryGroupId();
		 if(groupId==null){
			 groupId=1;
		 }else{
		groupId=groupId+1; 
		 }
		return SUCCESS;
	}
	/**
	 * 删除某一图片
	 * @throws Exception
	 */
	public String deletegroup() throws Exception{
		picgroupservice.deletegroup(groupId);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String querythumbPathById() throws Exception{
		List list = picgroupservice.querythumbPathById(groupId);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("thumbPath", list);
		return SUCCESS;
	}
	public List<File> getMyFile() {
		return myFile;
	}
	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}
	
	public List<String> getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(List<String> myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}
