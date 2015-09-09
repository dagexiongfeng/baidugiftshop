package baidu.giftshop.dao;

import java.security.MessageDigest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.Account;
import baidu.giftshop.util.HibernateSessionFactory;
public class UserDAO {
	
	Session session = HibernateSessionFactory.getSession();
	//十六进制下数字到字符的映射数组  
		private final static String[] hexDigits = {"0", "1", "2", "3", "4",  
	        "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"}; 
		
		 /** * 把inputString加密     */  
	    public static String generatePassword(String inputString){  
	        return encodeByMD5(inputString);  
	    } 
	    
	    /**  对字符串进行MD5加密     */  
	    private static String encodeByMD5(String originString){  
	        if (originString != null){  
	            try{  
	                //创建具有指定算法名称的信息摘要  
	                MessageDigest md = MessageDigest.getInstance("MD5");  
	                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算  
	                byte[] results = md.digest(originString.getBytes());  
	                //将得到的字节数组变成字符串返回  
	                String resultString = byteArrayToHexString(results);  
	                return resultString.toUpperCase();  
	            } catch(Exception ex){  
	                ex.printStackTrace();  
	            }  
	        }  
	        return null;  
	    }  
	    
	    /**  
	     * 转换字节数组为十六进制字符串 
	     * @param     字节数组 
	     * @return    十六进制字符串 
	     */  
	    private static String byteArrayToHexString(byte[] b){  
	        StringBuffer resultSb = new StringBuffer();  
	        for (int i = 0; i < b.length; i++){  
	            resultSb.append(byteToHexString(b[i]));  
	        }  
	        return resultSb.toString();  
	    }  
	      
	    /** 将一个字节转化成十六进制形式的字符串     */  
	    private static String byteToHexString(byte b){  
	        int n = b;  
	        if (n < 0)  
	            n = 256 + n;  
	        int d1 = n / 16;  
	        int d2 = n % 16;  
	        return hexDigits[d1] + hexDigits[d2];  
	    }  
	public void addUser(String account,String password,Integer subbranch,String email,String tel){
		
		@SuppressWarnings("unused")
		UserDAO userdao = new UserDAO();
		String MD5Pwd = UserDAO.generatePassword(password);
		Transaction tr = session.beginTransaction();
		Account acc = new Account();
		acc.setAccount(account);
		acc.setPassword(MD5Pwd);
		acc.setSubbranchId(subbranch);
		acc.setAuthority(1);
		acc.setEmail(email);
		acc.setTel(tel);
		session.save(acc);
		tr.commit();
	}
	
	@SuppressWarnings({ "unused" })
	public Account login(String account,String password){
		UserDAO userdao = new UserDAO();
		String Pwd = UserDAO.generatePassword(password);
		Transaction tr = session.beginTransaction();
		String sql ="select a from Account a where a.account=? and a.password=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, account);
		q.setParameter(1, Pwd);
		@SuppressWarnings("unchecked")
		List<Account> list = q.list();
		if(list.size()>0){
			Account acc = list.get(0);
			return acc;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings({ })
	public String changPwd(Integer id,String password){
	  if(password!=null&&!"".equals(password.replace(" ", ""))){
		@SuppressWarnings("unused")
		UserDAO userdao = new UserDAO();
		String Pwd = UserDAO.generatePassword(password);
		Transaction tr = session.beginTransaction();
		Account account = (Account) session.get(Account.class, id);
		account.setPassword(Pwd);
		session.update(account);
		tr.commit();
	   }
		return null;
	}
	public void deleteUser(Integer id){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		Account account = (Account) session.get(Account.class, id);
		session.delete(account);
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> getAllUser(){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select a from Account a ";
		Query q = session.createQuery(sql);
		List<Account> list = q.list();
		session.close();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Account> getAllUser(Integer maxResult,Integer firstResult){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select a from Account a";
		Query q = session.createQuery(sql);
		q.setMaxResults(maxResult);
		q.setFirstResult(firstResult);
		List<Account> list = q.list();
		session.close();
		return list;
	}
	/**
	 * 判断用户名唯一性
	 * @param account
	 * @return
	 */
	public Integer  valuationUsername(String account){
		String sql = "select a from Account a where a.account=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, account);
		Integer ac=q.list().size();
		return ac;
	}
	/**
	 * 判断邮箱唯一性
	 * @param email
	 * @return
	 */
	public Integer valuationEmail(String email){
		String sql = "select a from Account a where a.email=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, email);
		Integer a=q.list().size();
		return a;
	}
}
