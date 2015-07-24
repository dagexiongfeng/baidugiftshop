package baidu.giftshop.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import baidu.giftshop.service.IGoodsService;
import baidu.giftshop.service.impl.GoodsService;

import com.opensymphony.xwork2.ActionSupport;

public class SubbranchAction extends ActionSupport{
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 7217016703804498720L;
	/**
	 * 查询数据库中的所有分店信息
	 * 并通过ajax在register和login页面显示
	 * @return
	 * @throws Exception
	 */
	public String querySubbranch() throws Exception{
		IGoodsService goodsService = new GoodsService();
		result = goodsService.querySubbranch();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		        //��ȡ�������Ȼ��ʹ��  
		PrintWriter out = response.getWriter();   
		            //����ı���Ϣ  
		            out.print(result);  
		            out.flush();
		return null;
	}
	/**
	 * 得到所有的分类信息
	 * @return
	 * @throws Exception
	 */
	public String allClassify() throws Exception{
		IGoodsService goodsService = new GoodsService();
		result = goodsService.AllClassify();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		        //��ȡ�������Ȼ��ʹ��  
		PrintWriter out = response.getWriter();   
		            //����ı���Ϣ  
		            out.print(result);  
		            out.flush();
		return null;
	}
}
