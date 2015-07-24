package baidu.giftshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.GoodsDetailPicture;
import baidu.giftshop.util.HibernateSessionFactory;

public class PicGroupDAO {

	
	@SuppressWarnings("unchecked")
	public void deletegroup(Integer groupId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gdp from GoodsDetailPicture gdp where gdp.groupId=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, groupId);
		List<GoodsDetailPicture> list = q.list();
		for(GoodsDetailPicture goodsdetailpicture : list){
			session.delete(goodsdetailpicture);
		}
		tr.commit();
	}
	
	@SuppressWarnings("rawtypes")
	public List querythumbPathById(Integer groupId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select gdp.thumbPath from GoodsDetailPicture gdp where gdp.groupId=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, groupId);
		List list = q.list();
		tr.commit();
		return list;
	}
}
