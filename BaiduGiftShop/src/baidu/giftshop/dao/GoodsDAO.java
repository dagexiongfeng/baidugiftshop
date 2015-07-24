package baidu.giftshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.Classify;
import baidu.giftshop.entity.ClassifySubbranch;
import baidu.giftshop.entity.Subbranch;
import baidu.giftshop.util.HibernateSessionFactory;

public class GoodsDAO {

	Session session = HibernateSessionFactory.getSession();
	/**
	 * 显示数据库中的所有分店信息
	 * @return
	 */
	public List<Subbranch> querySubbranch() {
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		String sql = "from Subbranch";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Subbranch> list = q.list();
		return list;
	}
	/**
	 * 根据分店名得到分店的id
	 * @param subbranch
	 * @return
	 */
	public Integer querysubbranch(String subbranch){
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		String sql = "select s.id from Subbranch s where s.name=?";
		Query q = session.createQuery(sql);
        q.setParameter(0, subbranch);
		@SuppressWarnings("unchecked")
		List<Integer> list = q.list();
		Integer id = list.get(0);
		return id;
	}
	/**
	 * 返回分类表中最大的code
	 * @return
	 */
	public String queryclassify(){
		Transaction tr = session.beginTransaction();
		String sql ="select code from Classify where id=(select max(id) from Classify)";
		Query q = session.createQuery(sql);
		String code = (String) q.list().get(0);
		tr.commit();
		return code;
		}
	/**
	 * 增加一个分类信息
	 * @param code
	 * @param name
	 * @return
	 */
	public void addClassify(String code,String name){
		if(name!=null&&!"".equals(name.replace(" ", ""))){
		   Transaction tr = session.beginTransaction();
		   Classify classify = new Classify();
		   classify.setCode(code);
		   classify.setName(name);
		   session.save(classify);
		   tr.commit();
		   session.close();
		}
	}
	/**
	 * 得到全部的分类对象
	 * @return
	 */
	public List<Classify> listallBrief(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select c from Classify c";
		Query q = session.createQuery(sql);
		@SuppressWarnings({ "unchecked" })
		List<Classify> list = q.list();
		tr.commit();
		session.close();
		return list;
	}
	/**
	 * 根据分类的id得到分类的对象
	 * @param id
	 * @return
	 */
	public Classify findById(Integer id){
		Session session = HibernateSessionFactory.getSession();
		Classify classify = (Classify) session.get(Classify.class, id);
		session.close();
		return classify;
	}
	
	public Boolean Modify(Integer id,String code,String name){
		if(name!=null){
			 Session session = HibernateSessionFactory.getSession();
			 Transaction tr = session.beginTransaction();
		     Classify classify = (Classify) session.get(Classify.class, id);
		     classify.setName(name);
		     session.update(classify);
		     tr.commit();
		     session.close();
		     return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除分类ID
	 * @param <E>
	 * @param id
	 */
	@SuppressWarnings({ "unchecked" })
	public void Delete(Integer id){
		String hql = "select g.id,gp.id from Goods g,GoodsPicture gp where gp.goods=g and g.classify.id=?";
		Query qu = session.createQuery(hql);
		qu.setParameter(0, id);
	    List<Object[]> list = qu.list();
	    BriefGoodsDAO briefgoodsdao = new BriefGoodsDAO();
		for(int i = 0 ;i <list.size();i++){
			Object[] obj = list.get(i);
			Integer goods_id = (Integer)obj[0];
			briefgoodsdao.deleteBrief(goods_id);
		}
		Transaction tr = session.beginTransaction();
		Classify classify = (Classify) session.get(Classify.class, id);
		/*String sql ="select c from Classify c where c.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, id);
		Classify classify = (Classify) q.list().get(0);*/
		session.delete(classify);
		tr.commit();		
	}
	/**
	 * 分店绑定自己商店卖的商品分类
	 * @param subbranchId
	 * @param classifyId
	 */
	public void subBundlclassify(Integer subbranchId,Integer classifyId){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String sql = "select cs from ClassifySubbranch cs where cs.subbranch.id=? and cs.classify.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, subbranchId);
		q.setParameter(1, classifyId);
	 if(q.list().size()<1){
		Classify classify = (Classify) session.get(Classify.class, classifyId);
		Subbranch subbranch = (Subbranch) session.get(Subbranch.class, subbranchId);
		
		ClassifySubbranch classifysubbranch = new ClassifySubbranch();
		classifysubbranch.setClassify(classify);
		classifysubbranch.setSubbranch(subbranch);
		session.saveOrUpdate(classifysubbranch);
		}else{
		}
		tr.commit();
		session.close();
	}
	/**
	 * 删除该分店所绑定的分类信息
	 * @param subbranchId
	 */
	@SuppressWarnings("unchecked")
	public void deleteSubCla(Integer subbranchId){
		String sql = "select cs from ClassifySubbranch cs where cs.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, subbranchId);
		List<ClassifySubbranch> list = q.list();
		for(ClassifySubbranch cs : list){
			session.delete(cs);
		}
	}
	/**
	 * 根据subbranchId得到已绑定的分类Id队列
	 * @param subbranchId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	
	public List queryclassifyId(Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select cs.classify.id from ClassifySubbranch cs where cs.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, subbranchId);
		List list = q.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Classify> querySubClas(Integer subbranchId){
		Session session = HibernateSessionFactory.getSession();
		String sql = "select cs.classify from ClassifySubbranch cs where cs.subbranch.id=?";
		Query q = session.createQuery(sql);
		q.setParameter(0, subbranchId);
		List<Classify> list = q.list();
		session.close();
		return list;
	}
}
