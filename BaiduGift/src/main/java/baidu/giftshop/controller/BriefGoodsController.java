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
import baidu.giftshop.service.IBriefGoodsService;

@Controller
public class BriefGoodsController {
	
	@Autowired
	@Qualifier("briefGoodsService")
	private IBriefGoodsService briefGoodsService;
	
	/**
	 * 根据分店ID和分类ID得到概要商品的信息列表
	 * @param subbranch_id
	 * @param classify_id
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/BriefGoodsList")
	public void BriefGoodsList(@RequestParam(value="subbranch_id",required=false) Integer subbranch_id,@RequestParam(value="classify_id",required=false) Integer classify_id,
			HttpServletRequest request,HttpServletResponse response){
		Base base = new Base();
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer requestAmount = Integer.parseInt(request.getParameter("requestAmount"));
		if(classify_id!=null){
		   base = briefGoodsService.getBriefGoods(subbranch_id, classify_id, startIndex, requestAmount);
		}else{
	       base = briefGoodsService.getBriefGoods(subbranch_id, startIndex, requestAmount);
		}
		response.setContentType("text/javascript;charset=UTF-8");
		   response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
		}
	
	/**
	 * 模糊查询概要商品信息接口
	 * @param subbranch_id
	 * @param classify_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/QueryGoods")
	public void QueryGoods(@RequestParam(value="subbranch_id",required=false) Integer subbranch_id,@RequestParam(value="classify_id",required=false) Integer classify_id,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		Base base = new Base();
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer requestAmount = Integer.parseInt(request.getParameter("requestAmount"));
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso8859-1"),"utf-8");
		if(classify_id!=null){
		   base = briefGoodsService.queryBriefGoods(subbranch_id, classify_id,startIndex, requestAmount, name);
		}else{
	       base = briefGoodsService.queryBriefGoods(subbranch_id, startIndex, requestAmount,name);
		}
		   response.setContentType("text/javascript;charset=UTF-8");
		   response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
		}
	}
