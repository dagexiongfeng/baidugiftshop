package baidu.giftshop.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class baiduSdkupload {
	
	private String username;
	private File upload;
	private String uploadFileName ;
	private String uploadContentType ;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	
	
	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 处理文件上传请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public String uploadsdk() throws Exception {
		String filename = upload.getName();
		System.out.println("filename="+filename);
		
		System.out.println("uploadFileName="+uploadFileName);
		System.out.println("uploadContectType="+uploadContentType);
		
		FileInputStream fis = new FileInputStream(upload);
		FileOutputStream fos = new FileOutputStream("D://"+uploadFileName);
		
		int i = fis.read();
		while(i!=-1){
			fos.write(i);
			i = fis.read();
		}
		fis.close();
		fos.close();
		
		return "success";
	}

}
