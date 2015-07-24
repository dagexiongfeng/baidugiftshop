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
import baidu.giftshop.service.IEvaluationService;
import baidu.giftshop.service.IUserService;

@Controller
public class EvaluationController {

	@Autowired
	@Qualifier("evaluationService")
	private IEvaluationService evaluationService;
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	/**
	 * 增加商品评论
	 * @param user_id
	 * @param goods_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/AddEvaluation")
	public void AddEvaluation(@RequestParam(value="user_id",required=false) String user_id,@RequestParam(value="goods_id",required=false) Integer goods_id,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		String evaluation = request.getParameter("evaluation");
		Base base = new Base();
		
		Integer userid = userService.getUid(user_id);
		
		System.out.println("--------"+evaluation);
		base = evaluationService.addEvaluation(userid, goods_id, evaluation);
		response.setContentType("text/javascript;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
		}
	
	/**
	 * 根据概要商品的ID得到所有的评论信息
	 * @param goods_id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/QueryEvaluation")
	public void QueryEvaluation(@RequestParam(value="goods_id",required=false) Integer goods_id,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));
		Integer requestAmount = Integer.parseInt(request.getParameter("requestAmount"));
		Base base = new Base();
		base = evaluationService.queryEvalutaion(goods_id, startIndex, requestAmount);
		response.setContentType("text/javascript;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
	   }
}
