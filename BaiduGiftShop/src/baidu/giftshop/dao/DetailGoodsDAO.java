package baidu.giftshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.bean.Base;
import baidu.giftshop.entity.Goods;
import baidu.giftshop.entity.GoodsDetai;
import baidu.giftshop.entity.GoodsDetailSubbranch;
import baidu.giftshop.entity.Subbranch;
import baidu.giftshop.util.HibernateSessionFactory;

public class DetailGoodsDAO {
	/**
	 * 增加一条明细商品信息
	 * @param goodsDetai
	 */
	public void addDetailGoods(GoodsDetai goodsDetai){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(goodsDetai);
	    tr.commit();
	}
	/**
	 * 得到概要商品的信息
	 * @param classifyId
	 * @param goodsId
	 * @return
	 */
	public Goods queryGoods(String classifyId,String goodsId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		Integer Id = Integer.parseInt(classifyId);
		String sql = "select g from Goods g where g.classify.id=? and g.name=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, Id);
		q.setParameter(1, goodsId);
		Goods goods = (Goods) q.list().get(0);
		tr.commit();
		return goods;
	}
	/**
	 * 传入（条形码barCode和商品明细Id）
	 * 两个值时调用这个方法
	 * 得到明细商品的信息
	 * @param goodsDetailId
	 * @return
	 */
	public GoodsDetai queryDetaiGoods(String barCode,Integer goodsDetailId){
		Session session = HibernateSessionFactory.getSession();
		GoodsDetai goodsdetai = (GoodsDetai) session.get(GoodsDetai.class, goodsDetailId);
		return goodsdetai;
	}
	/**
	 * 传入一个条形码barCode
	 * 一个值时调用这个方法
	 * 得到明细商品的信息
	 * @param goodsDetailId
	 * @return
	 */
	public GoodsDetai queryDetaiGoods(String barCode){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select g from GoodsDetai g where g.barCode=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, barCode);
		if(q.list().size()>0){
		   GoodsDetai goodsdetai = (GoodsDetai) q.list().get(0);
		   return goodsdetai;
		}
		else{
			return null;
		}
	}
	/**
	 *得到所有商品的List
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsDetai> listallDetailGoods(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql ="from GoodsDetai";
		Query q = session.createQuery(sql);
		List<GoodsDetai> list = q.list();
		tr.commit();
		session.close();
		return list;
	}
	/**
	 * 复写上面的方法
	 * 得到所有商品的List
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsDetai> listallDetailGoods(Integer firstResult,Integer maxResult){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql ="from GoodsDetai";
		Query q = session.createQuery(sql);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResult);
		List<GoodsDetai> list = q.list();
		tr.commit();
		session.close();
		return list;
	}
	/**
	 * 下架或上架一件商品
	 * @param goodsDetailId
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Base deleteDetail(Integer goodsDetailId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		GoodsDetai goodsdetai = (GoodsDetai) session.get(GoodsDetai.class, goodsDetailId);
		Base base = new Base();
		//下架
		if(goodsdetai.getState()==1){
			goodsdetai.setState(0);
			session.saveOrUpdate(goodsdetai);
			tr.commit();
			base.setContent(101);
			this.downSubDetGoods(goodsDetailId);
			//上架
		}else if(goodsdetai.getState()==0){
			Goods goods = goodsdetai.getGoods();
			if(goods.getState()==1){
			    goodsdetai.setState(1);
			    session.saveOrUpdate(goodsdetai);
				tr.commit();
			    base.setContent(101);
			}else if(goods.getState()==0){
			    base.setContent(102);
			}
		}
		return base;
	}
	
	@SuppressWarnings("unchecked")
	public List<GoodsDetai> listDetailByGid(Integer goodsId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gd from GoodsDetai gd where gd.goods.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goodsId);
		List<GoodsDetai> list = q.list();
		tr.commit();
		session.close();
		
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<GoodsDetai> listDetailByGid(Integer goodsId,Integer firstResult,Integer maxResult){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gd from GoodsDetai gd where gd.goods.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goodsId);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResult);
		List<GoodsDetai> list = q.list();
		tr.commit();
		session.close();
		
		return list;
	}
	public Boolean subDetailGoods(Integer goods_detail_id,Integer subbranch_id,Integer amount){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gds from GoodsDetailSubbranch gds where gds.goodsDetai.id=? and gds.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goods_detail_id);
		q.setParameter(1, subbranch_id);
		if(q.list().size()<1){
			GoodsDetai goodsdetai = (GoodsDetai) session.get(GoodsDetai.class, goods_detail_id);
			if(goodsdetai.getState()==1){
				Subbranch subbranch = (Subbranch) session.get(Subbranch.class,
						subbranch_id);
				GoodsDetailSubbranch goodsdetailsubbranch = new GoodsDetailSubbranch();
				goodsdetailsubbranch.setGoodsDetai(goodsdetai);
				goodsdetailsubbranch.setSubbranch(subbranch);
				goodsdetailsubbranch.setAmount(amount);
				session.saveOrUpdate(goodsdetailsubbranch);
				tr.commit();
				session.close();
			}else if(goodsdetai.getState()==0){
				session.close();
				return false;
			}
		}else{
			GoodsDetailSubbranch gds = (GoodsDetailSubbranch) q.list().get(0);
			Integer gdsamount = gds.getAmount();
			if(gdsamount!=amount){
				gds.setAmount(amount);
				session.saveOrUpdate(gds);
				tr.commit();
				session.close();
			}else{
			}
		}
		return true;
	}
	
	/**
	 * 分店店员取消绑定
	 * @param goods_detail_id
	 * @param subbranch_id
	 */
	public void deleteSubDetGoods(Integer goods_detail_id,Integer subbranch_id){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gds from GoodsDetailSubbranch gds where gds.goodsDetai.id=? and gds.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goods_detail_id);
		q.setParameter(1, subbranch_id);
		if(q.list().size()>0){
			GoodsDetailSubbranch goodsdetailsubbranch = (GoodsDetailSubbranch) q.list().get(0);
			session.delete(goodsdetailsubbranch);
		}else{
		}
		tr.commit();
		session.close();
	}
	/**
	 * 超级管理员下架明细商品的时候把所有和这个明细商品有关的分店绑定全部取消
	 * @param goods_detail_id
	 */
	public void downSubDetGoods(Integer goods_detail_id){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gds from GoodsDetailSubbranch gds where gds.goodsDetai.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goods_detail_id);
		if(q.list().size()>0){
			GoodsDetailSubbranch goodsdetailsubbranch = (GoodsDetailSubbranch) q.list().get(0);
			session.delete(goodsdetailsubbranch);
		}else{
		}
		tr.commit();
	}
	/**
	 * 根据分店的Id得到分店绑定的明细商品信息
	 * @param subbranchId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List querySubDetail(Integer subbranchId){
	    Session session = HibernateSessionFactory.getSession();
	    Transaction tr = session.beginTransaction();
	    String sql = "select gds.goodsDetai.id from GoodsDetailSubbranch gds where gds.subbranch.id=?";
	    Query q = session.createQuery(sql);
	    q.setParameter(0, subbranchId);
	    List list = q.list();
	    tr.commit();
	    session.close();
		return list;
	}
	
	/**
	 * 下架一个概要商品时，下架所有的明细商品
	 * @param goodsDetailId
	 */
	public Boolean downDetail(Integer goodsDetailId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		GoodsDetai goodsdetai = (GoodsDetai) session.get(GoodsDetai.class, goodsDetailId);
		goodsdetai.setState(0);
		session.saveOrUpdate(goodsdetai);
		tr.commit();
		return true;
	}
	
	public Integer checkGoodsCode(String goodsCode){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select g from GoodsDetai g where g.goodsCode=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goodsCode);
		if(q.list().size()>0){
			return q.list().size();
		}else{
			return 0;
		}
	}
	
}
