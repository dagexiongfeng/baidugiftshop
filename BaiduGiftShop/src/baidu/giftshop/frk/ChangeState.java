package baidu.giftshop.frk;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.Orders;
import baidu.giftshop.entity.UserOrder;
import baidu.giftshop.util.HibernateSessionFactory;

public class ChangeState {

	//超过半天没有付款的自动取消订单
	@SuppressWarnings({ "unchecked" })
	public void translateGo() {
		//DateTools datatools = new DateTools();
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select o from Orders o";
		Query q = session.createQuery(sql);
		List<Orders> list = q.list();
		for(int i = 0 ; i < list.size() ; i ++){
			Long c = System.currentTimeMillis();
			Date date = list.get(i).getData();
			long d = date.getTime();
			Long e = c - d;
			if(e >= 43200000){
				if(list.get(i).getState().equals("待付款"))
				list.get(i).setState("已取消");
			}
		}
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings({ "unchecked" })
	public void automaticpay(){
		//DateTools datatools = new DateTools();
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select uo from UserOrder uo";
		Query q = session.createQuery(sql);
		List<UserOrder> list = q.list();
		for(int i = 0 ; i < list.size(); i ++){
			if(list.get(i).getDeliverytime()!=null){
			Long a = System.currentTimeMillis();
			String b = list.get(i).getDeliverytime();
			long c = a - Long.parseLong(b);
			if(c >= 661288535){
				this.changstate(list.get(i).getOrderid());
			     }
			}
		}
		tr.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public void changstate(String orderid){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select o from Orders o where o.orderid=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, orderid);
		List<Orders> list = q.list();
		for(int i = 0 ; i < list.size();i++){
			if(list.get(i).getState().equals("已发送")){
				list.get(i).setState("已完成");
			}
		}
	}
}
