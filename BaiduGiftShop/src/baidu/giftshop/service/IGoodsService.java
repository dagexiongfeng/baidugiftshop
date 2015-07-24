package baidu.giftshop.service;

import java.util.List;

import baidu.giftshop.entity.Classify;


public interface IGoodsService {

	public String querySubbranch();
	public Integer querysubbranch(String subbranch);
	public String queryclassify();
	public void addClassify(String code,String name);
	public List<Classify> listallBrief();
	public Classify findById(Integer id);
	public Boolean Modify(Integer id,String code,String name);
	public String Delete(Integer id);
	public String AllClassify();
	public void subBundlclassify(Integer subbranchId,Integer classifyId);
	public String queryclassifyId(Integer subbranchId);
	public void deleteSubCla(Integer subbranchId);
	public String querySubClas(Integer subbranchId);
}
