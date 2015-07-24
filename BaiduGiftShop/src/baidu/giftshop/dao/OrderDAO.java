package baidu.giftshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.bean.OrderBean;
import baidu.giftshop.entity.Orders;
import baidu.giftshop.entity.UserOrder;
import baidu.giftshop.util.HibernateSessionFactory;

public class OrderDAO {
	
	@SuppressWarnings("unchecked")
	public List<OrderBean> listAllOrder(Integer subbranch_id){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select o.orderid,gd.name,gd.goodsCode,o.num,a.addressee,a.address,o.state,u.id "
				+ "from Orders o,UserOrder uo,GoodsDetai gd,Address a,User u "
				+ "where o.orderid=uo.orderid and o.goodsDetail=gd and o.address=a and uo.user=u and o.subbranchId=?";
	    Query q = session.createQuery(sql);
	    q.setParameter(0, subbranch_id);
	    List<Object[]> list = q.list();
	    tr.commit();
	    List<OrderBean> prelist = new ArrayList<OrderBean>();
	    for(int i = 0 ; i < list.size() ; i ++){
	    	Object[] obs = list.get(i);
	    	OrderBean orderbean = new OrderBean();
	    	orderbean.setOrderid((Integer)obs[0]);
	    	orderbean.setGoodsname((String)obs[1]);
	    	orderbean.setGoodscode((String)obs[2]);
	    	orderbean.setNum(String.valueOf((Integer)obs[3]));
	    	orderbean.setAddressee((String)obs[4]);
	    	orderbean.setAddress((String)obs[5]);
	    	orderbean.setState((String)obs[6]);
	    	orderbean.setUsername(String.valueOf((Integer)obs[7]));
	    	prelist.add(orderbean);
	    }
	    session.close();
		return prelist;
	}
	//重写listAllOrder方法
	@SuppressWarnings("unchecked")
	public List<OrderBean> listAllOrder(Integer firstResult,Integer maxResult,Integer subbranch_id){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select o.orderid,gd.name,gd.goodsCode,o.num,a.addressee,a.address,o.state,u.id "
				+ "from Orders o,UserOrder uo,GoodsDetai gd,Address a,User u "
				+ "where o.orderid=uo.orderid and o.goodsDetail=gd and o.address=a and uo.user=u and o.subbranchId=?";
	    Query q = session.createQuery(sql);
	    q.setFirstResult(firstResult);
	    q.setMaxResults(maxResult);
	    q.setParameter(0, subbranch_id);
	    List<Object[]> list = q.list();
	    tr.commit();
	    List<OrderBean> prelist = new ArrayList<OrderBean>();
	    for(int i = 0 ; i < list.size() ; i ++){
	    	Object[] obs = list.get(i);
	    	OrderBean orderbean = new OrderBean();
	    	orderbean.setOrderid((Integer)obs[0]);
	    	orderbean.setGoodsname((String)obs[1]);
	    	orderbean.setGoodscode((String)obs[2]);
	    	orderbean.setNum(String.valueOf((Integer)obs[3]));
	    	orderbean.setAddressee((String)obs[4]);
	    	orderbean.setAddress((String)obs[5]);
	    	orderbean.setState((String)obs[6]);
	    	orderbean.setUsername(String.valueOf((Integer)obs[7]));
	    	prelist.add(orderbean);
	    }
	    session.close();
		return prelist;
	}
	public void addlogistics(Integer userid,Integer orderid,String shipnum,String fedex){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
	    String sql = "select uo from UserOrder uo where uo.orderid=? and uo.user.id=?";
	    Query q = session.createQuery(sql);
	    q.setParameter(0, orderid);
	    q.setParameter(1, userid);
	    if(q.list().size()>0){
	        UserOrder userorder = (UserOrder) q.list().get(0);
	        userorder.setShipnum(shipnum);
	        userorder.setFedex(fedex);
	        userorder.setDeliverytime(String.valueOf(System.currentTimeMillis()));
	        session.saveOrUpdate(userorder);
	      }
	    this.changstate(orderid);
	    tr.commit();
	    session.close();
	}
	
	@SuppressWarnings("unchecked")
	public void changstate(Integer orderid){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select o from Orders o where o.orderid=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, orderid);
		List<Orders> list = q.list();
		for(int i = 0 ; i <list.size(); i++){
			Orders orders = list.get(i);
			orders.setState("已发送");
		}
	}
}
