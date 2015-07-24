package baidu.giftshop.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import baidu.giftshop.entity.Classify;
import baidu.giftshop.service.IBriefGoodsService;
import baidu.giftshop.service.IGoodsService;
import baidu.giftshop.service.impl.BriefGoodsService;
import baidu.giftshop.service.impl.GoodsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClassifyAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7867308243825371353L;
	IGoodsService goodsService = new GoodsService();
	public String code;
	public String name;
	public Integer id;
	public String classifyname;
	public String classifyId;
	public String subbranchId;
	public String result;
	/**
	 * 在addGoods.jsp中显示现在的code值
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String goods() throws Exception{
		Integer code = Integer.parseInt(goodsService.queryclassify()) + 1;
		@SuppressWarnings("rawtypes")
		Map session=(Map)ActionContext.getContext().getSession();
		session.put("code", code);
		return SUCCESS;
	}
	/**
	 * 增加分类
	 * @return
	 * @throws Exception
	 */
	public String addClassify() throws Exception{
		goodsService.addClassify(code, name);
			return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String listAllBrief() throws Exception{
		List<Classify> list = goodsService.listallBrief();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String Editclassify() throws Exception{
		Classify classify = goodsService.findById(id);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("classify", classify);
		return SUCCESS;
	}
	
	public String Modify() throws Exception{
		   if(goodsService.Modify(id, code,classifyname)){
			/*HttpServletResponse response = ServletActionContext.getResponse();
			response.sendRedirect("/BaiduGiftShop/listallBrief.action");*/
		     return SUCCESS;
		   }else{
			   return ERROR;
		   }
	}
	
	public String Delete() throws Exception{
		result =  goodsService.Delete(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		            out.print(result);
		            out.flush();
	    return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String ListClassify() throws Exception{
		IBriefGoodsService briefgoodsService = new BriefGoodsService();
		List<Classify> list = briefgoodsService.ListClassify();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	/**
	 * 分店绑定自己商店还未绑定的商品
	 * @throws Exception
	 */
	public String subClassify() throws Exception{

		classifyId = classifyId.replace(" ", "");
		String[] Id = classifyId.split(",");
		goodsService.deleteSubCla(Integer.parseInt(subbranchId));
	  if(classifyId!=null){
		 for(int i = 0 ;i < Id.length;i++){
			Integer cid = Integer.parseInt(Id[i]);
			goodsService.subBundlclassify(Integer.parseInt(subbranchId), cid);
		  }
		}else{
	  }
	  return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String checkboxclassify() throws Exception{
		result = goodsService.queryclassifyId(Integer.parseInt(subbranchId));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		            out.print(result);
		            out.flush();

		IBriefGoodsService briefgoodsService = new BriefGoodsService();
		List<Classify> list = briefgoodsService.ListClassify();
		int size = list.size();
		Map session = (Map) ActionContext.getContext().getSession();
		session.put("checkbox", size);
		return null;
	}
	
	public String querySubClas() throws Exception{
		result = goodsService.querySubClas(Integer.parseInt(subbranchId));
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		            out.print(result);
		            out.flush();
	    
	    return null;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassifyname() {
		return classifyname;
	}
	public void setClassifyname(String classifyname) {
		this.classifyname = classifyname;
	}
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getSubbranchId() {
		return subbranchId;
	}
	public void setSubbranchId(String subbranchId) {
		this.subbranchId = subbranchId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
