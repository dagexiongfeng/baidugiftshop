package baidu.giftshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import baidu.giftshop.model.Base;
import baidu.giftshop.service.IDetailGoodsService;

@Controller
public class DetailGoodsController {

	@Autowired
	@Qualifier("detailGoodsService")
	private IDetailGoodsService detailGoodsService;
	
	/**
	 * 显示明细商品列表
	 * @param subbranch_id
	 * @param classify_id
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/DetailGoodsList")
	public void DetailGoodsList(@RequestParam(value="subbranch_id",required=false) Integer subbranch_id,@RequestParam(value="classify_id",required=false) Integer classify_id,
			HttpServletRequest request,HttpServletResponse response){
		Base base = new Base();
		Integer goods_id = Integer.parseInt(request.getParameter("goods_id"));
		base = detailGoodsService.getDetailGoods(subbranch_id, classify_id, goods_id);
		   
		try {
			    response.setContentType("text/javascript;charset=UTF-8");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().print(JSON.toJSONString(base));
		   } catch (IOException e) {
			    e.printStackTrace();
		    }
	}
	
	/**
	 * 查询分店里某个明细商品的库存量
	 * @param subbranch_id
	 * @param goods_detail_id
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/QueryAmount")
	public void QueryAmount(@RequestParam(value="subbranch_id",required=false) Integer subbranch_id,@RequestParam(value="goods_detail_id",required=false) Integer goods_detail_id,
			HttpServletRequest request,HttpServletResponse response){
		Base base = new Base();
		base = detailGoodsService.queryAmount(goods_detail_id, subbranch_id);
		
		try {
		    response.setContentType("text/javascript;charset=UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().print(JSON.toJSONString(base));
	   } catch (IOException e) {
		    e.printStackTrace();
	    }
	}
}
