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
import baidu.giftshop.service.impl.ClassifyService;

@Controller
public class ClassifyController {
	
	@Autowired
	@Qualifier("classifyService")
	private ClassifyService classifyService;
    
	/**
	 * 返回某个分店的分类列表
	 * @param subbranch_id
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/ClassifyList")
	public void ClassifyList(@RequestParam(value="subbranch_id",required=false) Integer subbranch_id,HttpServletRequest request,HttpServletResponse response){
		Base base = classifyService.getAllClassify(subbranch_id);
		   response.setContentType("text/javascript;charset=UTF-8");
		   response.setCharacterEncoding("UTF-8");
		   try {
			response.getWriter().print(JSON.toJSONString(base));
		} catch (IOException e) {
			e.printStackTrace();
		    }
		}
}

