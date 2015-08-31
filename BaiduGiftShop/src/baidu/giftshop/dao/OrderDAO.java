package baidu.giftshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.bean.NewOrderBean;
import baidu.giftshop.bean.OrderBean;
import baidu.giftshop.entity.Orders;
import baidu.giftshop.entity.UserOrder;
import baidu.giftshop.util.HibernateSessionFactory;

public class OrderDAO {
	/*
	@SuppressWarnings("unchecked")
	public List<OrderBean> listAllOrder(Integer subbranch_id){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
	//	String sql = "select o.orderid,gd.name,gd.goodsCode,o.num,a.addressee,a.address,o.state,u.id "
	//			+ "from Orders o,UserOrder uo,GoodsDetai gd,Address a,User u "
	//			+ "where o.orderid=uo.orderid and o.goodsDetail=gd and o.address=a and uo.user=u and o.subbranchId=? order by o.orderid "; 
	  
//		String sql = "select o.orderid,gd.name,gd.goodsCode,o.num,a.addressee,a.address,o.state,u.id "
//				+ "from Orders o,UserOrder uo,GoodsDetai gd,Address a,User u"
//				+ " where o.orderid =uo.orderid and o.goodsDtail= gd and o.address.id=a.id and uo.user.id= u.userid and o.subbranchId=? ";
		
		String aql="select  o.orderid ,o.num,o.state, ad.addressee, ad.address,ad.phone,gd.name,gd.shop_code from user_order uo ,orders  o , address  ad ,goods_detail gd, user u"+
   " WHERE  o.orderid=uo.orderid and o.addressid=ad.id and  o.good_detail_id=gd.id  and uo.userid=u.user_id and o.subbranch_id= ?";
		SQLQuery a=	session.createSQLQuery(aql);
	//	Query q = session.createQuery(sql);
	 //   q.setParameter(0, subbranch_id);
		a.setParameter(0, subbranch_id);
		  List<Object[]> list=	a.list();
	 //   List<Object[]> list = q.list();
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
	*/
	@SuppressWarnings("unchecked")
	public List<NewOrderBean> listAllOrder(Integer subbranch_id){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String aql="select  o.orderid ,gd.name,gd.shop_code,o.num,o.total_money, ad.addressee, ad.address,ad.phone,o.state ,u.user_id from user_order uo ,orders  o , address  ad ,goods_detail gd, user u"+
				 " WHERE  o.orderid=uo.orderid and o.addressid=ad.id and  o.good_detail_id=gd.id  and uo.userid=u.user_id and o.subbranch_id= ?";
		SQLQuery a=	session.createSQLQuery(aql);
		a.setParameter(0, subbranch_id);
		List<Object[]> list=	a.list();
	    tr.commit();
	    List<NewOrderBean> prelist = new ArrayList<NewOrderBean>();
	    for(int i = 0 ; i < list.size() ; i ++){
	    	Object[] obs = list.get(i);
	    	NewOrderBean orderbean = new NewOrderBean();
	    	orderbean.setOrderid((String)obs[0]);
	    	orderbean.setGoodsname((String)obs[1]);
	    	orderbean.setGoodscode((String)obs[2]);
	    	orderbean.setNum(String.valueOf((Integer)obs[3]));
	    	orderbean.setTotalMoney((String)obs[4]);
	    	orderbean.setAddressee((String)obs[5]);
	    	orderbean.setAddress((String)obs[6]);
	    	orderbean.setPhone((String)obs[7]);
	    	orderbean.setState((String)obs[8]);
	    	orderbean.setUserid((String)obs[9]);
	    	prelist.add(orderbean);
	    }
	    session.close();
		return prelist;
	}
	
	
public List<NewOrderBean> listAllOrder(Integer firstResult,Integer maxResult,Integer subbranch_id){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String aql="select  o.orderid ,gd.name,gd.shop_code,o.num,o.total_money, ad.addressee, ad.address,ad.phone,o.state ,u.user_id from user_order uo ,orders  o , address  ad ,goods_detail gd, user u"+
				 " WHERE  o.orderid=uo.orderid and o.addressid=ad.id and  o.good_detail_id=gd.id  and uo.userid=u.user_id and o.subbranch_id= ?  order by o.orderid desc ";
		SQLQuery a=	session.createSQLQuery(aql);
		a.setFirstResult(firstResult);
		a.setMaxResults(maxResult);
		a.setParameter(0, subbranch_id);
		List<Object[]> list=a.list();
	    tr.commit();
	    List<NewOrderBean> prelist = new ArrayList<NewOrderBean>();
	    for(int i = 0 ; i < list.size() ; i ++){
	    	Object[] obs = list.get(i);
	    	NewOrderBean orderbean = new NewOrderBean();
	    	orderbean.setOrderid((String)obs[0]);
	    	orderbean.setGoodsname((String)obs[1]);
	    	orderbean.setGoodscode((String)obs[2]);
	    	orderbean.setNum(String.valueOf((Integer)obs[3]));
	    	orderbean.setTotalMoney((String)obs[4]);
	    	orderbean.setAddressee((String)obs[5]);
	    	orderbean.setAddress((String)obs[6]);
	    	orderbean.setPhone((String)obs[7]);
	    	orderbean.setState((String)obs[8]);
	    	orderbean.setUserid((String)obs[9]);
	    	prelist.add(orderbean);
	    }
	    session.close();
		return prelist;
	}
	//重写listAllOrder方法
/*	@SuppressWarnings("unchecked")
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
	}*/
//	public void addlogistics(String userid,String orderid,String shipnum,String fedex){
//		Session session = HibernateSessionFactory.getSession();
//		Transaction tr = session.beginTransaction();
//	    String sql = " from UserOrder uo where uo.orderid=? ";
//	    Query q = session.createQuery(sql);
//	    q.setParameter(0, orderid);
//	    Object a=q.uniqueResult();
//	    UserOrder u=(UserOrder)a;
//	        u.setShipnum(shipnum);
//	        u.setFedex(fedex);
//	        u.setDeliverytime(String.valueOf(System.currentTimeMillis()));
//	        session.saveOrUpdate(u);
//	    
//	    this.changstate(orderid);
//	    tr.commit();
//	    session.close();
//	}
	
	@SuppressWarnings("unchecked")
	public void changstate(String orderid){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select o from Orders o where o.orderid=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, orderid);
		List<Orders> list = q.list();
		for(int i = 0 ; i <list.size(); i++){
			Orders orders = list.get(i);
			orders.setState("已发货");
		}
	}


	public void addlogistics(String orderid,String shipnum,String fedex,String userid){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
	    String sql = "select uo from UserOrder uo where uo.orderid=? and uo.userid=?";
	    Query q = session.createQuery(sql);
	    q.setParameter(0, orderid);
	    q.setParameter(1, userid);
	    UserOrder userorder=   (UserOrder)q.uniqueResult();
	    if(q.list().size()>0){
	      //  UserOrder userorder = (UserOrder) q.list().get(0);
	        userorder.setShipnum(shipnum);
	        userorder.setFedex(fedex);
	        userorder.setDeliverytime(String.valueOf(System.currentTimeMillis()));
	        session.saveOrUpdate(userorder);
	        this.changstate(orderid);
	      }
			
			
	    tr.commit();
	    session.close();
	}
	
}
