package baidu.giftshop.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import baidu.giftshop.bean.PageBean;
import baidu.giftshop.entity.GoodsPicture;
import baidu.giftshop.frk.UploadDAO;
import baidu.giftshop.service.impl.BriefGoodsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BriefGoodsAction extends ActionSupport{
	private String result;
	private String unit;
	private String name;
	private String classifyId;
    private File pic; 
    private String picFileName; 
    private Integer goods_id;
    private Integer goods_picture_id;
    private Integer Id;
    private String goodsId;
    private Integer subbranchId;
    private Integer page=1;
    private PageBean pageBean = new PageBean();
	/**
	 * 增加概要商品信息
	 */
	private static final long serialVersionUID = 1L;
	BriefGoodsService briefGoodsService = new BriefGoodsService();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addBriefGoods() throws Exception{
		UploadDAO uploaddao = new UploadDAO();
		Integer classify = Integer.parseInt(classifyId);
		
		
		if(briefGoodsService.savegoods(classify, unit, name)){
		int goodsid = briefGoodsService.findGoodsId(classify, unit, name);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("goodsid", goodsid);
		if(uploaddao.upload(pic,picFileName,goodsid).equals("success"))
		     return SUCCESS;
		 else
		     return ERROR;
		}else{
	         return ERROR;
		}
	}
    /**
     * 得到所有的概要商品列表
     * @return
     * @throws Exception
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String queryAllBrief() throws Exception{
		pageBean.setCurrentPage(page);
		List<GoodsPicture> list= briefGoodsService.queryAllBrief(pageBean);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("birefGoodsList", list);
		request.put("pageBean", pageBean);
		/*Map session=(Map)ActionContext.getContext().getSession();
		session.put("briefGoodsList", list);*/
		return SUCCESS;
	}
	/**
	 * 删除概要商品
	 * @return
	 * @throws Exception
	 */
	public String deleteBrief() throws Exception{
		result = briefGoodsService.DeleteBrief(goods_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		            out.print(result);
		            out.flush();
		return null;
	}
	
	public String querySubBrief() throws Exception{
		result = briefGoodsService.querySubBrief(subbranchId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		            out.print(result);
		            out.flush();
		return null;
	}
	/**
	 * 根据分类ID，得到概要商品信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ })
	public String querygoodsById() throws Exception{
		PageBean pageBean = new PageBean();
		//指定当前页面
		pageBean.setCurrentPage(page);
		
		result = briefGoodsService.querygoodsById(Id,pageBean);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	
	/**
	 * 根据分类的ID，分店的ID，得到概要商品的信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ })
	public String querySubgoods() throws Exception{
		result = briefGoodsService.querySubgoods(Id,subbranchId);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
    
	public String subBriefGoods() throws Exception{
		goodsId = goodsId.replace(" ", "");
		String[] Id = goodsId.split(",");
//		BriefGoodsDAO briefgoodsdao = new BriefGoodsDAO();
//		List<Object[]> list = briefgoodsdao.querygoodsById(Integer.parseInt(classifyId));
//		for(int i = 0 ; i < list.size() ; i ++){
//			Object[] obj = list.get(i);
//			Integer goodsId = (Integer) obj[2];
//			briefGoodsService.deleteBriefById(goodsId,subbranchId);
//		}
		if(goodsId!=null){
			for(int i =0 ; i < Id.length ; i++){
				Integer gId = Integer.parseInt(Id[i]);
				result = briefGoodsService.subBundlbrief(gId, subbranchId);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();   
				            out.print(result);  
				            out.flush();
			}
		}else{
		}
		return null;
	}
	public String deletesubBriefGoods() throws Exception{
		result = briefGoodsService.deletesubBriefGoods(Integer.parseInt(goodsId), subbranchId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getGoods_picture_id() {
		return goods_picture_id;
	}

	public void setGoods_picture_id(Integer goods_picture_id) {
		this.goods_picture_id = goods_picture_id;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getSubbranchId() {
		return subbranchId;
	}
	public void setSubbranchId(Integer subbranchId) {
		this.subbranchId = subbranchId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
