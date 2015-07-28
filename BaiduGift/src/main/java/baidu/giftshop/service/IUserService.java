package baidu.giftshop.service;

import baidu.giftshop.model.User;

public interface IUserService {
	
	Integer getUid(String Atid);

	/**
	 * 查询是否存在用户
	 * @param username
	 * @return 
	 */
	User getUser(String username);

	/**
	 * 保存用户信息
	 * @param user1
	 */
	void saveUser(User user1);


}
