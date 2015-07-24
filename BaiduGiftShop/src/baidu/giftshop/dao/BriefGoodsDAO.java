package baidu.giftshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.Classify;
import baidu.giftshop.entity.Goods;
import baidu.giftshop.entity.GoodsPicture;
import baidu.giftshop.entity.GoodsSubbranch;
import baidu.giftshop.entity.Subbranch;
import baidu.giftshop.util.HibernateSessionFactory;

public class BriefGoodsDAO {
	/**
	 * 增加概要商品的信息
	 * @param classifyId
	 * @param unit
	 * @param name
	 * @return
	 */
	public Boolean savegoods(Integer classifyId,String unit,String name){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		Classify classify = (Classify) session.get(Classify.class, classifyId);
		String sql = "select g from Goods g where g.name=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, name);
		@SuppressWarnings("unchecked")
		List<Goods> list = q.list();
	 if(list.size() < 1){
		Goods goods = new Goods();
		goods.setClassify(classify);
		goods.setUnit(unit);
		goods.setName(name);
		goods.setState(1);
		session.save(goods);
		tr.commit();
		return true;
		}else{
			return false;
		}
	}
	/**
	 * 通过classifyId,unit,name得到goodsId的值
	 * @param classifyId
	 * @param unit
	 * @param name
	 * @return
	 */
	public Integer findGoodsId(Integer classifyId,String unit,String name){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select g.id from Goods g where g.classify.id=? and g.unit=? and g.name=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, classifyId);
		q.setParameter(1, unit);
		q.setParameter(2, name);
		Integer goodsid = (Integer) q.list().get(0);
		tr.commit();
		return goodsid;
	}
	/**
	 * 显示所有的概要商品的信息
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public List<GoodsPicture> queryAllBrief(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gp from GoodsPicture gp";
		Query q = session.createQuery(sql);
		List<GoodsPicture> list = q.list();
		tr.commit();
		session.close();
		return list;
	}
	/**
	 * 显示所有的概要商品的信息
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public List<GoodsPicture> queryAllBrief(Integer firstResult,Integer maxResult){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gp from GoodsPicture gp";
		Query q = session.createQuery(sql);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResult);
		List<GoodsPicture> list = q.list();
		tr.commit();
		session.close();
		return list;
	}
	/**
	 * 某个商品下架
	 * @param goods_id
	 * @param goods_picture_id
	 */
	@SuppressWarnings({ "unchecked" })
	public Boolean deleteBrief(Integer goods_id){
		Session session = HibernateSessionFactory.getSession();
		//下架所有者概商品下的详细商品
		DetailGoodsDAO detailgoodsdao = new DetailGoodsDAO();
		String sql = "select g.id from GoodsDetai g where g.goods.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goods_id);
		List<Integer> list = q.list();
		for(Integer goods_detail_id : list){
			//下架该概要商品下所有的明细商品信息
			detailgoodsdao.downDetail(goods_detail_id);
		}
		//概要商品中行和概要商品的图片
		Transaction tr = session.beginTransaction();
		Goods goods = (Goods) session.get(Goods.class,goods_id);
		if(goods.getState()==1)
		   goods.setState(0);
		   
		else
		   goods.setState(1);
		session.saveOrUpdate(goods);
		tr.commit();
		session.close();
		this.downsubBriefGoods(goods_id);
		return true;
	}
	/**
	 * 通过分类Id得到概要商品的名字
	 * @param Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> querygoodsById(Integer Id){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select g.name,g.unit,g.id from Goods g where g.classify.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, Id);
		List<Object[]> list = q.list();
		session.close();
		return list;
	}
	/**
	 * 通过分类Id得到概要商品的名字
	 * @param Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> querygoodsById(Integer Id,Integer firstResult,Integer maxResult){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select g.name,g.unit,g.id from Goods g where g.classify.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, Id);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResult);
		List<Object[]> list = q.list();
		session.close();
		return list;
	}
	/**
	 * 通过分类Id得到概要商品的名字
	 * @param Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> querySubgoods(Integer Id,Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select g.name,g.unit,g.id from Goods g,GoodsSubbranch gs where gs.goods=g and g.classify.id=? and gs.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, Id);
		q.setParameter(1, subbranchId);
		List<Object[]> list = q.list();
		session.close();
		return list;
	}
	/**
	 * 删除分店与概要商品绑定的数据
	 * @param subbranchId
	 */
	@SuppressWarnings("unchecked")
	public void deleteBriefById(Integer goodsId,Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gs from GoodsSubbranch gs where gs.goods.id=? and gs.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, goodsId);
		q.setParameter(1, subbranchId);
		List<GoodsSubbranch> list = q.list();
		for(int i =0;i<list.size();i++){
			GoodsSubbranch goodsSub = list.get(i);
			session.delete(goodsSub);
		}
		tr.commit();
	}
	/**
	 * 绑定分店的商店卖的概要商品
	 * @param goodsId
	 * @param subbranchId
	 */
	public Boolean subBundlbrief(Integer goodsId,Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gs from GoodsSubbranch gs where gs.goods.id=? and gs.subbranch.id=?";
		Query q =session.createQuery(sql);
		q.setParameter(0, goodsId);
		q.setParameter(1, subbranchId);
		if(q.list().size()<1){
			    Goods goods = (Goods) session.get(Goods.class, goodsId);
			if(goods.getState()==1){
				Subbranch subbranch = (Subbranch) session.get(Subbranch.class, subbranchId);
			    GoodsSubbranch goodssubbranch = new GoodsSubbranch();
			    goodssubbranch.setGoods(goods);
			    goodssubbranch.setSubbranch(subbranch);
			    session.saveOrUpdate(goodssubbranch);
			}else{
				return false;
			}
		 }else{
		}
		tr.commit();
		return true;
	}
	
	public void deletesubBriefGoods(Integer goodsId,Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gs from GoodsSubbranch gs where gs.goods.id=? and gs.subbranch.id=?";
		Query q =session.createQuery(sql);
		q.setParameter(0, goodsId);
		q.setParameter(1, subbranchId);
		if(q.list().size()>0){
			GoodsSubbranch goodssubbranch = (GoodsSubbranch) q.list().get(0);
			session.delete(goodssubbranch);
		}
		tr.commit();
		session.close();
	}
	/**
	 * 根据subbranchId得到goodsId
	 * @param subbranchId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List querySubBrief(Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
	    Transaction tr = session.beginTransaction();
	    String sql = "select gs.goods.id from GoodsSubbranch gs where gs.subbranch.id=?";
	    Query q = session.createQuery(sql);
	    q.setParameter(0, subbranchId);
	    List list = q.list();
	    tr.commit();
	    session.close();
	    return list;
	}
	/**
	 * 概要商品下架,分店绑定删除
	 * @param goodsId
	 */
	public void downsubBriefGoods(Integer goodsId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gs from GoodsSubbranch gs where gs.goods.id=?";
		Query q =session.createQuery(sql);
		q.setParameter(0, goodsId);
		if(q.list().size()>0){
			GoodsSubbranch goodssubbranch = (GoodsSubbranch) q.list().get(0);
			session.delete(goodssubbranch);
		}
		tr.commit();
		session.close();
	}
}
