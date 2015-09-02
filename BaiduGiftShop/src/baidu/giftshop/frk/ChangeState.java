package baidu.giftshop.frk;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.GoodsDetailSubbranch;
import baidu.giftshop.entity.Orders;
import baidu.giftshop.entity.UserOrder;
import baidu.giftshop.util.HibernateSessionFactory;

public class ChangeState {

	//超过12小时没有付款的自动取消订单
	@SuppressWarnings({ "unchecked" })
	public void translateGo() {
		//DateTools datatools = new DateTools();
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select o from Orders o";
		Query q = session.createQuery(sql);
		List<Orders> list = q.list();
//		for(int i = 0 ; i < list.size() ; i ++){
//			Long c = System.currentTimeMillis();
//			Date date = list.get(i).getData();
//			long d = date.getTime();
//			Long e = c - d;
//			if(e >= 43200000){
//				if(list.get(i).getState().equals("待支付"))
//				list.get(i).setState("已取消");
//			}
//		}
		  for (Orders orders :list) {
			  Long c = System.currentTimeMillis();
				Date date = orders.getData();
				long d = date.getTime();
				Long e = c - d;
				String state= orders.getState();
				if(e >=  43200000&& state.equals("待支付")){
					Integer goodsDetailId=orders.getGoodsdetailid();
					Integer	subbranchId=orders.getSubbranchId();
					Integer num=orders.getNum();
					orders.setState("已取消");
					this.updateAmount(goodsDetailId, subbranchId, num);
				}
			}
		
		tr.commit();
		session.close();
	}
	
	private void updateAmount(Integer goodsDetailId, Integer subbranchId, int num) {
		Session session = HibernateSessionFactory.getSession();
//		String sql = " update goods_detail_subbranch set amount = amount- ?  where goods_detail_id=? and subbranch_id=?";
		String sql = " select gd from GoodsDetailSubbranch gd where gd.goodsDetai.id =? and gd.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goodsDetailId);
		q.setParameter(1, subbranchId);
		GoodsDetailSubbranch gd=(GoodsDetailSubbranch)q.uniqueResult();
		  Integer s= gd.getAmount();
		  gd.setAmount(s+num);
		
	}

	//发货后,10天之内没点确认收获,自动交易完成;
	@SuppressWarnings({ "unchecked" })
	public void automaticpay(){
		//DateTools datatools = new DateTools();
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select uo from UserOrder uo";
		Query q = session.createQuery(sql);
		List<UserOrder> list = q.list();
		for(int i = 0 ; i < list.size(); i ++){
			String	time = list.get(i).getDeliverytime();
			if( time != null && ! time.isEmpty()){
			Long a = System.currentTimeMillis();
			long c = a - Long.parseLong(time);
			if(c >= 864000000){
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
			if(list.get(i).getState().equals("已发货")){
				list.get(i).setState("交易完成");
			}
		}
	}
}
