package baidu.giftshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import baidu.giftshop.bean.PageBean;
import baidu.giftshop.entity.Goods;
import baidu.giftshop.entity.GoodsDetai;
import baidu.giftshop.service.IDetailGoodsService;
import baidu.giftshop.service.impl.DetailGoodsService;

public class DetailGoodsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IDetailGoodsService detailgoodsService = new DetailGoodsService(); 
	private String result;
	private String classifyId;
	private String goodsId;
	private Integer goodsDetailId;
	private String barCode;
	private Integer goods_detail_id;
	private Integer subbranchId;
	private String goodsDetId;
	private String amount;
	private Integer page=1;
    private PageBean pageBean = new PageBean();
    private String goodsCode;
	//private String picGroupId;
	
	private GoodsDetai goodsDetai;
	
	public String addDeatilGoods() throws Exception{
		Goods goods = detailgoodsService.queryGoods(classifyId, goodsId);
		goodsDetai.setGoods(goods);
		goodsDetai.setState(1);
	    detailgoodsService.saveDetailGoods(goodsDetai);
		return SUCCESS;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String queryDetailGoods() throws Exception{
		if(goodsDetailId!=null){
			GoodsDetai goodsdetai = detailgoodsService.queryDetaiGoods(barCode, goodsDetailId);
			Map session=(Map)ActionContext.getContext().getSession();
			session.put("goodsdetai", goodsdetai);
		}else{
			GoodsDetai goodsdetai = detailgoodsService.queryDetaiGoods(barCode);
			Map session=(Map)ActionContext.getContext().getSession();
			session.put("goodsdetai", goodsdetai);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String listallDetailGoods() throws Exception{
		pageBean.setCurrentPage(page);
		List<GoodsDetai> list = detailgoodsService.listallDetailGoods(pageBean);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("pageBean", pageBean);
		return SUCCESS;
	}
	//下架明细商品
	public String deleteDetail() throws Exception{
		result = detailgoodsService.deleteDetail(goods_detail_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String ModifyDetailGoods() throws Exception{
		if(goodsDetailId!=null){
			GoodsDetai goodsdetai = detailgoodsService.queryDetaiGoods(barCode, goodsDetailId);
			if(goodsdetai!=null){
			    Map session=(Map)ActionContext.getContext().getSession();
			    session.put("goodsdetai", goodsdetai);
			    return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			GoodsDetai goodsdetai = detailgoodsService.queryDetaiGoods(barCode);
			if(goodsdetai!=null){
			      Map session=(Map)ActionContext.getContext().getSession();
			      session.put("goodsdetai", goodsdetai);
			      return SUCCESS;
			}else{
				return ERROR;
			}
		}
	}
	
	public String listDetailByGid() throws Exception{
		pageBean.setCurrentPage(page);
		result = detailgoodsService.listDetailByGid(Integer.parseInt(goodsId),subbranchId,pageBean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		//以流的形式输出result
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	
	public String subDetailGoods() throws Exception{
		goodsDetId = goodsDetId.replace(" ", "");
		amount = amount.replace(" ", "");
		String[] Id = goodsDetId.split(",");
		String[] Amount = amount.split(",");
		for(int i = 0; i < Id.length ; i ++){
			//System.out.println(Id[i]+"--------"+Amount[i]);
			result = detailgoodsService.subDetailGoods(Integer.parseInt(Id[i]), subbranchId, Integer.parseInt(Amount[i]));
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();   
			            out.print(result);  
			            out.flush();
		}
		return null;
	}
	
	public String deleteSubDetGoods() throws Exception{
		result = detailgoodsService.deleteSubDetGoods(Integer.parseInt(goodsDetId), subbranchId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		        //��ȡ�������Ȼ��ʹ��  
		PrintWriter out = response.getWriter();   
		            //����ı���Ϣ  
		            out.print(result);  
		            out.flush();
		return null;
	}
	
	public String querySubDetail() throws Exception{
		result = detailgoodsService.querySubDetail(subbranchId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	/*
	 * 
	 */
	public String checkGoodsCode() throws Exception{
		result = detailgoodsService.checkGoodsCode(goodsCode);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}
	public String getClassifyId() {
		return classifyId;
	}
	
	/**
	 * 查询所有商品
	 * @param classifyId
	 * @throws IOException 
	 */
	public String listDetailBysubgood() throws IOException{
		pageBean.setCurrentPage(page);
		result = detailgoodsService.listDetailBysubgood(Integer.parseInt(classifyId),subbranchId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		//以流的形式输出result
		PrintWriter out = response.getWriter();   
		            out.print(result);  
		            out.flush();
		return null;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public GoodsDetai getGoodsDetai() {
		return goodsDetai;
	}

	public void setGoodsDetai(GoodsDetai goodsDetai) {
		this.goodsDetai = goodsDetai;
	}

	public Integer getGoodsDetailId() {
		return goodsDetailId;
	}

	public void setGoodsDetailId(Integer goodsDetailId) {
		this.goodsDetailId = goodsDetailId;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Integer getGoods_detail_id() {
		return goods_detail_id;
	}

	public void setGoods_detail_id(Integer goods_detail_id) {
		this.goods_detail_id = goods_detail_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getSubbranchId() {
		return subbranchId;
	}

	public void setSubbranchId(Integer subbranchId) {
		this.subbranchId = subbranchId;
	}

	public String getGoodsDetId() {
		return goodsDetId;
	}

	public void setGoodsDetId(String goodsDetId) {
		this.goodsDetId = goodsDetId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	
}
