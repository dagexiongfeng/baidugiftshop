package baidu.giftshop.service.impl;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baidu.giftshop.dao.UserMapper;
import baidu.giftshop.model.User;
import baidu.giftshop.service.IUserService;
import baidu.giftshop.util.HttpUtilsPost;

@Service("userService")
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper userDao;

	@SuppressWarnings("static-access")
	@Override
	public Integer getUid(String Atid) {
		
        HttpUtilsPost httputilspost = new HttpUtilsPost();
		
		String url_path = "http://uuapauth.itebeta.baidu.com/v2/validateTicket";
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("appKey", "uuapclient-11-164fs4y6p3SxE3a5eqFQ");
		map.put("ticket", Atid);
		map.put("resultType", "json");
		
		String string = httputilspost.SendPostMessage(url_path, map);
		
		JSONObject jsonObj = JSONObject.fromObject(string);
		String username = (String) jsonObj.getJSONObject("user").get("username");
		System.out.println(jsonObj.getJSONObject("user").get("username"));
		
		List<User> list = userDao.selectByUname(username);
		if(list.size()>0){
			User user = list.get(0);
	//		Integer user_id = user.getUserId();
	//		return user_id;
			return null;
		}else{
			Integer userid = setuserid();
			User user = new User();
//			user.setUserId(userid);
			user.setUsername(username);
			userDao.insert(user);
			return userid;
		}
	}
	
	/**
	 * 随即生存一个userid
	 * @return
	 */
	public Integer setuserid(){
		Integer userid = (int)(Math.random()*10000)+1;
		int result = userDao.selectByUid(userid);
		if(result < 1){
			return userid;
		}else{
			setuserid();
		}
		return userid;
	}

	@Override
	public User getUser(String username) {
	  return userDao.getUser(username);
		
	}

	@Override
	public void saveUser(User user1) {
		userDao.saveUser(user1);
	}
}
